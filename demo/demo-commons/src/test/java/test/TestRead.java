package test;

import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFReader;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 包名称： test
 * 类名称：TestRead
 * 类描述：TODO
 * 创建人：@author huangyuan
 * 创建时间：2019/12/18/11:42
 */
public class TestRead {

    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    //定义MySQL的数据库驱动程序,本程序用的是mysql-connector-java-8.0.12.jar
    public static final String DBURL = "jdbc:mysql://localhost:3306/ysstech?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
    //定义MySQL数据库的连接地址，格式：jdbc:mysql://IP地址:端口号/数据库名?字符集为utf-8&时区为GMT&SSL连接关闭
    public static final String DBUSER = "root";    //MySQL数据库的连接用户名
    public static final String DBPASS = "root";    //MySQL数据库的连接密码

    @Test
    public  void TestReadXml() throws Exception{



        File file = new File("D:/test");    //读取文件
        File[] files = file.listFiles();

        String id = "";
        String name = "";
        String password = "";
        for (int i=0;i<files.length;i++
             )
            if (files[i].isFile()) {
                String fileName = files[i].getName();

                int index = fileName.lastIndexOf(".");
                String lastName = fileName.substring(index, fileName.length());
                if (".xml".equals(lastName)) {
                    SAXReader reader = new SAXReader();    //建立SAX解析读取
                    Document doc = null;
                    try {
                        doc = reader.read(files[i]);    //读取文档
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }


                    Element root = doc.getRootElement();    //取得根元素
                    Iterator<Element> iter = root.elementIterator();    //取得全部的子节点
                    while (iter.hasNext()) {
                        Element linkman = iter.next();    //取得每一个linkman

                        id = linkman.elementText("id");
                        name = linkman.elementText("name");
                        password = linkman.elementText("password");
                        System.out.println("hhhhh" + id + name + password);

                    }
                } else if (".bdf".equals(lastName) ){


                    String path = files[i].getPath();
                    //读取文件的输入流
                    FileInputStream fileInputStream = new FileInputStream(path);
                    //根据输入流初始化一个DBFReader实例，用来读取DBF文件信息
                    DBFReader reader = new DBFReader(fileInputStream);
                    //设置字符集，避免中文乱码
                    reader.setCharactersetName("utf-8");

                    //获取dbf数据字段数量
                    int fieldsCount = reader.getFieldCount();


                    String fieldName;

                    StringBuffer params = new StringBuffer();
                    for( int x=0; x<fieldsCount; x++)
                    {
                        //依次获取字段名称
                        DBFField field = reader.getField(x);
                        fieldName = field.getName();
                        //连接每个字段名称
                        params.append(fieldName+",");

                    }
                    params.deleteCharAt(params.length()-1);
                    params.append(")");


                    Object[] rowValues;
                    for(int x=0;(rowValues = reader.nextRecord()) != null;x++)
                    {
                        StringBuffer values = new StringBuffer();
                        for( int j=0; j<rowValues.length; j++)
                        {
                            if(rowValues[j] == null)
                                values.append("null"+",");
                            else
                                values.append("'"+rowValues[j].toString().trim()+"',");
                        }
                        values.deleteCharAt(values.length()-1);
                        values.append(")");


                        //生成插入语句字符串

                        //重置每一行的数据
                        values.delete(0, values.length());
                        values.append("(");



                    }


                } else if (".xls".equals(lastName) || ".xlsx".equals(lastName)) {

                    String path = files[i].getPath();
                    // 创建对Excel工作簿文件的引用
                    HSSFWorkbook wookbook = new HSSFWorkbook(new FileInputStream(path));
                    // Excel的页签数量
                    int sheet_size = wookbook.getNumberOfSheets();
                    for (int ind = 0; ind < sheet_size; ind++) {
                        //List<List> outerList = new ArrayList<List>(
                        // );
                        // 每个页签创建一个Sheet对象
                        Sheet sheet = wookbook.getSheetAt(ind);

                        // sheet.getPhysicalNumberOfRows()返回该页的总行数
                        for (int row = sheet.getFirstRowNum(); row <= sheet.getLastRowNum(); row++) {
                            //List innerList = new ArrayList();
                            // 获取Row对象
                            Row row1 = sheet.getRow(row);
                            if (row1 == null || row1.getLastCellNum() < 0) {
                                break;
                            }
                            // sheet.getColumns()返回该页的总列数
                            for (int j = row1.getFirstCellNum(); j <= row1.getLastCellNum(); j++) {
                                Cell cell = row1.getCell(j);
                                if(cell!=null) {
                                    //按照文本的形式读取
								   cell.setCellType(CellType.STRING);
								   System.out.print(cell.getStringCellValue()+"\t");
                                }
                            }
                        }
                    }
                }


            }


        insertData(id, name, password);
    }

    private void insertData(String id, String name, String password) {
        Connection conn = null;    //数据库连接
        Statement stmt = null;    //数据库操作

        String sql = "INSERT INTO user (id,name,password)" + "VALUES('" + id + "','" + name + "','" + password+"')";   //插入数据操作，拼凑出一个完整的SQL语句

        try {
            Class.forName(DBDRIVER);    //加载驱动程序
            System.out.println("加载驱动程序成功！");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            System.out.println("连接数据库！");
            if (!conn.isClosed()) {
                System.out.println("Succeeded connecting to the Database!");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(conn);

        try {
            stmt = conn.createStatement();    //创建statement类对象，用来执行SQL语句
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }    //执行数据库更新操作

        try {
            stmt.close();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }    //操作关闭

        try {
            conn.close();    //数据库关闭
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

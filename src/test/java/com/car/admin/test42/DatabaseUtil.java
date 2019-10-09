package com.car.admin.test42;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo-restful
 * @description:
 * @author: zhanyh
 * @create: 2019-09-14 19:46
 **/
@Slf4j
public class DatabaseUtil {

    private final static Logger LOGGER = LoggerFactory.getLogger(DatabaseUtil.class);

    //JDBC连接Mysql   版本：5
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    //数据库地址
    //private static final String URL = "jdbc:mysql://localhost:3306/study?useUnicode=true&characterEncoding=utf8";
    private static final String URL = "jdbc:mysql://192.168.80.234:3306/easyepc3.0?characterEncoding=utf8&amp;useSSL=true&amp;serverTimezone=Asia/Shanghai";
    //数据密码
    //private static final String USERNAME = "root";
    private static final String USERNAME = "root";
    //数据账户
    //private static final String PASSWORD = "coot";
    private static final String PASSWORD = "123";
    //注意FROM后面有空格用来拼接表名！
    private static final String SQL = "SELECT * FROM ";// 数据库操作

    //获取字段信息
    private  static final String columns = "show full columns from ";

    //通过加载静态块和JAVA反射来通过JDBC连接数据库
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            LOGGER.error("无法加载JDBC驱动程序！", e);
        }
    }

    /**
     * 获取数据库连接
     * Connection  连接
     * @return
     */
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            LOGGER.error("获得（数据库）连接失败！", e);
        }
        return connection;
    }

    /**
     * 关闭数据库连接
     * @param connection
     */
    public static void closeConnection(Connection connection){
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error("关闭（数据库）连接失败！", e);
            }
        }
    }

    /**
     * 获取数据库下的所有表名
     */
    public static List<String> getTableNames() {
        List<String> tableNames = new ArrayList<>();
        Connection conn = getConnection();
        ResultSet rs = null;
        try {
            //获取数据库的元数据
            DatabaseMetaData db = conn.getMetaData();
            //从元数据中获取到所有的表名
            rs = db.getTables(null, null, null, new String[] { "TABLE" });
            while(rs.next()) {
                tableNames.add(rs.getString(3));
            }
        } catch (SQLException e) {
            LOGGER.error("调用getTableNames方法失败！", e);
        } finally {
            try {
                rs.close();
                closeConnection(conn);
            } catch (SQLException e) {
                LOGGER.error("关闭结果集失败！", e);
            }
        }
        return tableNames;
    }

    /**
     * 获取表中所有字段名称
     * @param tableName 表名
     * @return
     */
    public static List<String> getColumnNames(String tableName){
        List<String> columnNames = new ArrayList<>();
        //与数据库的连接
        Connection conn = getConnection();
        PreparedStatement pStemt = null;
        String tableSql = SQL + tableName;

        try {
             pStemt = conn.prepareStatement(tableSql);
            //结果集元数据
            ResultSetMetaData metaData = pStemt.getMetaData();
            //表列数
            int count = metaData.getColumnCount();
            //根据表的列数将表的所有字段名称放入List集合。
            for (int i = 0; i < count; i++) {
                columnNames.add(metaData.getColumnName(i + 1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error("getcolumnname方法执行失败", e);
            log.error(e.getMessage());
        }finally {
            if(pStemt!=null){
                try {
                    pStemt.close();
                    //pStemt = null;
                    //关闭数据库连接closeConnection();
                    closeConnection(conn);
                } catch (SQLException e) {
                    e.printStackTrace();
                    LOGGER.error("getColumnNames关闭pstem连接失败", e);
                }
            }
        }
        return columnNames;
    }

    /**
     * 获取表中所有字段类型
     * @param tableName
     * @return
     */
    public static List<String> getColumnTypes(String tableName){
        List<String> columnTypes = new ArrayList<>();
        //与数据库的连接
        Connection conn = getConnection();
        PreparedStatement pStemt = null;
        String tableSql = SQL + tableName;

        try {
             pStemt = conn.prepareStatement(tableSql);
            //结果集元数据
            ResultSetMetaData metaData = pStemt.getMetaData();
            //表列数
            int count = metaData.getColumnCount();
            //根据表的列数将表的所有字段类型放入List集合。
            for (int i = 0; i < count; i++) {
                columnTypes.add(metaData.getColumnTypeName(i + 1));
            }
        } catch (SQLException e) {
            LOGGER.error("getColumnTypes方法执行失败！", e);
        }finally {
            if(pStemt!=null){
                try {
                    pStemt.close();
                    //pStemt = null;
                    //关闭数据库连接closeConnection();
                    closeConnection(conn);
                } catch (SQLException e) {
                    e.printStackTrace();
                    LOGGER.error("getColumnTypes关闭pstem连接失败", e);
                }
            }
        }
        return columnTypes;
    }

    /**
     * 获取表中字段的所有注释
     * @param tableName
     * @return
     */
   public static List<String> getColumnComments(String tableName){
        //列名注释集合
        List<String> columnComments = new ArrayList<>();
        //与数据库的连接
        Connection conn = getConnection();
        PreparedStatement pStemt = null;
        String tableSql = SQL + tableName;
        ResultSet rs = null;

        try {
            pStemt = conn.prepareStatement(tableSql);
            //rs = pStemt.executeQuery("show full columns from " + tableName);
            rs = pStemt.executeQuery(columns + tableName);
            //使用while循环判断rs有下一个才进行循环,将之放入定义好的List中
            while (rs.next()){
                //Comment：字段描述的关键词
                columnComments.add(rs.getString("Comment"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                    //rs = null;
                    //关闭数据库连接closeConnection();
                    closeConnection(conn);
                } catch (SQLException e) {
                    LOGGER.error("getColumnComments关闭ResultSet连接失败！", e);
                }
            }
        }
        return columnComments;
    }

  /*  public static void main(String[] args) {
        //获取所有表名
        List<String> tableNames = getTableNames();
        tableNames.forEach(System.out::println);

        //获取表中所有的字段的名称   users为表名！
        List<String> columnNames = getColumnNames("users");
        columnNames.forEach(System.out::println);

        //获取表中所有的字段的类型   users为表名！
        List<String> columnTypes = getColumnTypes("users");
        columnTypes.forEach(System.out::println);

        //获取表中字段的所有注释
        List<String> columnComments = getColumnComments("users");
        columnComments.forEach(System.out::println);
    }*/

    public static void main(String[] args) {
        //调用获取数据库下的所有表名的方法
        List<String> tableNames = getTableNames();

        System.out.println("tableNames（所有表名）:" + tableNames);
        for (String tableName : tableNames) {
            //调用获取表中所有字段名称的方法
            System.out.println("ColumnNames（所有字段名称）:" + getColumnNames(tableName));
            //调用获取表中所有字段类型的方法
            System.out.println("ColumnTypes（所有字段类型）:" + getColumnTypes(tableName));
            //调用获取表中字段的所有注释的方法
            System.out.println("ColumnComments（所有字段注释）:" + getColumnComments(tableName));
        }
    }

}

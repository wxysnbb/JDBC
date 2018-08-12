package cn.wd.util;

import java.sql.*;

public class BaseDao {
    protected Connection connection;    //连接
    protected PreparedStatement ps; //执行sql语句
    protected ResultSet rs; //返回结果集

    //连接数据库
    public boolean getConnection(){
        try {
            //加载驱动
            Class.forName(ConfigManager.getValue("jdbc.driver"));
            connection= DriverManager.getConnection(ConfigManager.getValue("jdbc.url"),
                    ConfigManager.getValue("jdbc.username"),
                    ConfigManager.getValue("jdbc.password"));
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //增删改
    public int executeUpdate(String sql, Object...obj){
        int num=0;
        if(getConnection()){
            try {
                ps=connection.prepareStatement(sql);
                if(obj!=null){//有参数  有几个
                    for (int i = 0; i <obj.length ; i++) {
                        ps.setObject(i+1,obj[i]);
                    }
                }
                num=ps.executeUpdate();//调用底层代码
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                closeConnection();//释放资源
            }
        }
        return num;
    }

    public  ResultSet executeQuery(String sql,Object...obj){
        if(getConnection()){
            try {
                ps=connection.prepareStatement(sql);
                if(obj!=null){//有参数  有几个
                    for (int i = 0; i <obj.length ; i++) {
                        ps.setObject(i+1,obj[i]);
                    }
                }
                rs=ps.executeQuery();//调用底层代码
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }


    public void closeConnection() {
        try {
            if(rs!=null){
                rs.close();//释放结果集
            }
            if(ps!=null){
                ps.close();//释放结果集
            }
            if(connection!=null){
                connection.close();//释放结果集
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

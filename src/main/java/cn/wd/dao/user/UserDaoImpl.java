package cn.wd.dao.user;

import cn.wd.entity.User;
import cn.wd.util.BaseDao;
import cn.wd.util.PageUtil;
import cn.wd.util.ResultSetUtil;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {


    @Override
    public String validateName(String userName) {
        String sql = "SELECT upwd FROM news_userinfo WHERE uname= ?";

        System.out.println(userName+"[][][]");
        rs = executeQuery(sql, userName);
        System.out.println(7889);
        String password = null;
        try { //获取密码
            if (rs.next()) {
                password = rs.getString("upwd");
                System.out.println("sss我我把教案本文件");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }

    /**
     * 登录
     */
    @Override
    public User login(String userName, String password) {
        String sql="SELECT id as users_id,userName,PASSWORD,email,userType FROM news_user where userName=? and password=?";
        Object [] params={userName,password};
        rs=executeQuery(sql,params);
        User user= ResultSetUtil.eachOne(rs,User.class);
        return user;
    }

    @Override
    public int add(User user) {
        String sql = "INSERT INTO news_userinfo(uname,upwd) VALUES(?,?)";
        Object[] obj = {user.getUname(),user.getUpwd()};
        return executeUpdate(sql, obj);
    }

    @Override
    public int deleteByCondition(Serializable id) {
        String sql="delete from news_userinfo where uid=?";
        int num= executeUpdate(sql,id);
        return num;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public User findByCondition(Serializable id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    /**
     * 查询总记录数
     */
    @Override
    public int findrownum() {
        String sql="SELECT COUNT(uid) AS COUNT FROM news_userinfo";
        rs=executeQuery(sql);
        int count=0;
        try {
            if (rs.next()){
                count= rs.getInt("count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<User> findAllByPage(PageUtil util, Object... obj) {
        String sql="SELECT uid,uname,upwd FROM news_userinfo LIMIT ?,?";
        Object[] p={(util.getPageIndex()-1)*util.getPageSize(),util.getPageSize()};
        rs= executeQuery(sql,p);
        List<User>  list= ResultSetUtil.eachList(rs,User.class);
        return list;
    }
}


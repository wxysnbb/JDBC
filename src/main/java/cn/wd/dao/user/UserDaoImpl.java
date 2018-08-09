package wd.dao.user;

import wd.entity.User;
import wd.util.BaseDao;
import wd.util.PageUtil;

import java.io.Serializable;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public int add(User user) {
        String sql="INSERT INTO news_userinfo(uname,upwd) VALUES(?,?)";
        Object[]obj={user.getUname(),user.getUpwd()};
        return executeUpdate(sql,obj);
    }

    @Override
    public int deleteByCondition(Serializable id) {
        return 0;
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

    @Override
    public int findrownum() {
        return 0;
    }

    @Override
    public List<User> findAllByPage(PageUtil util, Object... obj) {
        return null;
    }
}

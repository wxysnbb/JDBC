package wd.service.user;

import wd.dao.user.UserDao;
import wd.dao.user.UserDaoImpl;
import wd.entity.User;
import wd.util.PageUtil;

import java.io.Serializable;
import java.util.List;

/**
 * 在不改变dao层代码的前提下，做一些业务逻辑
 * 增强处理===》增加系统级业务
 */
public class UserServiceImpl implements UserService {

    //耦合 加上 静态代理
    private UserDao userDao=new UserDaoImpl();


    @Override
    public int add(User user) {
        return userDao.add(user);
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

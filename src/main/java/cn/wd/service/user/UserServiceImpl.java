package cn.wd.service.user;

import cn.wd.dao.user.UserDao;
import cn.wd.dao.user.UserDaoImpl;
import cn.wd.entity.User;
import cn.wd.util.PageUtil;

import java.io.Serializable;
import java.util.List;

/**
 * 在不改变dao层代码的前提下，做一些业务逻辑
 * 增强处理===》增加系统级业务
 */
public class UserServiceImpl implements UserService {

    //耦合 加上 静态代理
    private UserDao userDao=new UserDaoImpl();

    /**
     * 注册
     */
    @Override
    public int add(User user) {
        return userDao.add(user);
    }

    /**
     * 验证用户名是否存在
     */
    @Override
    public String validateName(String userName) {
        return userDao.validateName(userName);
    }

    /**
     * 登录
     */
    @Override
    public User login(String userName, String password) {
        return userDao.login(userName,password);
    }


    @Override
    public int deleteByCondition(Serializable id) {
        return userDao.deleteByCondition(id);
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
        return userDao.findrownum();
    }

    @Override
    public List<User> findAllByPage(PageUtil util, Object... obj) {
        return userDao.findAllByPage(util,obj);
    }

}

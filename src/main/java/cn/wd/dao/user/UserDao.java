package cn.wd.dao.user;

import cn.wd.dao.IBaseDao;
import cn.wd.entity.User;



/**
 * 书写自己特有的功能
 */
public interface UserDao extends IBaseDao<User> {
    /**
     * 验证用户名登录的操作
     */
    String validateName(String userName);
    User login(String userName, String password);
}

package cn.wd.service.user;

import cn.wd.entity.User;
import cn.wd.service.IBaseService;


public interface UserService extends IBaseService<User> {
    String validateName(String userName);

    User login(String userName, String password);

}

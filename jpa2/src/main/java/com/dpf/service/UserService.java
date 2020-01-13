package com.dpf.service;



import com.dpf.bean.User;

import java.util.List;

/**
 * @author dpf
 * @create 2019-12-27 15:24
 * @email 446933040@qq.com
 */
public interface UserService {

    List<User> getUserList();
    User findUserById(long id);
    void save(User user);
    void edit(User user);
    void delete(long id);


}

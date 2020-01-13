package com.dpf.repository2;


import com.dpf.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dpf
 * @create 2019-12-27 15:14
 * @email 446933040@qq.com
 */
public interface UserRepository2 extends JpaRepository<User,Long> {
    User findById(long id);

}

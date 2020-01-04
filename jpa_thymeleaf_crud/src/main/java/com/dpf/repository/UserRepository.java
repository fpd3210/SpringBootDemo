package com.dpf.repository;

import com.dpf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dpf
 * @create 2019-12-27 15:14
 * @email 446933040@qq.com
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findById(long id);

}

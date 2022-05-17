package com.dpf.cache.repository;

import com.dpf.cache.domain.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Pikachues
 * Created 2022/5/17
 */
public interface UserRepository extends JpaRepository<User,Long> {
}

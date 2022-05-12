package com.dpf.mongo.mongo.repository;

import com.dpf.mongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Pikachues
 * Created 2022/5/1
 */
@Repository
public interface UserRepository extends MongoRepository<User,String> {
}

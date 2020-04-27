package com.dpf.repository;

import com.dpf.bean.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author dpf
 * @create 2020-01-14 12:32
 * @email 446933040@qq.com
 */
public interface BookRepository extends MongoRepository<Book,Integer> {
}

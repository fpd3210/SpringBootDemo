package com.dpf.dao;

import com.dpf.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * @author dpf
 * @create 2020-01-14 10:55
 * @email 446933040@qq.com
 */
@RepositoryRestResource(path = "bs",collectionResourceRel = "bsList",itemResourceRel = "bsItem")
public interface BookRepository extends JpaRepository<Book,Integer> {
    @RestResource(path = "byauthor",rel = "byauthor")
    List<Book> findBookByAuthorContaining(@Param("author") String author);

    @Override
    @RestResource(exported = false)
    void deleteById(Integer id);
}

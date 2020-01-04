package com.dpf.controller;

import com.dpf.entity.Author;
import com.dpf.entity.Book;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dpf
 * @create 2020-01-04 16:30
 * @email 446933040@qq.com
 */
@RestController
public class BookController {

    @PostMapping("/save")
    public void save(@ModelAttribute("b") Book book, @ModelAttribute("a") Author author){

        System.out.println(book);
        System.out.println(author);
    }
}

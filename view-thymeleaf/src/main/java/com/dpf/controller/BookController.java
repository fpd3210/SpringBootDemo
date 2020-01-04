package com.dpf.controller;


import com.dpf.bean.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    @GetMapping("/book")
    public String book(Model model) {
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setId(i);
            book.setName("三国演义:" + i);
            book.setAuthor("罗贯中:" + i);
            book.setPrice(30.0);
            bookList.add(book);
        }
        model.addAttribute("books", bookList);
        return "book";
    }
}

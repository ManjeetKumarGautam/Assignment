package com.manjeet.EncompassesHandling.Controller;

import com.manjeet.EncompassesHandling.model.Address;
import com.manjeet.EncompassesHandling.model.Book;
import com.manjeet.EncompassesHandling.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping
    public String addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("/id/{id}")
    public Book getBookById(@PathVariable String id){
        return bookService.getBook(id);
    }

    @PutMapping("/id/{id}")
    public String updateBook(@PathVariable String id,@RequestParam String columnName,@RequestParam String val){
        return bookService.updateBook(id,columnName,val);
    }

    @DeleteMapping("/id/{id}")
    public  String deleteBook(@PathVariable String id){
        return bookService.deleteBook(id);
    }
}

package com.manjeet.EncompassesHandling.service;

import com.manjeet.EncompassesHandling.model.Address;
import com.manjeet.EncompassesHandling.model.Book;
import com.manjeet.EncompassesHandling.repo.IBookRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    IBookRepo bookRepo;

    public String addBook(Book book) {
        bookRepo.save(book);
        return "Added...";
    }

    public Book getBook(String id) {
    return bookRepo.findById(id).get();
    }

    @Transactional
    public String updateBook(String id, String columnName, String val) {
        if(bookRepo.existsById(id)){
            if(columnName.equals("title")){
                bookRepo.updateTitle(id,val);
            }
            else if(columnName.equals("author")){
                bookRepo.updateAuthor(id,val);
            }
            else if(columnName.equals("description")){
                bookRepo.updateDescription(id,val);
            }
            else if (columnName.equals("price")) {
                bookRepo.updatePrice(id,val);
            }

            return "Update...";
        }
        return "Invalid id...";

    }

    public String deleteBook(String id) {
        bookRepo.deleteById(id);
        return "Deleted...";
    }
}

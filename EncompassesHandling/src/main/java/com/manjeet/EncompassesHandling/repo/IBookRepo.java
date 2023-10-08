package com.manjeet.EncompassesHandling.repo;

import com.manjeet.EncompassesHandling.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IBookRepo extends JpaRepository<Book,String> {

    @Modifying
    @Query(value = "update book set title= :val where id= :id",nativeQuery = true)
    void updateTitle(String id, String val);

    @Modifying
    @Query(value = "update book set author= :val where id= :id",nativeQuery = true)
    void updateAuthor(String id, String val);

    @Modifying
    @Query(value = "update book set description= :val where id= :id",nativeQuery = true)
    void updateDescription(String id, String val);

    @Modifying
    @Query(value = "update book set price= :val where id= :id",nativeQuery = true)
    void updatePrice(String id, String val);
}

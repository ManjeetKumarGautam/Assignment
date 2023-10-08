package com.manjeet.EncompassesHandling.repo;

import com.manjeet.EncompassesHandling.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ILaptopRepo extends JpaRepository<Laptop,String> {

    @Modifying
    @Query(value = "update laptop set name= :val where id= :id",nativeQuery = true)
    void updateName(String id, String val);

    @Modifying
    @Query(value = "update laptop set brand= :val where id= :id",nativeQuery = true)
    void updateBrand(String id, String val);

    @Modifying
    @Query(value = "update laptop set price= :val where id= :id",nativeQuery = true)
    void updatePrice(String id, String val);
}

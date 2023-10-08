package com.manjeet.EncompassesHandling.repo;

import com.manjeet.EncompassesHandling.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IStudentRepo extends JpaRepository<Student,String> {

    @Modifying
    @Query(value = "update student set name= :val where id= :id",nativeQuery = true)
    void updateName(String id, String val);

    @Modifying
    @Query(value = "update student set age= :val where id= :id",nativeQuery = true)
    void updateAge(String id, String val);

    @Modifying
    @Query(value = "update student set phoneNumber= :val where id= :id",nativeQuery = true)
    void updatePhoneNumber(String id, String val);

    @Modifying
    @Query(value = "update student set branch= :val where id= :id",nativeQuery = true)
    void updateBranch(String id, String val);

    @Modifying
    @Query(value = "update student set department= :val where id= :id",nativeQuery = true)
    void updateDepartment(String id, String val);
}

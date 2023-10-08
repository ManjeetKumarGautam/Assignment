package com.manjeet.EncompassesHandling.repo;

import com.manjeet.EncompassesHandling.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ICourseRepo extends JpaRepository<Course,String> {

    @Modifying
    @Query(value = "update course set title= :val where id= :id",nativeQuery = true)
    void updateTitle(String id, String val);

    @Modifying
    @Query(value = "update course set description= :val where id= :id",nativeQuery = true)
    void updateDescription(String id, String val);

    @Modifying
    @Query(value = "update book set duration= :val where id= :id",nativeQuery = true)
    void updateDuration(String id, String val);
}

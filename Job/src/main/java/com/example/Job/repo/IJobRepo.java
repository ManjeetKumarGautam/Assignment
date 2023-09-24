package com.example.Job.repo;

import com.example.Job.model.Job;
import com.example.Job.model.Type;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJobRepo extends CrudRepository<Job,Long> {
    List<Job> findByLocation(String Location);

    List<Job> findByJobType(Type jobType);

    List<Job> findByTitleAndSalaryGreaterThanEqual(String title, Double salary);

    List<Job> findBySalaryGreaterThanEqual(Double salary);

    @Modifying
    @Query(value = "update job set salary=(:salary) where id=(:id)" , nativeQuery = true)
    void updateSalaryById(Long id, Double salary);

    @Modifying
    @Query(value = "delete from job where jobType=(:jobType)" , nativeQuery = true)
    void deleteJobByType(Type jobType);

    @Modifying
    @Query(value = "select * from job where title= (:title) " , nativeQuery = true)
    List<Job> getJobByTitle(String title);

    @Modifying
    @Query(value = "select * from job where description=(:desc)" , nativeQuery = true)
    List<Job> getJobByDescription(String desc);
}

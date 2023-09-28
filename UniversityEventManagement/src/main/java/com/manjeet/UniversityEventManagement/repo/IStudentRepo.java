package com.manjeet.UniversityEventManagement.repo;

import com.manjeet.UniversityEventManagement.model.Department;
import com.manjeet.UniversityEventManagement.model.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepo extends CrudRepository<Student, Long> {
    @Modifying
    @Query(value = "UPDATE student  SET department= :department where student_id= :id", nativeQuery = true)
    void updateStudentDepartment(@Param("id") Long id,@Param("department") String department);
}

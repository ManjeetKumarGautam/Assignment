package com.manjeet.EmployeeAddress.repo;

import com.manjeet.EmployeeAddress.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IEmployeeRepo extends JpaRepository<Employee,Long> {

    @Modifying
    @Query(value = "UPDATE employee SET first_name = :val where emp_id= :id",nativeQuery = true)
    void updateFirstName(String val, Long id);

    @Modifying
    @Query(value = "UPDATE employee SET last_name = :val where emp_id= :id",nativeQuery = true)
    void updateLastName(String val, Long id);

    @Modifying
    @Query(value = "UPDATE employee SET fk_address_id = :val where emp_id= :id",nativeQuery = true)
    void updateAddressId(Long val, Long id);
}

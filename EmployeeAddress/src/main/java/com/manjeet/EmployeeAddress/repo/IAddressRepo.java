package com.manjeet.EmployeeAddress.repo;

import com.manjeet.EmployeeAddress.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IAddressRepo extends JpaRepository<Address,Long> {


    @Modifying
    @Query(value = "UPDATE address SET street = :val where add_id = :id",nativeQuery = true)
    void updateStreet(String val, Long id);

    @Modifying
    @Query(value = "UPDATE address SET city = :val where add_id = :id",nativeQuery = true)
    void updateCity(String val, Long id);

    @Modifying
    @Query(value = "UPDATE address SET state = :val where add_id = :id",nativeQuery = true)
    void updateState(String val, Long id);

    @Modifying
    @Query(value = "UPDATE address SET zipcode = :val where add_id = :id",nativeQuery = true)
    void updateZipcode(String val, Long id);
}

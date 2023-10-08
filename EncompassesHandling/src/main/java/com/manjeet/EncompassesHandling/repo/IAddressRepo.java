package com.manjeet.EncompassesHandling.repo;

import com.manjeet.EncompassesHandling.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IAddressRepo extends JpaRepository<Address,Long> {

    @Modifying
    @Query(value = "update address set landmark= :val where address_id= :id",nativeQuery = true)
    void updateLandmark(Long id, String val);

    @Modifying
    @Query(value = "update address set zipcode= :val where address_id= :id",nativeQuery = true)
    void updateZipcode(Long id, String val);

    @Modifying
    @Query(value = "update address set district= :val where address_id= :id",nativeQuery = true)
    void updateDistrict(Long id, String val);

    @Modifying
    @Query(value = "update address set state= :val where address_id= :id",nativeQuery = true)
    void updateState(Long id, String val);

    @Modifying
    @Query(value = "update address set country= :val where address_id= :id",nativeQuery = true)
    void updateCountry(Long id, String val);
}

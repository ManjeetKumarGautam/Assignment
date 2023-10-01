package com.manjeet.EcommerceAPI.repo;

import com.manjeet.EcommerceAPI.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepo extends JpaRepository<Address, Integer> {

}

package com.bessaleks.internetprovider.repository;

import com.bessaleks.internetprovider.entity.Address;
import com.bessaleks.internetprovider.entity.OperationsHistory;
import com.bessaleks.internetprovider.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address,Long> {
    List<Address> findByUser(User user);
}

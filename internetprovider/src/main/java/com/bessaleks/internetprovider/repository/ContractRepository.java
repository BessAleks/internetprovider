package com.bessaleks.internetprovider.repository;

import com.bessaleks.internetprovider.entity.Contract;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends CrudRepository<Contract,Long> {
    Contract findByNumber(String number);
    boolean existsByNumber(String number);
    Contract deleteByNumber(String number);
}

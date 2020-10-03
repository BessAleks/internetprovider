package com.bessaleks.internetprovider.repository;

import com.bessaleks.internetprovider.entity.Contract;
import org.springframework.data.repository.CrudRepository;

public interface ContractRepository extends CrudRepository<Contract,Long> {
    Contract findByNumber(String number);
    boolean existsByNumber(String number);
    Contract deleteByNumber(String number);
}

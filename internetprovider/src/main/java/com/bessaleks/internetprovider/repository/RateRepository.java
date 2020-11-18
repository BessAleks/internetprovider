package com.bessaleks.internetprovider.repository;

import com.bessaleks.internetprovider.entity.Rate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends CrudRepository<Rate,Long> {
    Rate findByRateName(String rateName);
    boolean existsByRateName(String rateName);
    Rate deleteByRateName(String rateName);
}

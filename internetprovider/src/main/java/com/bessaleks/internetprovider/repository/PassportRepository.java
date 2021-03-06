package com.bessaleks.internetprovider.repository;

import com.bessaleks.internetprovider.entity.Passport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends CrudRepository<Passport,Long> {
    Passport findByPassportNumber(Long passportNumber);
    boolean existsByPassportNumber(Long passportNumber);
    Passport deleteByPassportNumber(Long passportNumber);
}

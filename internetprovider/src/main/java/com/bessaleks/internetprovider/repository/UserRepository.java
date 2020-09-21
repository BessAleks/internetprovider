package com.bessaleks.internetprovider.repository;

import com.bessaleks.internetprovider.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository <User, Long> {
    List <User> findByLogin(String userLogin);
    boolean existsByLogin(String userLogin);

}

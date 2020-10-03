package com.bessaleks.internetprovider.repository;

import com.bessaleks.internetprovider.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Long> {
    User findByLogin(String userLogin);
    boolean existsByLogin(String userLogin);
    User deleteByLogin(String login);
}

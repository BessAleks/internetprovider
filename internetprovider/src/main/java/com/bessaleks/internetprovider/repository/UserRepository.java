package com.bessaleks.internetprovider.repository;

import com.bessaleks.internetprovider.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository <User, Long> {
    Optional<Object> findByEmail(String username);
}

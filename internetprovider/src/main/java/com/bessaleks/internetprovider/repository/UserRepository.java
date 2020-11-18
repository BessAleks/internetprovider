package com.bessaleks.internetprovider.repository;

import com.bessaleks.internetprovider.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository <User, Long> {
    Optional<Object> findByEmail(String username);
}

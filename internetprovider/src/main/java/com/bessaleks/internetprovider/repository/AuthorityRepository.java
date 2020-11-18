package com.bessaleks.internetprovider.repository;

import com.bessaleks.internetprovider.entity.UserAuthority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface AuthorityRepository extends CrudRepository<UserAuthority, Long> {
    UserAuthority findByAuthority(String authority);
}

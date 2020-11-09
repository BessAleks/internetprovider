package com.bessaleks.internetprovider.repository;

import com.bessaleks.internetprovider.entity.CustomUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<CustomUserDetails, Long> {
    Optional<UserDetails> findByUsername(String username);
}

package com.bessaleks.internetprovider.servises.token;

import org.springframework.security.core.userdetails.UserDetails;

public interface TokenService {
    String generateToken(UserDetails userDetails);
    UserDetails extractUserDetails(String token);
}

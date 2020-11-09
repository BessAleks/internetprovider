package com.bessaleks.internetprovider.servises.token.impl;

import com.bessaleks.internetprovider.servises.token.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TokenServiceImpl implements TokenService {
    @Override
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        List<String> authorities = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        claims.put("authorities", authorities);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS512, "secret")
                .compact();
    }

    @Override
    public UserDetails extractUserDetails(String token) {
        Claims claims = getAllClaimFromToken(token);
        Collection<? extends GrantedAuthority> authorities = extractAuthorities(claims);
        return new User(
                claims.getSubject(),
                "",
                authorities
        );
    }

    private Claims getAllClaimFromToken(String token) {
        return Jwts.parser().setSigningKey("secret").parseClaimsJws(token).getBody();
    }

    private Collection<? extends GrantedAuthority> extractAuthorities(Claims claims) {
        Collection<String> authorities = (Collection<String>) claims.getOrDefault("authorities", new ArrayList<>());
        return authorities.stream().map(authority -> (GrantedAuthority) () -> authority).collect(Collectors.toList());
    }
}

package com.bessaleks.internetprovider.entity;

import lombok.Getter;
import lombok.Setter;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "user_authority")
public class UserAuthority extends BaseEntity implements GrantedAuthority {
    @Column(name = "authority")
    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }
}

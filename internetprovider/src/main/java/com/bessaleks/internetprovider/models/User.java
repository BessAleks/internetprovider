package com.bessaleks.internetprovider.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@Table (name="users")
public class User extends BaseEntity{

    @NotBlank
    @Column(name="user_login")
    String login;

    @NotBlank
    @Column(name="user_password")
    String password;

    @NotBlank
    /*@Email*/
    @Column(name="user_email")
    String email;

    @NotBlank
    /*@Pattern(regexp = "\\+7[0-9]{10}")*/
    @Column(name="user_phone")
    String phone;

    @NotBlank
    @Column(name="user_balanse")
    Double balanse;

    @NotBlank
    @JoinColumn(name="passport_id")
    @OneToOne(optional=false, cascade=CascadeType.ALL)
    @JoinTable(name = "passports")
    Passport passport;

    @NotBlank
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Collection<Address> addresses;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Collection <OperationsHistory> operationsHistories;

}

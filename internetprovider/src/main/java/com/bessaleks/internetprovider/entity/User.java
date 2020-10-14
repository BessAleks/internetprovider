package com.bessaleks.internetprovider.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name="users")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "user_id"))})
public class User extends BaseEntity {

    @Column(name="user_login")
    private String login;

    @Column(name="user_password")
    private String password;

    /*@Email*/
    @Column(name="user_email")
    private String email;

    /*@Pattern(regexp = "\\+7[0-9]{10}")*/
    @Column(name="user_phone")
    private String phone;

    @Column(name="user_balanse")
    private Double balanse;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Passport passport;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private Set<Address> addresses = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private Set <OperationsHistory> operationsHistories = new HashSet<>();

    public void setPassword(String password) {
        this.password = md5Apache(password);
    }

    public static String md5Apache(String st) {
        String md5Hex = DigestUtils.md5Hex(st);
        return md5Hex;
    }
}

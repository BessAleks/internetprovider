package com.bessaleks.internetprovider.entity;

import com.bessaleks.internetprovider.enums.UserType;
import lombok.*;
import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name="users")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "user_id"))})
//@EqualsAndHashCode(callSuper = true, exclude = "billingDetails")
//@ToString(exclude = "billingDetails", callSuper = true)
@EntityListeners(value = UserEntityListener.class)
public class User extends BaseEntity {

    /*@Email*/
    @Column(name="user_email")
    private String email;

    /*@Pattern(regexp = "\\+7[0-9]{10}")*/
    @Column(name="user_phone")
    private String phone;

    @Column(name="user_balanse")
    private BigDecimal balanse;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Passport passport;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private Set<Address> addresses = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private Set <OperationsHistory> operationsHistories = new HashSet<>();

    @Column(name = "user_type")
    @Enumerated(value = EnumType.STRING)
    private UserType userType = UserType.ORDINAL;

    @Transient
    private String inMemory;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CustomUserDetails customUserDetails;

    /*public void setPassword(String password) {
        this.password = md5Apache(password);
    }*/

    public static String md5Apache(String st) {
        String md5Hex = DigestUtils.md5Hex(st);
        return md5Hex;
    }
}

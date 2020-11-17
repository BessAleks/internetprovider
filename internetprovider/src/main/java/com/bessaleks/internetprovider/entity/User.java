package com.bessaleks.internetprovider.entity;

import com.bessaleks.internetprovider.enums.UserType;
import lombok.*;
import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name="users")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "user_id"))})
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email);
    }
}

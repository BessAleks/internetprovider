package com.bessaleks.internetprovider.entity;

import com.bessaleks.internetprovider.enums.Sex;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name="passports")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "passport_id"))})
public class Passport extends BaseEntity {

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @Column(name="user_name")
    private String name;

    @Column(name="user_surname")
    private String surname;

    @Column(name="user_last_name")
    private String lastName;

    /*@Pattern(regexp = "\\[0-9]{10}")*/
    @Column(name="passport_passport_number")
    private Long passportNumber;

    @Column(name="passport_passport_issued_by")
    private String passportIssuedBy;

    @Column(name="passport_passport_issued")
    private LocalDateTime passportIssued;

    @Column(name="passport_birthday")
    private LocalDateTime birthday;

    @Column(name="passport_sex")
    @Enumerated(value = EnumType.STRING)
    private Sex sex;

}

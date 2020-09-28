package com.bessaleks.internetprovider.dto;


import com.bessaleks.internetprovider.enums.Sex;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name="passports")
public class PassportDto extends BaseEntityDto {

    @OneToOne(fetch= FetchType.LAZY, cascade=CascadeType.ALL)
    private UserDto userDto;

    @NotBlank
    @OneToOne
    @MapsId
    @JoinColumn(name="addressId")
    private AddressDto addressDto;

    @Column(name="user_name")
    private String name;

    @Column(name="user_surname")
    private String surname;

    @Column(name="user_lastName")
    private String lastName;

    @Column(name="passport_passportNumber")
    private Long passportNumber;

    @Column(name="passport_passportIssuedBy")
    private String passportIssuedBy;

    @Column(name="passport_passportIssued")
    private Date passportIssued;

    @Column(name="passport_birthday")
    private Date birthday;

    @Column(name="passport_sex")
    private Sex sex;

}

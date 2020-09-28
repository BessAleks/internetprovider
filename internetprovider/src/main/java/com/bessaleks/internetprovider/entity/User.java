package com.bessaleks.internetprovider.dto;

import com.bessaleks.internetprovider.servises.UserService;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name="users")
public class UserDto extends BaseEntityDto {

    @NotBlank
    @Column(name="user_login")
    private String login;

    @NotBlank
    @Column(name="user_password")
    private String password;

    @NotBlank
    /*@Email*/
    @Column(name="user_email")
    private String email;

    @NotBlank
    /*@Pattern(regexp = "\\+7[0-9]{10}")*/
    @Column(name="user_phone")
    private String phone;

    @NotBlank
    @Column(name="user_balanse")
    private Double balanse;

    @NotBlank
    @OneToOne
    @MapsId
    @JoinColumn(name="passportId")
    private PassportDto passportDto;

    /*@NotBlank
    @OneToOne
    @MapsId
    @JoinColumn(name="addressId")
    private Address address;

    /*@NotBlank
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set <OperationsHistory> operationsHistories;*/

    public void setPassword(String password) {
        this.password = UserService.md5Apache(password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserDto userDto = (UserDto) o;
        return login.equals(userDto.login) &&
                password.equals(userDto.password) &&
                email.equals(userDto.email) &&
                phone.equals(userDto.phone) &&
                passportDto.equals(userDto.passportDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), login, password, email, phone, passportDto);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", balanse=" + balanse +
                '}';
    }
}

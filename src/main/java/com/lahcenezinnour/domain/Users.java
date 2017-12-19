package com.lahcenezinnour.domain;

import lombok.*;

import javax.persistence.*;

/**
 * Created by lahcen on 4/5/17.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class Users {
    @Id
    @GeneratedValue
    @Column(name = "UserID")
    private int userId;

    @Column(name = "UserEmail")
    private String userEmail;
    //@Size(min=4, max=35)
    @Column(name = "UserFirstName")
    private String userFirstName;

    @Column(name = "UserLastName")
    private String userLastName;

    @Column(name = "UserPassword")
    private String userPassword;

    @Transient
    private String userPasswordConfirm;

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userEmail='" + userEmail + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPasswordConfirm='" + userPasswordConfirm + '\'' +
                '}';
    }
}

package com.andygomez.dto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @NotEmpty(message = " The name is required")
    @Column(name = "user_name")
    private String name;
    @NotEmpty(message = " The email is required")
    @Column(name = "user_email")
    private String email;
    @NotEmpty(message = " The password is required")
    @Column(name = "user_password")
    private String password;

}

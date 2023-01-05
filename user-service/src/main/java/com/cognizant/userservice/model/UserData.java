package com.cognizant.userservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "userData")
public class UserData {
    @Id
    @Column(name = "email")
    private String email;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String gender;
    @JsonFormat(pattern = "MM/dd/yyyy")
    private String dob;
    private String mobileNumber;
    private boolean online;
}
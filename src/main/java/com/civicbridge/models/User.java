package com.civicbridge.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private int id;
    
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String userRole;
    private LocalDateTime createdDate;
    private boolean isActive;

    @OneToMany(mappedBy = "user")
    private List<Request> requests;

    public String getUsername() { return username;}
    public String getPassword() {return password;}


}

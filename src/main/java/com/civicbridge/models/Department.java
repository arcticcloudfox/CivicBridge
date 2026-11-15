package com.civicbridge.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Department {
    
    @Id
    @GeneratedValue
    private int id;
    
    private String departmentName;
    private String description;
    private String phoneNumber;
    private String email;
    private boolean isActive;
    
    @OneToMany(mappedBy = "department")
    private List<Request> requests = new ArrayList<>();
}

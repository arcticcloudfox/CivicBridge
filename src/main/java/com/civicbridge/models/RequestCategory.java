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
public class RequestCategory {
    
    @Id
    @GeneratedValue
    private int id;
    
    private String categoryName;
    private String description;
    private boolean isActive;
    
    @OneToMany(mappedBy = "category")
    private List<Request> requests = new ArrayList<>();
    
}

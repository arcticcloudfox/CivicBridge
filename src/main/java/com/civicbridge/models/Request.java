package com.civicbridge.models;

import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Request {

    @Id
    @GeneratedValue
    private int id;

    private String title;
    private String description;
    private int submittedByUserID;
    private int assignedToUserID;
    private int departmentID;
    private int categoryID;
    private String currentStatus;
    private String priority;
    private String locationAddress;
    private double latitude;
    private double longitude;
    private LocalDate createdDate;
    private LocalDate updatedDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "request")
    private List<StatusHistory> statusHistory = new ArrayList<>();

    @OneToMany(mappedBy = "request")
    private List<Notification> notifications = new ArrayList<>();

    @OneToMany(mappedBy = "request")
    private List<RequestAttachment> attachments = new ArrayList<>();
}

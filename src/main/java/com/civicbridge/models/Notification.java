package com.civicbridge.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Notification {

    @Id
    @GeneratedValue
    private int id;

    private String message;
    private boolean isRead;
    private LocalDateTime createdDate;

    private int recipientUserID;

    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private Request request;

}

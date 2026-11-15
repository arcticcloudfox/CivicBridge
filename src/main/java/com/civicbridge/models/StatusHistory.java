package com.civicbridge.models;

import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class StatusHistory {

    @Id
    @GeneratedValue
    private int id;

    private String status;
    private String statusNotes;
    private int updatedByUserID;
    private LocalDate updatedDate;

    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private Request request;
}

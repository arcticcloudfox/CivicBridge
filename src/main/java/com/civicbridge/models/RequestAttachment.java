package com.civicbridge.models;

import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class RequestAttachment {

    @Id
    @GeneratedValue
    private int id;

    private String fileName;
    private String filePath;
    private long fileSize;
    private int uploadedByUserID;
    private LocalDateTime uploadedDate;

    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private Request request;
}

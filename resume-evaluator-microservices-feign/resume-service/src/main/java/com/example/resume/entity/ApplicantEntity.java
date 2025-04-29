package com.example.resume.entity;

import com.example.resume.dto.ApplicantRequest;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "applicants")
public class ApplicantEntity {

    @Id
    private String id;

    private String applicantId;

    private ApplicantRequest data;

    public ApplicantEntity() {}

    public ApplicantEntity(String applicantId, ApplicantRequest data) {
        this.applicantId = applicantId;
        this.data = data;
    }

    // Getters and Setters
}
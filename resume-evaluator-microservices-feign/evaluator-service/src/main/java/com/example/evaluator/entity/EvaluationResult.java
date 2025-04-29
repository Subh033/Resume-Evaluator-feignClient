package com.example.evaluator.entity;

import com.example.evaluator.dto.ApplicantResponse;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "evaluations")
public class EvaluationResult {

    @Id
    private String id;

    private String applicantId;
    private String status;
    private List<String> reasons;

    public EvaluationResult() {}

    public EvaluationResult(ApplicantResponse response) {
        this.applicantId = response.getApplicantId();
        this.status = response.getStatus();
        this.reasons = response.getReasons();
    }

    // Getters and Setters
}

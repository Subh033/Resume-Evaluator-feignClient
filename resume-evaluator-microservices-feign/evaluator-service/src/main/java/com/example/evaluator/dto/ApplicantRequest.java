
package com.example.evaluator.dto;

import lombok.Data;
import java.util.List;

@Data
public class ApplicantRequest {
    private String applicantId;
    private Personal personal;
    private List<Education> education;
    private List<Experience> experience;
    private List<Project> projects;
}

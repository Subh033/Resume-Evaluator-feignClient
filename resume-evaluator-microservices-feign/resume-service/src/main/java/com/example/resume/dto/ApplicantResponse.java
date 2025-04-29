
package com.example.resume.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantResponse {
    private String applicantId;
    private String status;
    private List<String> reasons;
}

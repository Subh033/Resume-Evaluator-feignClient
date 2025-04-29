
package com.example.resume.service;

import com.example.resume.dto.ApplicantRequest;
import com.example.resume.dto.ApplicantResponse;

import java.util.List;

public interface ResumeService {
    List<ApplicantResponse> sendToEvaluator(List<ApplicantRequest> applicants);
}

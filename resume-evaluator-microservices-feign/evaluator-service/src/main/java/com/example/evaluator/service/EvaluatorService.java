
package com.example.evaluator.service;

import com.example.evaluator.dto.ApplicantRequest;
import com.example.evaluator.dto.ApplicantResponse;
import java.util.List;

public interface EvaluatorService {
    List<ApplicantResponse> evaluate(List<ApplicantRequest> applicants);
}

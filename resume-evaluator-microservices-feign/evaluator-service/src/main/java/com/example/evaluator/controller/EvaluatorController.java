
package com.example.evaluator.controller;

import com.example.evaluator.dto.ApplicantRequest;
import com.example.evaluator.dto.ApplicantResponse;
import com.example.evaluator.service.EvaluatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EvaluatorController {
    private final EvaluatorService evaluatorService;

    @PostMapping("/evaluateBatch")
    public List<ApplicantResponse> evaluate(@RequestBody List<ApplicantRequest> applicants) {
        return evaluatorService.evaluate(applicants);
    }
}

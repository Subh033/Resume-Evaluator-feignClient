
package com.example.resume.feign;

import com.example.resume.dto.ApplicantRequest;
import com.example.resume.dto.ApplicantResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "evaluator-service", url = "http://localhost:8082")
public interface EvaluatorClient {
    @PostMapping("/evaluateBatch")
    List<ApplicantResponse> evaluateBatch(@RequestBody List<ApplicantRequest> applicants);
}

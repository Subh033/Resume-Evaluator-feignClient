
package com.example.resume.controller;

import com.example.resume.dto.ApplicantRequest;
import com.example.resume.dto.ApplicantResponse;
import com.example.resume.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resume")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @PostMapping("/submitAll")
    public List<ApplicantResponse> submitResumes(@RequestBody List<ApplicantRequest> applicants) {
        return resumeService.sendToEvaluator(applicants);
    }
}

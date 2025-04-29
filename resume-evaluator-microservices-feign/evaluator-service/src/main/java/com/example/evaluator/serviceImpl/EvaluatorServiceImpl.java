package com.example.evaluator.serviceImpl;

import com.example.evaluator.dto.*;
import com.example.evaluator.entity.EvaluationResult;
import com.example.evaluator.repository.EvaluationRepository;
import com.example.evaluator.service.EvaluatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EvaluatorServiceImpl implements EvaluatorService {

    @Autowired
    private EvaluationRepository evaluationRepository;


    @Override
    public List<ApplicantResponse> evaluate(List<ApplicantRequest> applicants) {
        List<ApplicantResponse> responses = new ArrayList<>();

        for (ApplicantRequest applicant : applicants) {
            List<String> reasons = new ArrayList<>();
            boolean isFullTime =false;
            boolean isIntern=false;

            boolean hasGoodBTech = applicant.getEducation().stream()
                    .anyMatch(e -> e.getDegree().equalsIgnoreCase("B.Tech") && e.getCgpa() > 7.0);
            if (hasGoodBTech) reasons.add("B.Tech with CGPA > 7.0");

            boolean hasExperience = applicant.getExperience().stream()
                    .anyMatch(e -> e.getDurationInMonths() > 12);
            if (hasExperience) reasons.add("Experience: > 12 months");

            boolean hasRelevantProject = applicant.getProjects().stream()
                    .anyMatch(p -> p.getTechStack().stream()
                            .anyMatch(tech -> tech.equalsIgnoreCase("Spring Boot") || tech.equalsIgnoreCase("React")));
            if (hasRelevantProject) reasons.add("Project using Spring Boot or React");

            boolean hasComplexProject = applicant.getProjects().stream()
                    .anyMatch(p -> p.getTechStack().size() >= 3);

            if (hasGoodBTech && hasExperience && hasRelevantProject) {
                isFullTime = true;
            } else if (hasComplexProject) {
                isIntern = true;
                reasons.clear();
                reasons.add("Project with " + applicant.getProjects().get(0).getTechStack().size() + " tech stacks");
            } else {
//                reasons.clear();
//                reasons.add("Project with " + applicant.getProjects().get(0).getTechStack().size() + " tech stacks");
                  continue;
            }

            ApplicantResponse response = new ApplicantResponse();
            response.setApplicantId(applicant.getApplicantId());
            response.setStatus(isFullTime ? "Full-Time Eligible" : isIntern?"Intern Eligible":"Not Eligible");
            response.setReasons(reasons);
            responses.add(response);

            EvaluationResult result = new EvaluationResult(response);
            evaluationRepository.save(result);
        }

        return responses;
    }
}

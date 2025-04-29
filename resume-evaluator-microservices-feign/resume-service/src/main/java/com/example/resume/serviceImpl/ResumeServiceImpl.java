package com.example.resume.serviceImpl;

import com.example.resume.dto.ApplicantRequest;
import com.example.resume.dto.ApplicantResponse;
import com.example.resume.entity.ApplicantEntity;
import com.example.resume.feign.EvaluatorClient;
import com.example.resume.repository.ResumeRepository;
import com.example.resume.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private EvaluatorClient evaluatorClient;

    @Autowired
    private ResumeRepository repository;

    @Override
    public List<ApplicantResponse> sendToEvaluator(List<ApplicantRequest> applicants) {
        // Save each applicant to MongoDB
//        for (ApplicantRequest req : applicants) {
//            repository.save(new ApplicantEntity(req.getApplicantId(), req));
//        }
        List<ApplicantEntity> entities = applicants.stream()
                .map(req -> new ApplicantEntity(req.getApplicantId(), req))
                .toList();

        // Save all applicants to MongoDB in one batch
        repository.saveAll(entities);

        // Forward to evaluator
        return evaluatorClient.evaluateBatch(applicants);
    }
}

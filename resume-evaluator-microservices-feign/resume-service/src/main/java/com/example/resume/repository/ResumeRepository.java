package com.example.resume.repository;

import com.example.resume.entity.ApplicantEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResumeRepository extends MongoRepository<ApplicantEntity,String> {
}

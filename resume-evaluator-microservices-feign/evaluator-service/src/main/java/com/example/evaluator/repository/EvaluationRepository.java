package com.example.evaluator.repository;

import com.example.evaluator.entity.EvaluationResult;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EvaluationRepository extends MongoRepository<EvaluationResult,String> {
}

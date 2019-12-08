package org.exercise.driver_rest_api.advice;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdviceRepository extends MongoRepository<Advice, String> {
}

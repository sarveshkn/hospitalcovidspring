package com.practise.microservice.repository.hospital;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.practise.microservice.rs.model.Hospital;

public interface HospitalRepository extends MongoRepository<Hospital, String> {

}

package com.practise.microservice.controller;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.microservice.datamodel.ErrorMessage;
import com.practise.microservice.datamodel.Message;
import com.practise.microservice.repository.hospital.HospitalRepository;
import com.practise.microservice.rs.model.Hospital;

@Service
public class HospitalApiService {

	@Autowired
	private HospitalRepository hospitalRepository;

	public HospitalApiService() {
	}

	public Message addHospital(Hospital body) {
		Hospital hospital = hospitalRepository.insert(body);
		if (hospital.getId() != null) {
			return new Message(Response.ok(hospital).build());
		}
		return new ErrorMessage("10", "Hospital not added", "Hospital could not be added to the store");
	}

	public Message deleteHospital(Integer hospitalId) {
		hospitalRepository.deleteById(hospitalId.toString());
		return new Message(Response.ok().status(204).build());
	}

	public Message getAllHospitals() {
		List<Hospital> hospitals = hospitalRepository.findAll();
		return new Message(Response.ok(hospitals).build());
	}

	public Message getHospitalById(String hospitalId) {
		Optional<Hospital> hospital = hospitalRepository.findById(hospitalId);
		if (hospital.isPresent()) {
			return new Message(Response.ok(hospital.get()).build());
		} else {
			return new ErrorMessage("11", "Hospital not found",
					"Hospital could not be found in the store" + hospitalId);
		}
	}

	public Message updateHospital(Hospital body) {
		Hospital hospital = hospitalRepository.save(body);
		if (hospital != null) {
			return new Message(Response.ok(hospital).build());
		} else {
			return new ErrorMessage("11", "Hospital not updated",
					"Hospital could not be updated in the store" + body.getId());
		}
	}

}

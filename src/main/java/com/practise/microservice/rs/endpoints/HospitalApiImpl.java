package com.practise.microservice.rs.endpoints;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.practise.microservice.controller.HospitalApiService;
import com.practise.microservice.datamodel.ErrorMessage;
import com.practise.microservice.datamodel.Message;
import com.practise.microservice.datamodel.WarningMessage;
import com.practise.microservice.handler.MessageHandler;
import com.practise.microservice.rs.model.Hospital;

public class HospitalApiImpl implements HospitalApi {

	@Autowired
	private HospitalApiService hospitalApiService;

	@Autowired
	private MessageHandler messageHandler;

	@Override
	public Response addHospital(Hospital body) {
		Message message = hospitalApiService.addHospital(body);
		return messageHandler.getMessage(message);
	}

	@Override
	public Response deleteHsopital(Integer hospitalId) {
		Message message = hospitalApiService.deleteHospital(hospitalId);
		return messageHandler.getMessage(message);
	}

	@Override
	public Response findHospitalsByAvailability() {
		hospitalApiService.getAllHospitals();
		return messageHandler.getMessage(null);
	}

	@Override
	public Response getHospitalById(String hospitalId) {
		Message message = hospitalApiService.getHospitalById(hospitalId);
		return messageHandler.getMessage(message);
	}

	@Override
	public Response updateHospital(Hospital body) {
		Message message = hospitalApiService.updateHospital(body);
		return messageHandler.getMessage(message);
	}

	@Override
	public Response getAllHospitals() {
		Message message = hospitalApiService.getAllHospitals();
		return messageHandler.getMessage(message);
	}

}

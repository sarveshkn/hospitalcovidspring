package com.practise.microservice.handler;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.practise.microservice.datamodel.ErrorMessage;
import com.practise.microservice.datamodel.Message;
import com.practise.microservice.datamodel.WarningMessage;

@Service
public class MessageHandler {

	public Response getMessage(Message message) {
		if (message != null) {
			if (message instanceof ErrorMessage) {
				message = (ErrorMessage) message;
				return Response.ok().status(Integer.valueOf(message.getErrorCode()), message.getTitle()).build();
			} else if (message instanceof WarningMessage) {
				return Response.ok().status(Integer.valueOf(message.getErrorCode()), message.getTitle()).build();
			}
		}
		return message.getResponse();
	}

}

package com.mentoringproject.hogwarts.common.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.shared.model.tasks.db.HogwartsTaskRepository;

import io.spring.guides.gs_producing_web_service.GetTaskRequest;
import io.spring.guides.gs_producing_web_service.GetTaskResponse;

@Endpoint
public class HogwartsTaskEndpoint 
{
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private HogwartsTaskRepository hogwartsTaskRepository;

	@Autowired
	public HogwartsTaskEndpoint(HogwartsTaskRepository hogwartsTaskRepository) {
		this.hogwartsTaskRepository = hogwartsTaskRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTaskRequest")
	@ResponsePayload
	public GetTaskResponse getCountry(@RequestPayload GetTaskRequest request) {
		GetTaskResponse response = new GetTaskResponse();
		response.setTask(hogwartsTaskRepository.findTask(request.getType()));

		return response;
	}
}

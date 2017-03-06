package com.mentoringproject.hogwarts.common.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mentoringproject.hogwarts.common.model.HogwartsResultsResponse;
import com.mentoringproject.hogwarts.common.service.HogwartsService;
import com.mentoringproject.hogwarts.common.service.HogwartsService.HogwartsRequest;

@Controller
@RequestMapping("/hogwarts")
public class HogwartsController 
{	
	@Autowired
	@Qualifier("hogwartsService")
	public HogwartsService hogwartsService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String hogwartsHomePage()
	{		
		return "/home.html";
	}
	
	@ResponseBody
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
//	public HogwartsResultsResponseDTO retrieveResults(@RequestParam(required = true) final String team)
	public HogwartsResultsResponseDTO retrieveResults()
	{
		final String team = "Slytherin";
		final HogwartsRequest request = hogwartsService.forTeam(team);
		final HogwartsResultsResponse response = request.retrieveResults();
		
		return new HogwartsResultsResponseDTO(response);
	}
}
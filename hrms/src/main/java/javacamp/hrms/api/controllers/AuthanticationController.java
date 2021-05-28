package javacamp.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.AuthanticationService;
import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.entities.concretes.*;

@RestController
@RequestMapping("/api/authantication")
public class AuthanticationController {

	private AuthanticationService authanticationService;

	@Autowired
	public AuthanticationController(AuthanticationService authanticationService) {
		this.authanticationService = authanticationService;
	}
	
	@PostMapping("/employerAdd")
	public Result registerEmpolyer(@RequestBody Employer employer, String confirmedPassword)
	{
		return authanticationService.employerRegister(employer, confirmedPassword);
	}
	
	@PostMapping("/candidateAdd")
	public Result registerJobseeker(@RequestBody Candidate candidate, String confirmedPassword)
	{
		return authanticationService.candidateRegister(candidate, confirmedPassword);
	}
	
}

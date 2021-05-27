package javacamp.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.authantication_services.CandidateAuthanticationService;
import javacamp.hrms.business.abstracts.authantication_services.EmployerAuthanticationService;
import javacamp.hrms.business.abstracts.authantication_services.VerifyService;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.dtos.RegisterForCandidateDto;
import javacamp.hrms.entities.dtos.RegisterForEmployerDto;

@RestController
@RequestMapping("/api/auth")
public class AuthanticationController {
    private CandidateAuthanticationService candidateAuthService;
    private EmployerAuthanticationService employerAuthService;
    private VerifyService verifyService;

    @Autowired
    public AuthanticationController(CandidateAuthanticationService candidateAuthService, EmployerAuthanticationService employerAuthService,VerifyService verifyService) {
        this.candidateAuthService = candidateAuthService;
        this.employerAuthService = employerAuthService;
        this.verifyService =verifyService;
    }

    @PostMapping("/candidate/register")
    public Result registerForCandidate(@RequestBody RegisterForCandidateDto registerForCandidateDto){
        return candidateAuthService.register(registerForCandidateDto);
    }

    @PostMapping("/employer/register")
    public Result registerForEmployer(@RequestBody RegisterForEmployerDto registerForEmployerDto){
        return employerAuthService.register(registerForEmployerDto);
    }

    @GetMapping("/verify")
    public Result verify(int userId, String activationCode){
        return verifyService.verify(userId,activationCode);
    }
}

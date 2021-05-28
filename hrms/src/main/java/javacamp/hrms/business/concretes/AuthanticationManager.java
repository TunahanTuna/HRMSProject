package javacamp.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.ActivationCodeService;
import javacamp.hrms.business.abstracts.AuthanticationService;
import javacamp.hrms.business.abstracts.CandidateService;
import javacamp.hrms.business.abstracts.EmployerService;
import javacamp.hrms.business.abstracts.UserService;
import javacamp.hrms.core.services.verification.VerificationService;
import javacamp.hrms.core.utilities.adapters.ValidationService;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Candidate;
import javacamp.hrms.entities.concretes.Employer;

@Service
public class AuthanticationManager implements AuthanticationService{
	
	private CandidateService candidateService;
	private EmployerService employerService;
	private ValidationService validationService;
	private ActivationCodeService activationCodeService;
	private UserService userService;
	private VerificationService verificationService;
	
	
	@Autowired
	public AuthanticationManager(CandidateService candidateService, EmployerService employerService,
			ValidationService validationService, ActivationCodeService activationCodeService, UserService userService,
			VerificationService verificationService) {
		
		this.candidateService = candidateService;
		this.employerService = employerService;
		this.validationService = validationService;
		this.activationCodeService = activationCodeService;
		this.userService = userService;
		this.verificationService = verificationService;
	}

	@Override
	public Result employerRegister(Employer employer, String confirmedPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result candidateRegister(Candidate candidate, String confirmedPassword) {
		// TODO Auto-generated method stub
		return null;
	}

}

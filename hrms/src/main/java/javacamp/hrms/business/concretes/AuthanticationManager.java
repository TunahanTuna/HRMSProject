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
	
	// employer alanlarının dolu olup olmadığının kontrolü
	private boolean checkEmployerNull(Employer employer) {
		if((employer.getCompanyName() == null || employer.getCompanyName().isBlank()) && 
				(employer.getWebSite() == null || employer.getWebSite().isBlank()) &&
				(employer.getPhoneNumber() == null || employer.getPhoneNumber().isBlank()) &&
				(employer.getEmail() == null || employer.getEmail().isBlank()) &&
				(employer.getPassword() == null || employer.getPassword().isBlank())) {
			
			return false;
		}
		
		return true;
	}
	// Employer mail ve domain kontrolü
	private boolean checkEmailAndDomain(Employer employer) {
		
		String[] emailArr = employer.getEmail().split("@",2);
		
		String domain = employer.getWebSite().substring(4,employer.getWebSite().length());
		
		if(!emailArr[1].equals(domain)) {
			return false;
		}
		
		return true;
	}

}

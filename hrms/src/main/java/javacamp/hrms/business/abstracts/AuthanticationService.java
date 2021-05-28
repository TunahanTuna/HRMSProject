package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Candidate;
import javacamp.hrms.entities.concretes.Employer;

public interface AuthanticationService {

	Result employerRegister(Employer employer, String confirmedPassword);
	
	Result candidateRegister(Candidate candidate, String confirmedPassword);
	
	
}

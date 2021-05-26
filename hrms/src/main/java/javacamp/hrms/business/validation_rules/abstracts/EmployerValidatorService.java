package javacamp.hrms.business.validation_rules.abstracts;

import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Employer;

public interface EmployerValidatorService {

	Result employerNullCheck(Employer employer);
	Result isEmailCheck(Employer employer);
	
}

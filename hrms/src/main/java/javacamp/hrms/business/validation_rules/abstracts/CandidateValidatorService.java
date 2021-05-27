package javacamp.hrms.business.validation_rules.abstracts;

import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Candidate;

public interface CandidateValidatorService {

	Result candidateNullCheck(Candidate candidate);
	Result nationalityIdValid(String nationalityIdentity);
	
}

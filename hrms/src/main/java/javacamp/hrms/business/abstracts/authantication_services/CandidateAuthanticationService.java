package javacamp.hrms.business.abstracts.authantication_services;

import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.dtos.RegisterForCandidateDto;

public interface CandidateAuthanticationService {

	Result register (RegisterForCandidateDto registerForCandidateDto);
		
	
}

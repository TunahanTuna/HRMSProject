package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.entities.concretes.Candidate;

public interface CandidateService {

	DataResult<List<Candidate>> getAll();
	
	DataResult<Candidate> getCandidateByNationalityId(String NationaltiyId);
	
	Result add(Candidate candidate);
	
}

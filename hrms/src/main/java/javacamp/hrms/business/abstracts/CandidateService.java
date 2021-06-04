package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.entities.concretes.Candidate;
import javacamp.hrms.entities.dtos.CandidateCvDto;

public interface CandidateService {

	DataResult<List<Candidate>> getAll();
	
	DataResult<Candidate> getCandidateByNationalityId(String NationaltiyId);
	
	DataResult<Candidate> getById(int id);
	
	Result add(Candidate candidate);
	Result update(Candidate candidate);
	Result delete(int id);
	
	DataResult<CandidateCvDto> getByCandidateCvDtoId(int id);

	
}

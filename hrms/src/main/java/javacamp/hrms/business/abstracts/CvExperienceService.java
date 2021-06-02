package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.entities.concretes.CvExperience;

public interface CvExperienceService {

	Result add(CvExperience cvExperience);
	Result update(CvExperience cvExperience);
	Result delete(int id);
	
	DataResult<List<CvExperience>> getAll();
	DataResult<List<CvExperience>> getAllByCandidateIdOrderByEndYearDesc(int id);
	
}

package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.entities.concretes.CvEducation;
import javacamp.hrms.entities.concretes.CvExperience;

public interface CvEducationService {

	Result add(CvEducation cvEducation);
	Result update(CvEducation cvEducation);
	Result delete(int id);
	
	DataResult<CvEducation> getById(int id);
	DataResult<List<CvEducation>> getAll();
	DataResult<List<CvEducation>> getAllByCandidateIdOrderByGraduationYearDesc(int id);
}

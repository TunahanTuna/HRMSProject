package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.entities.concretes.*;

public interface CvSkillService {

	
	Result add(CvSkill cvSkill);
	Result update(CvSkill cvSkill);
	Result delete(int id);
	
	DataResult<CvSkill> getById(int id);
	DataResult<List<CvSkill>> getAll();
	DataResult<List<CvSkill>> getAllByCandidate_id(int id);
}

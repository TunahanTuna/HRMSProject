package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.entities.concretes.*;

public interface CvLinkService {

	Result add(CvLink cvLink);
	Result update(CvLink cvLink);
	Result delete(int id);
	
	DataResult<CvLink> getAllById(int id);
	DataResult<List<CvLink>> getAll();
	DataResult<List<CvLink>> getAllByCandidateId(int id);
	
}

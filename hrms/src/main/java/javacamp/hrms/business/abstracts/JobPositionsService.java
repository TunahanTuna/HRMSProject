package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.entities.concretes.JobPosition;

public interface JobPositionsService {

	DataResult<List<JobPosition>> getAll();
	
	Result add(JobPosition jobPosition);
}

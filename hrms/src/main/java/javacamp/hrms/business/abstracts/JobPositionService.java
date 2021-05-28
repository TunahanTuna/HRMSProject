package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	
	DataResult<List<JobPosition>> getAll(); 
	
	DataResult<JobPosition> getJobByPositionName(String positionName);
	
	Result add(JobPosition jobPosition);
}

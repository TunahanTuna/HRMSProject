package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.JobPositionService;
import javacamp.hrms.business.constraints.Info;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.JobPositionDao;
import javacamp.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}
	

	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),Info.listInfo);
	}


	@Override
	public DataResult<JobPosition> getJobByPositionName(String positionName) {
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.findByPositionName(positionName));
	}


	@Override
	public Result add(JobPosition jobPosition) {
		
		if(getJobByPositionName(jobPosition.getPositionName()).getData() != null) {
			return new ErrorResult(Info.jobTitleExistingInfo);
		}
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult(Info.jobPositionAddedInfo);
	}

}

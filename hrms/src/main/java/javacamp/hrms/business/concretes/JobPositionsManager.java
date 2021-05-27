package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.JobPositionsService;
import javacamp.hrms.business.constraints.Info;
import javacamp.hrms.core.utilities.business.BusinessEngine;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.core.utilities.verification_tool.CodeGenerator;
import javacamp.hrms.dataAccess.abstracts.JobPositionsDao;
import javacamp.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionsManager implements JobPositionsService{

	private JobPositionsDao jobPositionsDao;
	
	@Autowired
	public JobPositionsManager(JobPositionsDao jobPositionsDao) {
		super();
		this.jobPositionsDao = jobPositionsDao;
	}
	

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<>(this.jobPositionsDao.findAll(),Info.jobPositionListedInfo);
	}


	  @Override
	    public Result add(JobPosition jobPosition) {
	        Result result = BusinessEngine.run(isJobPositionExist(jobPosition));
	        if(result.isSuccess()){
	            jobPosition.setU_id(CodeGenerator.UuIdCodeGenerator());
	        this.jobPositionsDao.save(jobPosition);
	        return new SuccessResult(Info.jobPositionAddedInfo);
	        }
	        return result;
	    }


	    private Result isJobPositionExist(JobPosition jobPosition){
	        if(jobPositionsDao.finByTitle(jobPosition.getPositionName()).isPresent()){
	            return new ErrorResult(Info.jobTitleExistingInfo);
	        }
	        return new SuccessResult();
	    }

}

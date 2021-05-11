package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.JobPositionsService;
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
	public List<JobPosition> getAll() {
		
		return this.jobPositionsDao.findAll();
	}

}

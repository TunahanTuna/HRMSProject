package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.AdvertFormWorkTimeService;
import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.dataAccess.abstracts.AdvertFormWorkTimeDao;
import javacamp.hrms.entities.concretes.AdvertFormWorkTime;

@Service
public class AdvertFormWorkTimeManager implements AdvertFormWorkTimeService{

	private AdvertFormWorkTimeDao advertFormWorkTimeDao;
	
	@Autowired
	public AdvertFormWorkTimeManager(AdvertFormWorkTimeDao advertFormWorkTimeDao) {
		this.advertFormWorkTimeDao = advertFormWorkTimeDao;
	}
	
	@Override
	public DataResult<List<AdvertFormWorkTime>> getAll() {
		return new SuccessDataResult<List<AdvertFormWorkTime>>(this.advertFormWorkTimeDao.findAll(),"Success");
	}

}

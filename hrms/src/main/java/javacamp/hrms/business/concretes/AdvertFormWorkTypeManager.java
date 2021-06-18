package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.AdvertFormWorkTypeService;
import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.dataAccess.abstracts.AdvertFormWorkTypeDao;
import javacamp.hrms.entities.concretes.AdvertFormWorkType;

@Service
public class AdvertFormWorkTypeManager implements AdvertFormWorkTypeService {
	
	private AdvertFormWorkTypeDao advertFormWorkTypeDao;

	@Autowired
	public AdvertFormWorkTypeManager(AdvertFormWorkTypeDao advertFormWorkTypeDao) {
		this.advertFormWorkTypeDao = advertFormWorkTypeDao;
	}

	@Override
	public DataResult<List<AdvertFormWorkType>> getAll() {
		return new SuccessDataResult<List<AdvertFormWorkType>>(this.advertFormWorkTypeDao.findAll(),"Success");
	}

}

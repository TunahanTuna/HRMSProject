package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.AdvertFormWorkTime;

public interface AdvertFormWorkTimeService {

	DataResult<List<AdvertFormWorkTime>> getAll();
	
}

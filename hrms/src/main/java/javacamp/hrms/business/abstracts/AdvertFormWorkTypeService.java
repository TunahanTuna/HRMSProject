package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.AdvertFormWorkType;

public interface AdvertFormWorkTypeService {

	DataResult<List<AdvertFormWorkType>> getAll();

}

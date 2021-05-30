package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.AdvertForm;

public interface AdvertFormService {
	
	
	DataResult<AdvertForm> getById(int id);	
	DataResult<List<AdvertForm>> getAll();
	DataResult<List<AdvertForm>> getAllOpenAdverts();
	DataResult<List<AdvertForm>> getAllByOrderByDescPublishDate();
	DataResult<List<AdvertForm>> getAllOpenJobAdvertByEmployer(int id);

}

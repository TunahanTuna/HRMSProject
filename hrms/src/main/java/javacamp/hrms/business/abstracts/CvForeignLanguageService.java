package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.entities.concretes.CvForeignLanguage;

public interface CvForeignLanguageService {

	
	Result add(CvForeignLanguage cvForeignLanguage);
	Result update(CvForeignLanguage cvForeignLanguage);
	Result delete(int id);
	
	DataResult<List<CvForeignLanguage>> getAll();
	DataResult<List<CvForeignLanguage>> getAllByCandidate_id(int id);
	
}

package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.CvForeignLanguageService;
import javacamp.hrms.business.constraints.Info;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.dataAccess.abstracts.CvForeignLanguageDao;
import javacamp.hrms.entities.concretes.CvForeignLanguage;

@Service
public class CvForeignLanguageManager implements CvForeignLanguageService {

	private CvForeignLanguageDao cvForeignLanguageDao;
	
	@Autowired
	public CvForeignLanguageManager(CvForeignLanguageDao cvForeignLanguageDao) {
		this.cvForeignLanguageDao = cvForeignLanguageDao;
	}

	@Override
	public Result add(CvForeignLanguage cvForeignLanguage) {
		this.cvForeignLanguageDao.save(cvForeignLanguage);
		return new SuccessResult("Ekleme Başarılı");
	}

	@Override
	public Result update(CvForeignLanguage cvForeignLanguage) {
		this.cvForeignLanguageDao.save(cvForeignLanguage);
		return new SuccessResult("Güncelleme Başarılı");
	}

	@Override
	public Result delete(int id) {
		this.cvForeignLanguageDao.deleteById(id);
		return new SuccessResult("Silme Başarılı");
	}

	@Override
	public DataResult<List<CvForeignLanguage>> getAllByCandidate_id(int id) {
		return new SuccessDataResult<List<CvForeignLanguage>>(this.cvForeignLanguageDao.getAllByCandidate_id(id),
															  Info.listInfo);
	}

}

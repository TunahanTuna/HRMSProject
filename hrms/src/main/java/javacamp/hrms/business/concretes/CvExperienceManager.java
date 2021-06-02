package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.CvExperienceService;
import javacamp.hrms.business.constraints.Info;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CvExperienceDao;
import javacamp.hrms.entities.concretes.CvExperience;

@Service
public class CvExperienceManager implements CvExperienceService {

	private CvExperienceDao cvExperienceDao;
	
	@Autowired
	public CvExperienceManager(CvExperienceDao cvExperienceDao) {
		this.cvExperienceDao = cvExperienceDao;
	}

	@Override
	public Result add(CvExperience cvExperience) {

		this.cvExperienceDao.save(cvExperience);
		return new SuccessResult("Ekeleme başarılı");
	}

	@Override
	public Result update(CvExperience cvExperience) {
		this.cvExperienceDao.save(cvExperience);
		return new SuccessResult("Güncelleme başarılı");
	}

	@Override
	public Result delete(int id) {
		this.cvExperienceDao.deleteById(id);
		return new SuccessResult("Silme başarılı");
	}

	@Override
	public DataResult<List<CvExperience>> getAll() {
		return new SuccessDataResult<List<CvExperience>>(this.cvExperienceDao.findAll(),Info.listInfo);
	}

	@Override
	public DataResult<List<CvExperience>> getAllByCandidateIdOrderByEndYearDesc(int id) {
		return new SuccessDataResult<List<CvExperience>>(this.cvExperienceDao.getAllByCandidate_idOrderByEndYearDesc(id),Info.listInfo);
	}

}

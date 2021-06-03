package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.CvEducationService;
import javacamp.hrms.business.constraints.Info;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CvEducationDao;
import javacamp.hrms.entities.concretes.CvEducation;

@Service
public class CvEducationManager  implements CvEducationService{

	private CvEducationDao cvEducationDao;

	@Autowired
	public CvEducationManager(CvEducationDao cvEducationDao) {
		this.cvEducationDao = cvEducationDao;
	}

	@Override
	public Result add(CvEducation cvEducation) {

		this.cvEducationDao.save(cvEducation);
		return new SuccessResult("Başarılı işlem");
	}

	@Override
	public Result update(CvEducation cvEducation) {
		this.cvEducationDao.save(cvEducation);	
		return new SuccessResult("Başarılı güncelleme");
	}

	@Override
	public Result delete(int id) {

		this.cvEducationDao.deleteById(id);
		return new SuccessResult("Başarılı silme işlemi");
	}

	@Override
	public DataResult<List<CvEducation>> getAllByCandidateIdOrderByGraduationYearDesc(int id) {
		return new SuccessDataResult<List<CvEducation>>(this.cvEducationDao.getAllByCandidate_idOrderByGraduationYearDesc(id),
															Info.listInfo);
	}

	@Override
	public DataResult<List<CvEducation>> getAll() {
		return new SuccessDataResult<List<CvEducation>>(this.cvEducationDao.findAll(),Info.listInfo);
	}

	@Override
	public DataResult<CvEducation> getById(int id) {
		return new SuccessDataResult<CvEducation>(this.cvEducationDao.getBySchoolId(id),"Id'ye göre getirdim");
	}
	
}

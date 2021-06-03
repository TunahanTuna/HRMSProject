package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.CvCoverLetterService;
import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.dataAccess.abstracts.CvCoverLetterDao;
import javacamp.hrms.entities.concretes.CvCoverLetter;

@Service
public class CvCoverLetterManager implements CvCoverLetterService {

	private CvCoverLetterDao cvCoverLetterDao;
	
	@Autowired
	public CvCoverLetterManager(CvCoverLetterDao cvCoverLetterDao) {
		this.cvCoverLetterDao = cvCoverLetterDao;
	}

	@Override
	public Result add(CvCoverLetter cvCoverLetter) {
		this.cvCoverLetterDao.save(cvCoverLetter);
		return new SuccessResult("Ekleme başarılı");
	}

	@Override
	public Result update(CvCoverLetter cvCoverLetter) {
		this.cvCoverLetterDao.save(cvCoverLetter);
		return new SuccessResult("Güncelleme başarılı");
	}

	@Override
	public Result delete(int id) {
		this.cvCoverLetterDao.deleteById(id);
		return new SuccessResult("Silme başarılı");
	}

	@Override
	public DataResult<CvCoverLetter> getById(int id) {
		return new SuccessDataResult<CvCoverLetter>(this.cvCoverLetterDao.getById(id),"Listelendi");
	}

	@Override
	public DataResult<List<CvCoverLetter>> getAll() {
		return new SuccessDataResult<List<CvCoverLetter>>(this.cvCoverLetterDao.findAll(),"Listelendi");
	}

	@Override
	public DataResult<List<CvCoverLetter>> getAllByCandidate_id(int id) {
		return new SuccessDataResult<List<CvCoverLetter>>(this.cvCoverLetterDao.getAllByCandidate_id(id),"Listelendi");
	}

}

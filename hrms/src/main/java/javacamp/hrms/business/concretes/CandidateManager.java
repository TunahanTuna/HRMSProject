package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.*;
import javacamp.hrms.business.constraints.Info;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.dataAccess.abstracts.CandidateDao;
import javacamp.hrms.entities.concretes.Candidate;
import javacamp.hrms.entities.dtos.CandidateCvDto;


@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		this.candidateDao = candidateDao;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), Info.listInfo);
	}

	@Override
	public DataResult<Candidate> getCandidateByNationalityId(String NationaltiyId) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findByNationalityId(NationaltiyId));
	}
	
	@Override
	public Result add(Candidate candidate) {
		if(getCandidateByNationalityId(candidate.getNationalityId()).getData() != null) {
			return new ErrorResult("Bu Aday Mevcut");
		}
		this.candidateDao.save(candidate);
		return new SuccessResult(Info.addInfo);
	}

	@Override
	public DataResult<Candidate> getById(int id) {
		
		return new SuccessDataResult<Candidate>(this.candidateDao.getById(id));
	}

	@Override
	public Result update(Candidate candidate) {
		this.candidateDao.save(candidate);
		return new SuccessResult("Başarılı güncelleme");
	}

	@Override
	public Result delete(int id) {
		this.candidateDao.deleteById(id);
		return new SuccessResult("Başarılı silme");
	}

	@Override
	public DataResult<CandidateCvDto> getByCandidateCvDtoId(int id) {
		Candidate candidate = this.candidateDao.getById(id);
		CandidateCvDto cv = new CandidateCvDto();
		cv.cvCoverLetters = candidate.getCvCoverLetter();
		cv.cvEducations = candidate.getCvEducations();
		cv.cvExperience = candidate.getCvExperience();
		cv.cvForeignLanguage = candidate.getCvForeignLanguage();
		cv.cvImages = candidate.getCvImage();
		cv.cvLinks = candidate.getCvLink();
		cv.cvSkills = candidate.getCvSkill();
		return new SuccessDataResult<CandidateCvDto>(cv,"Id'ye göre Listeleme");
	}

	@Override
	public DataResult<CandidateCvDto> getByCandidateCvDtoNationalityId(String nationalityId) {
		Candidate candidate = this.candidateDao.findByNationalityId(nationalityId);
		CandidateCvDto cv = new CandidateCvDto();
		cv.cvCoverLetters = candidate.getCvCoverLetter();
		cv.cvEducations = candidate.getCvEducations();
		cv.cvExperience = candidate.getCvExperience();
		cv.cvForeignLanguage = candidate.getCvForeignLanguage();
		cv.cvImages = candidate.getCvImage();
		cv.cvLinks = candidate.getCvLink();
		cv.cvSkills = candidate.getCvSkill();
		return new SuccessDataResult<CandidateCvDto>(cv,"NationalityId'ye göre Listeleme");
	}

}

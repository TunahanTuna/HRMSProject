package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

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
	private CvCoverLetterService cvCoverLetterService;
	private CvEducationService	cvEducationService;
	private CvExperienceService cvExperienceService;
	private CvForeignLanguageService cvForeignLanguageService;
	private CvImageService cvImageService;
	private CvLinkService cvLinkService;
	private CvSkillService cvSkillService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, CvCoverLetterService cvCoverLetterService,
			CvEducationService cvEducationService, CvExperienceService cvExperienceService,
			CvForeignLanguageService cvForeignLanguageService, CvImageService cvImageService,
			CvLinkService cvLinkService, CvSkillService cvSkillService) {
		this.candidateDao = candidateDao;
		this.cvCoverLetterService = cvCoverLetterService;
		this.cvEducationService = cvEducationService;
		this.cvExperienceService = cvExperienceService;
		this.cvForeignLanguageService = cvForeignLanguageService;
		this.cvImageService = cvImageService;
		this.cvLinkService = cvLinkService;
		this.cvSkillService = cvSkillService;
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
		CandidateCvDto candidate = new CandidateCvDto();
		candidate.cvCoverLetters = this.cvCoverLetterService.getAllByCandidate_id(id).getData();
		candidate.cvEducations = this.cvEducationService.getAllByCandidateIdOrderByGraduationYearDesc(id).getData();
		candidate.cvExperience = this.cvExperienceService.getAllByCandidateIdOrderByEndYearDesc(id).getData();
		candidate.cvForeignLanguage = this.cvForeignLanguageService.getAllByCandidate_id(id).getData();
		candidate.cvImages = this.cvImageService.getByCandidate_id(id).getData();
		candidate.cvLinks = this.cvLinkService.getAllByCandidateId(id).getData();
		candidate.cvSkills = this.cvSkillService.getAllByCandidate_id(id).getData();
		return new SuccessDataResult<CandidateCvDto>(candidate,"Başarılı Listeleme");
	}

}

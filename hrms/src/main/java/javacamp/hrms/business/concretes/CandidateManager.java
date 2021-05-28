package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.CandidateService;
import javacamp.hrms.business.constraints.Info;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.dataAccess.abstracts.CandidateDao;
import javacamp.hrms.entities.concretes.Candidate;


@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
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

}

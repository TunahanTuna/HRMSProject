package javacamp.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;

import javacamp.hrms.business.abstracts.CandidateService;
import javacamp.hrms.business.validation_rules.abstracts.CandidateValidatorService;
import javacamp.hrms.core.adapters.mernis.service.UserCheckService;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.dataAccess.abstracts.CandidateDao;
import javacamp.hrms.dataAccess.abstracts.UserDao;
import javacamp.hrms.entities.concretes.Candidate;

public class CandidateManager extends UserManager<Candidate> implements CandidateService{

	private CandidateDao candidateDao;
	private UserCheckService userCheckService;
	private CandidateValidatorService candidateValidatorService;
	
	
	@Autowired
	public CandidateManager(UserDao<Candidate> userDao, 
							UserCheckService userCheckService,
							CandidateValidatorService candidateValidatorService) {
		
		super(userDao);
		this.candidateDao = (CandidateDao) userDao;
		this.userCheckService = userCheckService;
		this.candidateValidatorService = candidateValidatorService;
	}


	@Override
	public Result add(Candidate t) {
		// TODO Auto-generated method stub
		return super.add(t);
	}
	
	

}

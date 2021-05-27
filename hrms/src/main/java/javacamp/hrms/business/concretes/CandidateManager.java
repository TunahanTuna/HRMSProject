package javacamp.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;

import javacamp.hrms.business.abstracts.CandidateService;
import javacamp.hrms.business.constraints.Info;
import javacamp.hrms.business.validation_rules.abstracts.CandidateValidatorService;
import javacamp.hrms.core.adapters.mernis.FakePerson;
import javacamp.hrms.core.adapters.mernis.concrete.FakeMernis;
import javacamp.hrms.core.adapters.mernis.service.FakeCheckService;
import javacamp.hrms.core.adapters.mernis.service.UserCheckService;
import javacamp.hrms.core.utilities.business.BusinessEngine;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CandidateDao;
import javacamp.hrms.dataAccess.abstracts.UserDao;
import javacamp.hrms.entities.concretes.Candidate;

public class CandidateManager extends UserManager<Candidate> implements CandidateService{

	private CandidateDao candidateDao;
	private FakeCheckService fakeCheckService;
	private CandidateValidatorService candidateValidatorService;
	
	
	@Autowired
	public CandidateManager(UserDao<Candidate> userDao, 
							FakeCheckService fakeCheckService,
							CandidateValidatorService candidateValidatorService) {
		
		super(userDao);
		this.candidateDao = (CandidateDao) userDao;
		this.fakeCheckService = fakeCheckService;
		this.candidateValidatorService = candidateValidatorService;
	}


	@Override
    public Result add(Candidate candidate) {
            Result result = BusinessEngine.run((isIdentityNumberExist(candidate.getNationality_id())),
                    isMernisVerified(candidate),candidateValidatorService.candidateNullCheck(candidate),
                    candidateValidatorService.nationalityIdValid(candidate.getNationality_id()));
            if (result.isSuccess()) {
                return super.add(candidate);
            }
            return result;
    }

    private Result isIdentityNumberExist(String identityNumber) {
        if (candidateDao.findByNationalIdentity(identityNumber).isPresent()) {
            return new ErrorResult(Info.nationalityIdentityExistingInfo);
        }
        return new SuccessResult();
    }
	
    
    private Result isMernisVerified(Candidate candidate) {
        FakePerson fakePerson = new FakePerson(candidate.getFirst_name(), candidate.getLast_name(),
                candidate.getNationality_id(), candidate.getBirthdate());
        
        boolean result = fakeCheckService.validate(fakePerson);
        if(result){
            return new SuccessResult();
        }
        return new ErrorResult(Info.personInValidInfo);
    }

}

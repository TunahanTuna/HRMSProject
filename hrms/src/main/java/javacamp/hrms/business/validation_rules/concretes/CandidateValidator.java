package javacamp.hrms.business.validation_rules.concretes;

import java.util.Date;

import org.springframework.stereotype.Component;

import javacamp.hrms.business.constraints.Info;
import javacamp.hrms.business.validation_rules.abstracts.CandidateValidatorService;
import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Candidate;

@Component
public class CandidateValidator extends UserValidator implements CandidateValidatorService{

	@Override
	public Result candidateNullCheck(Candidate candidate) {
		String firstName = candidate.getFirst_name();
        String lastName = candidate.getLast_name();
        String nationalityId = candidate.getNationality_id();
        Date birthDate = candidate.getBirthdate();
        
        if(super.userNullChack(candidate).isSuccess() &&
        		(firstName == null || firstName.isBlank()) &&
        		(lastName == null || lastName.isBlank()) &&
        		(nationalityId == null || nationalityId.isBlank()) &&
        		birthDate == null) {
        	return new ErrorResult(Info.nullInfo);
        }
		return new SuccessResult();
	}

	@Override
	public Result nationalityIdValid(String nationalityIdentity) {
		if(nationalityIdentity.length() == 11) {
			return new SuccessResult();
		}
		return new ErrorResult(Info.nationalIdentityInvalidInfo);
	}

}

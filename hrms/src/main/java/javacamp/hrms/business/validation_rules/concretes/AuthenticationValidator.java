package javacamp.hrms.business.validation_rules.concretes;

import org.springframework.stereotype.Component;

import javacamp.hrms.business.constraints.Info;
import javacamp.hrms.business.validation_rules.abstracts.AuthanticationValidatorService;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.*;

@Component
public class AuthenticationValidator implements AuthanticationValidatorService{

	@Override
	public Result isPasswordConfirm(String password, String passwordConfirm) {
		
		if(password.equals(passwordConfirm)) {
			return new ErrorResult(Info.passwordConfirmedErrorInfo);
		}
		
		return new SuccessResult(Info.passwordConfirmedSuccessInfo);
	}

}

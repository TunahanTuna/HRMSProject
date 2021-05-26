package javacamp.hrms.business.validation_rules.concretes;

import javacamp.hrms.business.constraints.Info;
import javacamp.hrms.business.validation_rules.abstracts.UserValidatorService;
import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.abstracts.User;

public class UserValidator implements UserValidatorService {

	@Override
	public Result userNullChack(User user) {
		if((user.getMail() == null || user.getMail().isBlank()) && (user.getPassword() == null || user.getPassword().isBlank())) {
			return new ErrorResult(Info.nullInfo);
		}
		return new SuccessResult();
	}

}

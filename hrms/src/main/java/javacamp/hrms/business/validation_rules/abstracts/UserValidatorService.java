package javacamp.hrms.business.validation_rules.abstracts;

import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.abstracts.User;

public interface UserValidatorService {

	Result userNullChack(User user);
	
}

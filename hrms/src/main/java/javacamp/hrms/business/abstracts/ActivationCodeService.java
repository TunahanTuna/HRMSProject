package javacamp.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.ActivationCode;

public interface ActivationCodeService {

	 DataResult<List<ActivationCode>> getAll();
	 Result add(ActivationCode activationCode);
	 Result update(ActivationCode activationCode);
	 DataResult<Optional<ActivationCode>> getByUserId(int userId);
	
}

package javacamp.hrms.business.abstracts;

import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.ActivationCode;

public interface ActivationCodeService {

	Result add(ActivationCode activationCode);
}

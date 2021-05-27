package javacamp.hrms.business.abstracts.authantication_services;

import javacamp.hrms.core.utilities.results.Result;

public interface VerifyService {
    Result verify(int userId, String activationCode);

}

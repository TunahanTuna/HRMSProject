package javacamp.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;

import javacamp.hrms.business.abstracts.EmployerService;
import javacamp.hrms.business.validation_rules.abstracts.EmployerValidatorService;
import javacamp.hrms.core.utilities.business.BusinessEngine;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.dataAccess.abstracts.EmployerDao;
import javacamp.hrms.dataAccess.abstracts.UserDao;
import javacamp.hrms.entities.concretes.Employer;

public class EmployerManager extends UserManager<Employer> implements EmployerService {

	private EmployerValidatorService employerValidatorService;
	
	@Autowired
	public EmployerManager(UserDao<Employer> userDao, EmployerValidatorService employerValidatorService) {
		super(userDao);
		this.employerValidatorService = employerValidatorService;
	}
	
	@Override // UserManagerden Override Edildi.
    public Result add(Employer employer) {
        Result result= BusinessEngine.run(employerValidatorService.employerNullCheck(employer),
                employerValidatorService.isEmailCheck(employer));
        if(result.isSuccess()){
        return super.add(employer);
        }
        return result;
    }

}

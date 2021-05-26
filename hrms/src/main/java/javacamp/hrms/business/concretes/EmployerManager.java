package javacamp.hrms.business.concretes;

import javacamp.hrms.business.abstracts.EmployerService;
import javacamp.hrms.dataAccess.abstracts.EmployerDao;
import javacamp.hrms.dataAccess.abstracts.UserDao;
import javacamp.hrms.entities.concretes.Employer;

public class EmployerManager extends UserManager<Employer> implements EmployerService {

	private EmployerDao employerDao;
	
	public EmployerManager(UserDao<Employer> userDao) {
		super(userDao);
		this.employerDao = (EmployerDao)userDao; // typecast
	}

}

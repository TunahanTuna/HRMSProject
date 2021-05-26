package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.UserService;
import javacamp.hrms.business.constraints.Info;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.UserDao;
import javacamp.hrms.entities.abstracts.User;

@Service
public class UserManager<T extends User> implements UserService<T>{

	private UserDao userDao;
	
	
	
	public UserManager(UserDao<T> userDao) {
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<T>> getAll() {
		return new SuccessDataResult<List<T>>(this.userDao.findAll(),Info.listInfo);
	}

	@Override
	public Result add(T t) {
		this.userDao.save(t);
		return new SuccessResult(Info.addInfo);
	}
	
	public Result isEmailExist(String eMail) {
		if(userDao.findByEmail(eMail).isPresent()) {
			return new ErrorResult(Info.emailExistingInfo);
		}
		
		return new SuccessResult();
	}
	

}

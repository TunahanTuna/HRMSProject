package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.UserService;
import javacamp.hrms.business.constraints.Info;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.dataAccess.abstracts.UserDao;
import javacamp.hrms.entities.abstracts.User;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		if(getUserByEmail(user.getEmail()).getData() != null) {
			return new ErrorResult(Info.emailExistingInfo);
		}
		this.userDao.save(user);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll());
	}

	@Override
	public DataResult<User> getUserByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(email));
	}

}

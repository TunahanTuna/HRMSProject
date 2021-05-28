package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.abstracts.User;

public interface UserService {

	Result add(User user);
	
	public DataResult<List<User>> getAll();
	
	public DataResult<User> getUserByEmail(String email);
	
}

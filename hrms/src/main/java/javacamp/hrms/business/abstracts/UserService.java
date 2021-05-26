package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.abstracts.User;
// Generic Yapı
public interface UserService<T extends User> {
	
	DataResult<List<T>>getAll();
	
	Result add(T t);

}

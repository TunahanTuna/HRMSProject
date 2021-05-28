package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javacamp.hrms.entities.abstracts.User;


@EnableJpaRepositories
public interface UserDao extends JpaRepository<User, Integer>{

	User findByEmail(String email);
	
}

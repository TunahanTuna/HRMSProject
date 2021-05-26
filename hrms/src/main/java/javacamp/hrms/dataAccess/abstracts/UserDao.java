package javacamp.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.abstracts.User;

public interface UserDao<T extends User> extends JpaRepository<T, Integer> {
	
	Optional<T> findByEmail(String Email);

}

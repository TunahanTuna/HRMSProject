package javacamp.hrms.core.adapters.mernis.service;

import javacamp.hrms.entities.concretes.Candidate;

public interface UserCheckService {

	boolean checkIfRealPerson(Candidate candidate);
	
}

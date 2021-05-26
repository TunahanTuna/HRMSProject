package javacamp.hrms.dataAccess.abstracts;

import java.util.Optional;

import javacamp.hrms.entities.concretes.Candidate;

public interface CandidateDao extends UserDao<Candidate>{

	Optional<Candidate> findByNationalIdentity(String nationalIdentity);
	
}

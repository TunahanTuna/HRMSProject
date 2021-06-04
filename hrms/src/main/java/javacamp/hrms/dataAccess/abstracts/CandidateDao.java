package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javacamp.hrms.entities.concretes.Candidate;


@EnableJpaRepositories
public interface CandidateDao extends JpaRepository<Candidate, Integer> {

	Candidate getById(int id);
	
	Candidate findByNationalityId(String nationalityId);
	
}

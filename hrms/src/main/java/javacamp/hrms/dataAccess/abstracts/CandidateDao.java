package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javacamp.hrms.entities.concretes.Candidate;


@EnableJpaRepositories
public interface CandidateDao extends JpaRepository<Candidate, Integer> {

	Candidate findByNationalityId(String nationalityId);
	
}

package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.CvExperience;

public interface CvExperienceDao  extends JpaRepository<CvExperience, Integer> {

	List<CvExperience> getAllByCandidate_idOrderByEndYearDesc(int id);
	
}

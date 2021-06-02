package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.CvEducation;

public interface CvEducationDao extends JpaRepository<CvEducation, Integer>{
	
	
	List<CvEducation> getAllByCandidate_idOrderByGraduationYearDesc(int id);
	List<CvEducation> getAllByCandidate_idOrderByGraduationYearAsc(int id);
}

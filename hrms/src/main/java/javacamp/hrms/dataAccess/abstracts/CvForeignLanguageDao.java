package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.CvForeignLanguage;

public interface CvForeignLanguageDao extends JpaRepository<CvForeignLanguage, Integer> {

	CvForeignLanguage getByLanguageId(int id);
	List<CvForeignLanguage> getAllByCandidate_id(int id);
	
}

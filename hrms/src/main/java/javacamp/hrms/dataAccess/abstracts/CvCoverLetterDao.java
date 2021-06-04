package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.CvCoverLetter;

public interface CvCoverLetterDao extends JpaRepository<CvCoverLetter, Integer>{
	
	CvCoverLetter getById(int id);
	
	List<CvCoverLetter> getAllByCandidate_id(int id);

}

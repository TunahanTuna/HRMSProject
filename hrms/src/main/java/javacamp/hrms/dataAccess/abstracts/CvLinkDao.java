package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.*;

public interface CvLinkDao extends JpaRepository<CvLink, Integer>{

	CvLink getByLinkId(int id);
	List<CvLink> getAllByCandidate_id(int id);
	
}

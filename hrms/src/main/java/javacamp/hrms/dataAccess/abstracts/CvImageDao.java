package javacamp.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.CvImage;

public interface CvImageDao extends JpaRepository<CvImage,Integer>{

	CvImage getByImageId(int id);
	
	CvImage getByCandidate_id(int id); // One T One ilişki var bu yüzden sadece bir tane fotoğraf olur. Liste kullanılmaz.
	
}

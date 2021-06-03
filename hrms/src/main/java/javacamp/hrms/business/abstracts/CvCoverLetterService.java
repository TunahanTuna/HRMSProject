package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.entities.concretes.CvCoverLetter;

public interface CvCoverLetterService {
	Result add(CvCoverLetter cvCoverLetter);
	Result update(CvCoverLetter cvCoverLetter);
	Result delete(int id);
	
	DataResult<CvCoverLetter> getById(int id);
	DataResult<List<CvCoverLetter>> getAll();
	DataResult<List<CvCoverLetter>> getAllByCandidate_id(int id);
}

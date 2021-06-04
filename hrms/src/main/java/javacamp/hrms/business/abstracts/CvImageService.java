package javacamp.hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.entities.concretes.CvImage;

public interface CvImageService {

	Result add(CvImage cvImage,  MultipartFile filePath)throws IOException ;
	Result update(CvImage cvImage);
	Result delete(int id);
	
	DataResult<CvImage> getByImageId(int id);
	DataResult<CvImage> getByCandidate_id(int id);
	
	DataResult<List<CvImage>> getAll();
}

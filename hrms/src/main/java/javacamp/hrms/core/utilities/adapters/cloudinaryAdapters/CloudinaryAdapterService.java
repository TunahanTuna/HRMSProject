package javacamp.hrms.core.utilities.adapters.cloudinaryAdapters;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.core.utilities.results.DataResult;


public interface CloudinaryAdapterService {
	
	DataResult<Map> uploadImage(MultipartFile filePath);

}

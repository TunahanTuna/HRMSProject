package javacamp.hrms.core.utilities.adapters.cloudinaryAdapters;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import javacamp.hrms.core.utilities.results.*;

@Service
public class CloudinaryAdapterManager implements CloudinaryAdapterService {

	private Cloudinary cloudinary;

	public CloudinaryAdapterManager() {
		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "jausska",
				"api_key", "486168234275913",
				"api_secret", "ecEiqzeu5H47dAPbd8-0Lgjlho8"
				));
	}

	@Override
	public DataResult<Map> uploadImage(MultipartFile filePath) throws IOException {

		Map<String,Object> result = (Map<String,Object>)cloudinary.uploader().upload(filePath.getBytes(), ObjectUtils.emptyMap());
	
		return new SuccessDataResult<Map>(result);
	}
	
}

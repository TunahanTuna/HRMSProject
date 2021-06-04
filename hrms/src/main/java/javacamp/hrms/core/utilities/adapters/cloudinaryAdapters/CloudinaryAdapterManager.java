package javacamp.hrms.core.utilities.adapters.cloudinaryAdapters;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

public class CloudinaryAdapterManager implements CloudinaryAdapterService {

	private Cloudinary cloudinary;

	public CloudinaryAdapterManager() {
		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "jausska",
				"api_key", "486168234275913",
				"api_secret", "ecEiqzeu5H47dAPbd8-0Lgjlho8"
				));
	}
	
}

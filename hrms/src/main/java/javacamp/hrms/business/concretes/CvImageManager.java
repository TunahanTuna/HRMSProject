package javacamp.hrms.business.concretes;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.business.abstracts.CvImageService;
import javacamp.hrms.core.utilities.adapters.cloudinaryAdapters.CloudinaryAdapterService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CvImageDao;
import javacamp.hrms.entities.concretes.CvImage;

@Service
public class CvImageManager implements CvImageService {

	private CvImageDao cvImageDao;
	private CloudinaryAdapterService cloudinaryAdapterService;
	
	@Autowired
	public CvImageManager(CvImageDao cvImageDao, CloudinaryAdapterService cloudinaryAdapterService) {
		this.cvImageDao = cvImageDao;
		this.cloudinaryAdapterService = cloudinaryAdapterService;
	}

	@Override
	public Result add(CvImage cvImage, MultipartFile filePath) throws IOException {

		Map<String,Object> image = this.cloudinaryAdapterService.uploadImage(filePath).getData();
		cvImage.setUrl(image.get("url").toString());
		this.cvImageDao.save(cvImage);
		return new SuccessResult("Ekleme başarılı");
	}

	@Override
	public Result update(CvImage cvImage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<CvImage> getByImageId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<CvImage> getByCandidate_id(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<CvImage>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

package javacamp.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.business.abstracts.CvImageService;
import javacamp.hrms.core.utilities.adapters.cloudinaryAdapters.CloudinaryAdapterService;
import javacamp.hrms.core.utilities.results.*;
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
	public Result add(CvImage cvImage, MultipartFile filePath){

		Map<String,String> image = this.cloudinaryAdapterService.uploadImage(filePath).getData();
		cvImage.setUrl(image.get("url"));
		this.cvImageDao.save(cvImage);
		return new SuccessResult("Ekleme başarılı");
	}

	@Override
	public Result update(CvImage cvImage) {
		this.cvImageDao.save(cvImage);
		return new SuccessResult("Güncelleme başarılı");
	}

	@Override
	public Result delete(int id) {
		this.cvImageDao.deleteById(id);
		return new SuccessResult("Silme başarılı");
	}

	@Override
	public DataResult<CvImage> getByImageId(int id) {
		return new SuccessDataResult<CvImage>(this.cvImageDao.getByImageId(id));
	}

	@Override
	public DataResult<CvImage> getByCandidate_id(int id) {
		return new SuccessDataResult<CvImage>(this.cvImageDao.getByCandidate_id(id));
	}

	@Override
	public DataResult<List<CvImage>> getAll() {
		return new SuccessDataResult<List<CvImage>>(this.cvImageDao.findAll());
	}

}

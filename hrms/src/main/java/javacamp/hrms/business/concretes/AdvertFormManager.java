package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.AdvertFormService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.dataAccess.abstracts.AdvertFormDao;
import javacamp.hrms.entities.concretes.AdvertForm;

@Service
public class AdvertFormManager implements AdvertFormService{

	private AdvertFormDao advertFormDao;
	
	@Autowired
	public AdvertFormManager(AdvertFormDao advertFormDao) {
		this.advertFormDao = advertFormDao;
	}

	@Override
	public DataResult<AdvertForm> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<AdvertForm>> getAll() {
		return new SuccessDataResult<List<AdvertForm>>(this.advertFormDao.findAll(),
														"Liste Getirildi");
	}

	@Override
	public DataResult<List<AdvertForm>> getAllOpenAdverts() {
		return new SuccessDataResult<List<AdvertForm>>(this.advertFormDao.getAllOpenAdverts(),
														"Liste Getirildi");
	}

	@Override
	public DataResult<List<AdvertForm>> getAllByOrderByDescPublishDate() {

		return new SuccessDataResult<List<AdvertForm>>(this.advertFormDao.getAllByOrderByPublishDateDesc(),
														"Liste Getirildi");
	}

	@Override
	public DataResult<List<AdvertForm>> getAllOpenJobAdvertByEmployer(int id) {
		return new SuccessDataResult<List<AdvertForm>>(this.advertFormDao.getAllOpenAdvertByEmployer(id),
														"Liste Getirildi");
	}
	
	
	private boolean CheckNullField(AdvertForm AdvertForm) {
		if (AdvertForm.getJobPosition() != null && AdvertForm.getDescription() != null && AdvertForm.getCity() != null
				&& AdvertForm.getOpenPositionNumber() != 0) {
			return true;
		}
		return false;
	}

	@Override
	public Result add(AdvertForm advertForm) {
		if (!CheckNullField(advertForm)) {
			return new ErrorResult("Bos alan var");
		}
		
		this.advertFormDao.save(advertForm);
		return new SuccessResult("Is ilani eklendi");
	}

	@Override
	public Result update(AdvertForm advertForm) {
	
		this.advertFormDao.save(advertForm);
		return new SuccessResult("Is ilani guncellendi");
	}

}

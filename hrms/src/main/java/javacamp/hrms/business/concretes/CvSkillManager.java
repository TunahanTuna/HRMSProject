package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.CvSkillService;
import javacamp.hrms.business.constraints.Info;
import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.dataAccess.abstracts.CvSkillDao;
import javacamp.hrms.entities.concretes.CvSkill;

@Service
public class CvSkillManager implements CvSkillService {

	private CvSkillDao cvSkillDao;

	@Autowired
	public CvSkillManager(CvSkillDao cvSkillDao) {
		this.cvSkillDao = cvSkillDao;
	}

	@Override
	public Result add(CvSkill cvSkill) {
		this.cvSkillDao.save(cvSkill);
		return new SuccessResult("Ekleme başarılı");
	}

	@Override
	public Result update(CvSkill cvSkill) {
		this.cvSkillDao.save(cvSkill);
		return new SuccessResult("Güncelleme başarılı");
	}

	@Override
	public Result delete(int id) {
		this.cvSkillDao.deleteById(id);
		return new SuccessResult("Silme başarılı");
	}

	@Override
	public DataResult<CvSkill> getById(int id) {
		return new SuccessDataResult<CvSkill>(this.cvSkillDao.getBySkillId(id),Info.listInfo);
	}

	@Override
	public DataResult<List<CvSkill>> getAll() {
		return new SuccessDataResult<List<CvSkill>>(this.cvSkillDao.findAll(),Info.listInfo);
	}

	@Override
	public DataResult<List<CvSkill>> getAllByCandidate_id(int id) {
		return new SuccessDataResult<List<CvSkill>>(this.cvSkillDao.getAllByCandidate_id(id),Info.listInfo);
	}
	
}

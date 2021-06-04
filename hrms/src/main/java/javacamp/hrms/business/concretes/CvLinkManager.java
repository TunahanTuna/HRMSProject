package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.CvLinkService;
import javacamp.hrms.business.constraints.Info;
import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.dataAccess.abstracts.CvLinkDao;
import javacamp.hrms.entities.concretes.CvLink;

@Service
public class CvLinkManager implements CvLinkService{

	private CvLinkDao cvLinkDao;
	
	@Autowired
	public CvLinkManager(CvLinkDao cvLinkDao) {
		this.cvLinkDao = cvLinkDao;
	}

	@Override
	public Result add(CvLink cvLink) {
		this.cvLinkDao.save(cvLink);
		return new SuccessResult("Ekleme Başarılı");
	}

	@Override
	public Result update(CvLink cvLink) {
		this.cvLinkDao.save(cvLink);
		return new SuccessResult("Guncelleme Başarılı");
	}

	@Override
	public Result delete(int id) {
		this.cvLinkDao.deleteById(id);
		return new SuccessResult("Silme Başarılı");
	}

	@Override
	public DataResult<CvLink> getAllById(int id) {
		return new SuccessDataResult<CvLink>(this.cvLinkDao.getByLinkId(id),Info.listInfo);
	}

	@Override
	public DataResult<List<CvLink>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<CvLink>>(this.cvLinkDao.getAllByCandidate_id(id),Info.listInfo);
	}

	@Override
	public DataResult<List<CvLink>> getAll() {
		return new SuccessDataResult<List<CvLink>>(this.cvLinkDao.findAll(),Info.listInfo);
	}

}

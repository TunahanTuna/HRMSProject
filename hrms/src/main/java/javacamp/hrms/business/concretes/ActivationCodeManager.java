package javacamp.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.ActivationCodeService;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.ActivationCodeDao;
import javacamp.hrms.entities.concretes.ActivationCode;

@Service
public class ActivationCodeManager implements ActivationCodeService{
	
private ActivationCodeDao verificationCodeDao;
	
	@Autowired
	public ActivationCodeManager(ActivationCodeDao activationCodeDao, ActivationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
	}

	@Override
	public Result add(ActivationCode activationCode) {
		this.verificationCodeDao.save(activationCode);
		return new SuccessResult("Kod kaydedildi.");
	}
}

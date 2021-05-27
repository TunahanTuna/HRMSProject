package javacamp.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.ActivationCodeService;
import javacamp.hrms.business.constraints.Info;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.core.utilities.verification_tool.CodeGenerator;
import javacamp.hrms.dataAccess.abstracts.ActivationCodeDao;
import javacamp.hrms.entities.concretes.ActivationCode;

@Service
public class ActivationCodeManager implements ActivationCodeService {

	 private ActivationCodeDao activationCodeDao;

	    @Autowired
	    public ActivationCodeManager(ActivationCodeDao activationCodeDao) {
	        this.activationCodeDao = activationCodeDao;
	    }

	    @Override
	    public DataResult<List<ActivationCode>> getAll() {
	        return new SuccessDataResult<List<ActivationCode>>(this.activationCodeDao.findAll(),Info.activationCodeListedInfo);
	    }

	    @Override
	    public Result add(ActivationCode activationCode) {
	        activationCode.setExprationDate(LocalDateTime.now().plusMinutes(5));
	        activationCode.setU_id(CodeGenerator.UuIdCodeGenerator());
	        activationCodeDao.save(activationCode);
	        return new SuccessResult(Info.activationCodeAddedInfo);
	    }

	    @Override
	    public Result update(ActivationCode activationCode) {
	        activationCodeDao.save(activationCode);
	        return new SuccessResult(Info.activationCodeUpdatedInfo);
	    }

	    @Override
	    public DataResult<Optional<ActivationCode>> getByUserId(int userId) {
	        return new SuccessDataResult<Optional<ActivationCode>>(activationCodeDao.findByUserId(userId));
	    }
	
}

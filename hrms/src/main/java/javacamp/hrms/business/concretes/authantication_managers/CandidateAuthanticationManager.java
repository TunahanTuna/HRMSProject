package javacamp.hrms.business.concretes.authantication_managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.ActivationCodeService;
import javacamp.hrms.business.abstracts.CandidateService;
import javacamp.hrms.business.abstracts.authantication_services.CandidateAuthanticationService;
import javacamp.hrms.business.constraints.Info;
import javacamp.hrms.business.validation_rules.abstracts.AuthanticationValidatorService;
import javacamp.hrms.core.utilities.business.BusinessEngine;
import javacamp.hrms.core.utilities.email_tool.abstracts.EmailSendService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorDataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.core.utilities.verification_tool.CodeGenerator;
import javacamp.hrms.entities.concretes.ActivationCode;
import javacamp.hrms.entities.concretes.Candidate;
import javacamp.hrms.entities.dtos.RegisterForCandidateDto;

@Service
public class CandidateAuthanticationManager implements CandidateAuthanticationService {

	private AuthanticationValidatorService authValidatorService;
    private CandidateService candidateService;
    private ActivationCodeService activationCodeService;
    private EmailSendService emailSenderService;

    @Autowired
    public CandidateAuthanticationManager(AuthanticationValidatorService authValidatorService,
    							CandidateService candidateService,
                                ActivationCodeService activationCodeService, 
                                EmailSendService emailSenderService) {
        this.authValidatorService = authValidatorService;
        this.candidateService = candidateService;
        this.activationCodeService = activationCodeService;
        this.emailSenderService = emailSenderService;
    }

    @Override
    public Result register (RegisterForCandidateDto registerForCandidateDto) {
        Result result = BusinessEngine.run(authValidatorService
        							  .isPasswordConfirm(registerForCandidateDto.getPassword(),
        							   registerForCandidateDto.getConfirmPassword()));
        if (!result.isSuccess()) {
            return result;
        }
        DataResult<Candidate> addResult = candidateAdd(registerForCandidateDto);
        if (!addResult.isSuccess()) {
            return addResult;
        }
        String code = CodeGenerator.UuIdCodeGenerator();
        Result codeAddResult = activationCodeAdd(addResult.getData().getId(), code);
        if (!codeAddResult.isSuccess()) {
            return codeAddResult;
        }
        emailSenderService.send("Doğrulama işin linke tıklayınız : https://dogrulama.deneme/" + code);
        return new SuccessResult(Info.addInfo);
    }


    private DataResult<Candidate> candidateAdd(RegisterForCandidateDto registerForCandidateDto) {
        Candidate candidate = new Candidate(registerForCandidateDto.getFirstName(), registerForCandidateDto.getLastName()
                , registerForCandidateDto.getNationalIdentity(), registerForCandidateDto.getDateOfBirth(), registerForCandidateDto.getEmail(), registerForCandidateDto.getPassword());
        Result addResult = candidateService.add(candidate);
        if (!addResult.isSuccess()) {
            return new ErrorDataResult<>(null, addResult.getMessage());
        }
        return new SuccessDataResult<Candidate>(candidate);
    }

    private Result activationCodeAdd(int userId, String code) {
        ActivationCode activationCode = new ActivationCode(userId, code);
        Result activationResult = activationCodeService.add(activationCode);
        if (!activationResult.isSuccess()) {
            return activationResult;
        }
        return new SuccessResult();
    }
	
}

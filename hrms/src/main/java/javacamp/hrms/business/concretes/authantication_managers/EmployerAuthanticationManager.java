package javacamp.hrms.business.concretes.authantication_managers;

import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.ActivationCodeService;
import javacamp.hrms.business.abstracts.EmployerService;
import javacamp.hrms.business.abstracts.authantication_services.EmployerAuthanticationService;
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
import javacamp.hrms.entities.concretes.Employer;
import javacamp.hrms.entities.dtos.RegisterForEmployerDto;


@Service
public class EmployerAuthanticationManager implements EmployerAuthanticationService {
    private AuthanticationValidatorService authValidatorService;
    private EmployerService employerService;
    private ActivationCodeService activationCodeService;
    private EmailSendService emailSenderService;

    public EmployerAuthanticationManager(EmployerService employerService, AuthanticationValidatorService authValidatorService, ActivationCodeService activationCodeService,
                                EmailSendService emailSenderService) {
        this.authValidatorService = authValidatorService;
        this.employerService = employerService;
        this.activationCodeService = activationCodeService;
        this.emailSenderService = emailSenderService;
    }

    @Override
    public Result register(RegisterForEmployerDto registerForEmployerDto) {
        Result result = BusinessEngine.run(authValidatorService
                .isPasswordConfirm(registerForEmployerDto.getPassword(),
                        registerForEmployerDto.getConfirmPassword()));
        if (!result.isSuccess()) {
            return result;
        }
        DataResult<Employer> addResult = employerAdd(registerForEmployerDto);
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


    private DataResult<Employer>employerAdd(RegisterForEmployerDto registerForEmployerDto){
        Employer employer = new Employer(registerForEmployerDto.getCompanyName(), registerForEmployerDto.getWebAdress(),
                registerForEmployerDto.getPhoneNumber(),registerForEmployerDto.getEmail(),registerForEmployerDto.getPassword());
        Result addResult = employerService.add(employer);
        if (!addResult.isSuccess()) {
            return new ErrorDataResult<>(null, addResult.getMessage());
        }
        return new SuccessDataResult<Employer>(employer);
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
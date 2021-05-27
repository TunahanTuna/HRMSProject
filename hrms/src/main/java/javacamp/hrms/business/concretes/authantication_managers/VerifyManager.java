package javacamp.hrms.business.concretes.authantication_managers;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.ActivationCodeService;
import javacamp.hrms.business.abstracts.authantication_services.VerifyService;
import javacamp.hrms.business.constraints.Info;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.entities.concretes.ActivationCode;

@Service
public class VerifyManager implements VerifyService {

    private ActivationCodeService activationCodeService;

    @Autowired
    public VerifyManager(ActivationCodeService activationCodeService) {
        this.activationCodeService = activationCodeService;
    }

    public Result verify(int userId, String activationCode) {
        Optional<ActivationCode> activation = activationCodeService.getByUserId(userId).getData();
        Result result = subVerify(activation,activationCode);
        if(!result.isSuccess()){
            return result;
        }
        activation.get().setActivation_date(LocalDateTime.now());
        activation.get().set_confirmed(true);
        activationCodeService.update(activation.get());
        return new SuccessResult(Info.codeVerifiedInfo);
    }

    private Result subVerify(Optional<ActivationCode> activation, String activationCode){
        if (activation.isEmpty()) {
            return new ErrorResult(Info.codeNotFoundInfo);
        }
        if (activation.get().is_confirmed()) {
            return new ErrorResult(Info.activationExistInfo);
        }
        if (activation.get().getExprationDate().isBefore(LocalDateTime.now())) {
            return new ErrorResult(Info.codeExpiredInfo);
        }
        if (!activation.get().getActivationCode().equals(activationCode)) {
            return new ErrorResult(Info.codeNotEqualInfo);
        }
        return new SuccessResult();
    }
}
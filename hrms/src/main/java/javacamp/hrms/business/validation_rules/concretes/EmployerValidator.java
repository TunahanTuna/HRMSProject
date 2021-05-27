package javacamp.hrms.business.validation_rules.concretes;

import org.springframework.stereotype.Component;

import javacamp.hrms.business.constraints.Info;
import javacamp.hrms.business.validation_rules.abstracts.EmployerValidatorService;
import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Employer;


@Component
public class EmployerValidator extends UserValidator implements EmployerValidatorService {

	@Override
	public Result employerNullCheck(Employer employer) {
		String companyName = employer.getCompany_name();
		String webSite = employer.getWeb_site();
		String phoneNumber = employer.getPhone_number();
		
		if(super.userNullChack(employer).isSuccess() && (companyName == null || companyName.isBlank()) &&
				(webSite == null || webSite.isBlank()) && (phoneNumber == null || phoneNumber.isBlank())) {
			
			return new ErrorResult(Info.nullInfo);
		}
		return new SuccessResult();
	}

	@Override
	public Result isEmailCheck(Employer employer) {
		String email = employer.getMail();
        String webSite = employer.getWeb_site();
        
        String domain = webSite.split("www.")[1]; // www bolumunden ikiye ayirir ikinci parcayı alir
        // E-Mail ile web sitesinin domainlerinin uyusup uyusmadigi kontrol edilir.
        if(domain.equals(email.split("@")[1])) {
        	return new SuccessResult();
        }
		return new ErrorResult("Gecersiz Mail");
	}

}

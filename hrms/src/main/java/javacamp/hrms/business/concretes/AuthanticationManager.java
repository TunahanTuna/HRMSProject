package javacamp.hrms.business.concretes;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.ActivationCodeService;
import javacamp.hrms.business.abstracts.AuthanticationService;
import javacamp.hrms.business.abstracts.CandidateService;
import javacamp.hrms.business.abstracts.EmployerService;
import javacamp.hrms.business.abstracts.UserService;
import javacamp.hrms.business.constraints.Info;
import javacamp.hrms.core.services.verification.VerificationService;
import javacamp.hrms.core.utilities.adapters.ValidationService;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.*;
import javacamp.hrms.entities.abstracts.User;
import javacamp.hrms.entities.concretes.ActivationCode;
import javacamp.hrms.entities.concretes.Candidate;
import javacamp.hrms.entities.concretes.Employer;

@Service
public class AuthanticationManager implements AuthanticationService{
	
	private CandidateService candidateService;
	private EmployerService employerService;
	private ValidationService validationService;
	private ActivationCodeService activationCodeService;
	private UserService userService;
	private VerificationService verificationService;
	
	
	@Autowired
	public AuthanticationManager(CandidateService candidateService, EmployerService employerService,
			ValidationService validationService, ActivationCodeService activationCodeService, UserService userService,
			VerificationService verificationService) {
		
		this.candidateService = candidateService;
		this.employerService = employerService;
		this.validationService = validationService;
		this.activationCodeService = activationCodeService;
		this.userService = userService;
		this.verificationService = verificationService;
	}

	@Override
	public Result employerRegister(Employer employer, String confirmedPassword) {
		if (!checkEmployerNull(employer)) {

			return new ErrorResult(Info.nullInfo);
		}

		if (!checkEmailAndDomain(employer)) {

			return new ErrorResult(Info.emailExistingInfo);
		}

		if (!checkEmailExist(employer)) {

			return new ErrorResult(Info.emailExistingInfo);
		}

		if (!checkPasswordAndConfirmedPassword(employer.getPassword(), confirmedPassword)) {

			return new ErrorResult(Info.passwordConfirmedErrorInfo);
		}

		employerService.add(employer); // Is veren Ekler
		
		String code = verificationService.sendActivationCode();// Aktivasyon kodu ekler
		ActivationCodeCreater(code, employer.getId(), employer.getEmail());
		
		return new SuccessResult(Info.SuccessfullyRegister);
	}

	@Override
	public Result candidateRegister(Candidate candidate, String confirmedPassword) {
		if (checkWithMernis(Long.parseLong(candidate.getNationalityId()), candidate.getFirstName(),
				candidate.getLastName(), candidate.getBirthDate().getYear()) == false) {
			return new ErrorResult(Info.personInValidInfo);
		}

		if (!checkCandidateNull(candidate, confirmedPassword)) {

			return new ErrorResult(Info.nullInfo);
		}

		if (!checkExistNationalityId(candidate.getNationalityId())) {

			return new ErrorResult(Info.nationalityIdentityExistingInfo);
		}

		if (!checkEmailExist(candidate)) {

			return new ErrorResult(Info.emailExistingInfo);
		}

		
		candidateService.add(candidate); // Adayi Ekler
		
		String code = verificationService.sendActivationCode(); // Aktivasyon kodu ekler
		ActivationCodeCreater(code, candidate.getId(), candidate.getEmail());
		
		return new SuccessResult(Info.SuccessfullyRegister);
	}
	
	// employer alanlarının dolu olup olmadığının kontrolü
	private boolean checkEmployerNull(Employer employer) {
		if((employer.getCompanyName() == null || employer.getCompanyName().isBlank()) && 
				(employer.getWebSite() == null || employer.getWebSite().isBlank()) &&
				(employer.getPhoneNumber() == null || employer.getPhoneNumber().isBlank()) &&
				(employer.getEmail() == null || employer.getEmail().isBlank()) &&
				(employer.getPassword() == null || employer.getPassword().isBlank())) {
			
			return false;
		}
		
		return true;
	}
	// Employer mail ve domain kontrolu
	private boolean checkEmailAndDomain(Employer employer) {
		
		String[] emailArr = employer.getEmail().split("@",2);
		
		String domain = employer.getWebSite().substring(4,employer.getWebSite().length());
		
		if(!emailArr[1].equals(domain)) {
			return false;
		}
		
		return true;
	}
	
	// Aday bilgilerinin alanlarının doluluk kontrolu
	private boolean checkCandidateNull(Candidate candidate, String confirmedPassword) {
		if((candidate.getFirstName() == null || candidate.getFirstName().isBlank()) && 
				(candidate.getLastName() == null || candidate.getLastName().isBlank()) &&
				(candidate.getNationalityId() == null || candidate.getNationalityId().isBlank()) &&
				(candidate.getBirthDate() == null) &&
				(candidate.getEmail() == null || candidate.getEmail().isBlank()) &&
				(candidate.getPassword() == null || candidate.getPassword().isBlank()) &&
				(confirmedPassword == null || confirmedPassword.isBlank())) {
			
			return false;
		}
		
		return true;
	}
	
	// TC kimlik numaraasi kontrolu
	private boolean checkExistNationalityId(String nationalityId) {

		if (this.candidateService.getCandidateByNationalityId(nationalityId).getData() == null &&
				nationalityId.length() == 11) {
			return true;
		}
		
		return false;
	}
	
	// Mernis Kontrolu
	private boolean checkWithMernis(long nationalId, String firstName, String lastName, int birthYear) {

		if (validationService.checkService(nationalId, firstName, lastName, birthYear)) {
			return true;
		}
		
		return false;
	}
	
	// Userlar icin email kontrolu
	private boolean checkEmailExist(User user) {

		if (!(this.userService.getUserByEmail(user.getEmail().toString()).getData() == null)) {
			return false;
		}
		return true;
		
	}
	
	// Aktivasyon Kodu olusturucu
	private void ActivationCodeCreater(String code, int id, String email) {
		
		ActivationCode activationCode = new ActivationCode(id, code, false, LocalDate.now());
		this.activationCodeService.add(activationCode);
	
	}
	
	// Password check
	private boolean checkPasswordAndConfirmedPassword(String password, String confirmedPassword) {

		if (password.equals(confirmedPassword)) {
			return true;
		}

		return false;
	}

}

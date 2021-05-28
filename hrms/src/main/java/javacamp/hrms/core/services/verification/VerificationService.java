package javacamp.hrms.core.services.verification;

public interface VerificationService {
	
	void sendLink(String email);
	
	String sendActivationCode();
}
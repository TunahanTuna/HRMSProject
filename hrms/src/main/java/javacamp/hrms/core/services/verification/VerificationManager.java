package javacamp.hrms.core.services.verification;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class VerificationManager implements VerificationService{

	@Override
	public void sendLink(String email) {

		UUID uuidCode = UUID.randomUUID();
		String verifyLink = "https://verifylink/" + uuidCode.toString();
		System.out.println("Dogrulama baglantisi email adresinize gonderildi:" + " " + email );
		System.out.println("Hesabinizi onaylama icin tiklayiniz:" + " " + verifyLink );



	}

	@Override
	public String sendActivationCode() {
		UUID uuidCode = UUID.randomUUID();
		String activationCode = uuidCode.toString();
		System.out.println("Aktivasyon kodunuz:"+ " " + activationCode );
		
		return activationCode;
	}

}

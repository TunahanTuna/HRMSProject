package javacamp.hrms.core.adapters.mernis.concrete;

import javacamp.hrms.core.adapters.mernis.service.UserCheckService;
import javacamp.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements UserCheckService{

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		KPSPublicSoap client = new KPSPublicSoapProxy();
		boolean result = false;
		try {
			result = client.TCKimlikNoDogrula(Long.parseLong(candidate.getNationality_id()),
											candidate.getFirst_name(),candidate.getLast_name(),
											candidate.getBirthdate().getYear());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}

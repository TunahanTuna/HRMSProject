package javacamp.hrms.core.utilities.adapters;

import org.springframework.stereotype.Service;

import javacamp.hrms.core.services.FakeMernisService;

@Service
public class MernisServiceAdapter implements ValidationService {

	
	@Override
	public boolean checkService(long nationalityId, String firstName, String lastName, int birthYear) {
		
		FakeMernisService fakeMernisService = new FakeMernisService();
		
		boolean result = false; 
		try {
			
			result = fakeMernisService.ValidateByPersonWithMernis(nationalityId, firstName, lastName, birthYear);
			
			
		}catch(Exception e){
			return false;
		}
		
		return result;
	}

}

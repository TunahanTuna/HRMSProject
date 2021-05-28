package javacamp.hrms.core.services;

public class FakeMernisService {

	public boolean ValidateByPersonWithMernis(long nationalityId,String firstName, String lastName, int birthYear)
	{
		System.out.println(firstName + " " + lastName + " Gercek bir kisidir." );
		return true;
	}
	
}

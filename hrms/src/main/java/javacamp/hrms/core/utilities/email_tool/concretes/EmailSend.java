package javacamp.hrms.core.utilities.email_tool.concretes;

import javacamp.hrms.core.utilities.email_tool.abstracts.EmailSendService;

public class EmailSend implements EmailSendService{

	@Override
	public void send(String mailContent) {
		
		System.out.println(mailContent);
		
	}

}

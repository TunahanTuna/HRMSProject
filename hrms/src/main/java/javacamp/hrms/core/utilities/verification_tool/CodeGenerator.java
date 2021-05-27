package javacamp.hrms.core.utilities.verification_tool;

import java.util.UUID;

public class CodeGenerator {

	public static String UuIdCodeGenerator() {
		return UUID.randomUUID().toString();
	}
	
}

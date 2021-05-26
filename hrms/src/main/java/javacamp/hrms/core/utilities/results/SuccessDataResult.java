package javacamp.hrms.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T> {
	// Data + Mesaj
	public SuccessDataResult(T data, String message) {
		super(data, true, message);
		
	}
	// Sadece Data
	public SuccessDataResult(T data) {
		super(data, true);
		
	}
	// Datasiz Gonderim
	public SuccessDataResult() {
		super(null, true);
		
	}

}

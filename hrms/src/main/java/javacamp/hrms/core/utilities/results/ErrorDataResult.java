package javacamp.hrms.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {
	// Data + Mesaj
	public ErrorDataResult(T data, String message) {
		super(data, false, message);
		
	}
	// Sadece Data
	public ErrorDataResult(T data) {
		super(data, false);
		
	}
	// Datasiz Gonderim
	public ErrorDataResult() {
		super(null, false);
		
	}

}
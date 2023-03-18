package jp.co.axa.apidemo.valueobjects;

public class Library {

	static GenericResponse genericResponse = new GenericResponse();

	public static GenericResponse recordResponse(String message, Object object) {
		genericResponse.setMessage(message);
		genericResponse.setData(object);
		return genericResponse;
	}

	public static GenericResponse messageResponse(String message) {
		genericResponse.setMessage(message);
		return genericResponse;
	}

}

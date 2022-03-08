package tis.springcommunityproject.service;

public class NotFoundDataException extends RuntimeException{
	public NotFoundDataException() {
		super();
	}

	public NotFoundDataException(String message) {
		super(message);
	}

	public NotFoundDataException(String message, Throwable cause) {
		super(message, cause);
	}
}

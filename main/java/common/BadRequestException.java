package common;

public class BadRequestException extends RuntimeException{
	public BadRequestException() {
		this("잘못된 요청입니다.");
	}
	
	public BadRequestException(String message) {
		super(message);
	}
}

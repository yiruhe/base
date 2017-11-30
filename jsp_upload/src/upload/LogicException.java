package upload;

public class LogicException extends RuntimeException {

	public LogicException(String info) {
		super(info);

	}

	public LogicException() {
	}

	public LogicException(String info, Throwable exception) {
		super(info, exception);

	}

}

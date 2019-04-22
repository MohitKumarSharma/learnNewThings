package game.customException;

public class InvalidArgumentException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InvalidArgumentException(String _message) {
		super("Invalid Argument: " + _message);
	}
}

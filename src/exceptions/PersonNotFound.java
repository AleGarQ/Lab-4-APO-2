package exceptions;

public class PersonNotFound extends Exception{
	public PersonNotFound(String error) {
		super(error);
	}
}

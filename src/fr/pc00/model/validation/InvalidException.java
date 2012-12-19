package fr.pc00.model.validation;

@SuppressWarnings("serial")
public class InvalidException extends RuntimeException
{
	public InvalidException(String msg)
	{
		super(msg);
	}
}

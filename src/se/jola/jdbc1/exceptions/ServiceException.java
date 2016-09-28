package se.jola.jdbc1.exceptions;

public class ServiceException extends RuntimeException{

	private static final long serialVersionUID = -569643240477766689L;
	
	public ServiceException(String message){
		super(message);
	}
	
	public ServiceException(String message, Throwable throwable){
		super(message, throwable);
	}
	

}

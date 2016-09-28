package se.jola.jdbc1.exceptions;

public class RepositoryException extends Exception{

	private static final long serialVersionUID = 4114495125065013605L;
	
	public RepositoryException(String message){
		super(message);
	}
	
	public RepositoryException(String message, Throwable throwable){
		super(message, throwable);
	}

}

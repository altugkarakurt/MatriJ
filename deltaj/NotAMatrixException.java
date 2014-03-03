package deltaj;
/*
 * by Altuğ Karakurt in February 2014
 * 
 * This exception is used by the MatriJ constructor and transformer
 * to verify if the input 2D matrix is rectangular and suitable for being 
 * treated as a matrix 
 * 
 */


public class NotAMatrixException extends Exception{
	public NotAMatrixException(String message){
		super(message);
	}
}
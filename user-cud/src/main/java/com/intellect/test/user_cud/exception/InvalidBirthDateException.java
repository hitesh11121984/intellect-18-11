/**
 * 
 */
package com.intellect.test.user_cud.exception;

/**
 * @author admin
 *
 */
public class InvalidBirthDateException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidBirthDateException(String message){
		super(message);
	}
}

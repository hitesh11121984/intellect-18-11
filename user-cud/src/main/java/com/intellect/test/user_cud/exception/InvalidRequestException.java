package com.intellect.test.user_cud.exception;

public class InvalidRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String fieldName;
	private final String errorCode;

	public InvalidRequestException( String errorCode, String fieldName, String message) {
		super(message);
		this.fieldName = fieldName;
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}
}

/**
 * 
 */
package com.intellect.test.user_cud.request;

import com.intellect.test.user_cud.constants.ErrorCodes;
import com.intellect.test.user_cud.exception.InvalidRequestException;
import com.intellect.test.user_cud.util.GenericUtil;

/**
 * @author admin
 *
 */

public class UserBean {
	private String id;
	private String fName;
	private String lName;
	private String email;
	private Long pinCode;
	private String birthDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getfName() {
		if(GenericUtil.checkNullOrEmptyString(fName)){
			throw new InvalidRequestException(ErrorCodes.FNAME_INVALID_CODE,"fName", "fName Empty or null");
		}else
			return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		if(GenericUtil.checkNullOrEmptyString(email)){
			throw new InvalidRequestException(ErrorCodes.EMAIL_INVALID_CODE,"email", "email Empty or null");
		}else
			return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPincode() {
		return pinCode;
	}

	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

}

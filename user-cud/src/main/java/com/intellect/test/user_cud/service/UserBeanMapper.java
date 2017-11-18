/**
 * 
 */
package com.intellect.test.user_cud.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.intellect.test.user_cud.constants.ErrorCodes;
import com.intellect.test.user_cud.entity.User;
import com.intellect.test.user_cud.request.UserBean;
import com.intellect.test.user_cud.response.ErrorBeanResponse;
import com.intellect.test.user_cud.response.UserBeanResponse;
import com.intellect.test.user_cud.util.DateConverter;

/**
 * @author admin
 *
 */
public class UserBeanMapper {

	public static User MapBeanToEntity(UserBean userBean) throws ParseException{
		User user = new User();
		user.setfName(userBean.getfName());
		user.setlName(userBean.getlName());
		user.setPinCode(userBean.getPincode());
		user.setEmail(userBean.getEmail());
		user.setActive(true);
		user.setBirthDate(DateConverter.ConvertRequestDateToTimeStamp(userBean.getBirthDate()));
		return user;
	}

	public static UserBeanResponse MapEntityToResponse(User user) {
		UserBeanResponse res = new UserBeanResponse();
		res.setResMsg("Success");
		res.setUserId(String.valueOf(user.getId()));
		return res;
	}

	public static UserBeanResponse MapUserAlreadyExistsResponse(User user) {
		UserBeanResponse res = new UserBeanResponse();
		res.setResMsg("Failure");
		ErrorBeanResponse error =new ErrorBeanResponse();
		error.setCode(ErrorCodes.EMAIL_INVALID_CODE);
		error.setMessage("Email Already Exists");
		List<ErrorBeanResponse> valErrors = new ArrayList<ErrorBeanResponse>();
		valErrors.add(error);
		res.setValErrors(valErrors);
		return res;
	}

	public static UserBeanResponse MapInvalidDOBesponse(String errorCode,String errorMessage) {
		UserBeanResponse res = new UserBeanResponse();
		res.setResMsg("Failure");
		ErrorBeanResponse error =new ErrorBeanResponse();
		error.setCode(errorCode);
		error.setMessage(errorMessage);
		error.setField("birthDate");
		List<ErrorBeanResponse> valErrors = new ArrayList<ErrorBeanResponse>();
		valErrors.add(error);
		res.setValErrors(valErrors);
		return res;
	}

	public static UserBeanResponse MapInvalidRequestResponse(String errorCode, String fieldName, String message) {
		UserBeanResponse res = new UserBeanResponse();
		res.setResMsg("Failure");
		ErrorBeanResponse error =new ErrorBeanResponse();
		error.setCode(errorCode);
		error.setMessage(message);
		error.setField(fieldName);
		List<ErrorBeanResponse> valErrors = new ArrayList<ErrorBeanResponse>();
		valErrors.add(error);
		res.setValErrors(valErrors);
		return res;
	}
}

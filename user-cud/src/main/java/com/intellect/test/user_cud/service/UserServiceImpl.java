/**
 * 
 */
package com.intellect.test.user_cud.service;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intellect.test.user_cud.constants.ErrorCodes;
import com.intellect.test.user_cud.entity.User;
import com.intellect.test.user_cud.exception.InvalidBirthDateException;
import com.intellect.test.user_cud.exception.InvalidRequestException;
import com.intellect.test.user_cud.repository.UserRepository;
import com.intellect.test.user_cud.request.UserBean;
import com.intellect.test.user_cud.response.UserBeanResponse;
import com.intellect.test.user_cud.util.DateConverter;

/**
 * @author admin
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	/* (non-Javadoc)
	 * @see com.intellect.test.user_cud.service.UserService#addUser(com.intellect.test.user_cud.request.UserBean)
	 */
	@Override
	public UserBeanResponse addUser(UserBean userBean) {
		try {
			User user = userRepo.findByEmail(userBean.getEmail());
			if(user == null){
				user = UserBeanMapper.MapBeanToEntity(userBean);
				userRepo.save(user);
				return UserBeanMapper.MapEntityToResponse(user);
			}else{
				return UserBeanMapper.MapUserAlreadyExistsResponse(user);
			}
		
		} catch(InvalidRequestException invalidRequest){
			return UserBeanMapper.MapInvalidRequestResponse(invalidRequest.getErrorCode(),invalidRequest.getFieldName(), invalidRequest.getMessage());
		}catch (ParseException e) {
			return UserBeanMapper.MapInvalidDOBesponse(ErrorCodes.DOB_INVALID_CODE,"Date Format is wrong");
		}catch(InvalidBirthDateException invalidDOB){
			return UserBeanMapper.MapInvalidDOBesponse(ErrorCodes.DOB_GREATER_CODE,invalidDOB.getMessage());
		}
		
	}
	
	@Override
	public UserBeanResponse updateUser(String id, UserBean userBean) {
		try {
			User user = userRepo.findOne(Long.parseLong(id));
			user.setPinCode(userBean.getPincode());
			user.setBirthDate(DateConverter.ConvertRequestDateToTimeStamp(userBean.getBirthDate()));
			userRepo.save(user);
			return UserBeanMapper.MapEntityToResponse(user);
		} catch (ParseException e) {
			return UserBeanMapper.MapInvalidDOBesponse(ErrorCodes.DOB_INVALID_CODE,"Date Format is wrong");
		}
	}
	@Override
	public UserBeanResponse deleteUser(String id) {
		User user = userRepo.findOne(Long.parseLong(id));
		user.setActive(false);
		userRepo.save(user);
		return UserBeanMapper.MapEntityToResponse(user);
	}

}

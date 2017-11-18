package com.intellect.test.user_cud;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.intellect.test.user_cud.constants.ErrorCodes;
import com.intellect.test.user_cud.request.UserBean;
import com.intellect.test.user_cud.response.UserBeanResponse;
import com.intellect.test.user_cud.service.UserService;

/**
 * Unit test for simple App.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AppTest 
{
	private static String REQUEST_DATE_FORMAT= "dd-MMM-yyyy";
	@Autowired
	private UserService userService;
	@Test
	public void testDOBEmpty(){
		UserBean userBean = new UserBean();
		userBean.setfName("abc");
		userBean.setEmail("abc@abc.com");
		userBean.setBirthDate("");
		UserBeanResponse res = userService.addUser(userBean);

		Assert.assertEquals("Date of Birth Empty",res.getValErrors().get(0).getCode(), ErrorCodes.DOB_INVALID_CODE);
		  
	}
	@Test
	public void testDOBInvalid(){
		UserBean userBean = new UserBean();
		userBean.setfName("abc");
		userBean.setEmail("abc@abc.com");
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(REQUEST_DATE_FORMAT);
		cal.set(Calendar.DATE, cal.get(Calendar.DATE)+1);
		userBean.setBirthDate(sdf.format(cal.getTime()));
		UserBeanResponse res = userService.addUser(userBean);
		Assert.assertEquals("Date of Birth Greater",res.getValErrors().get(0).getCode(), ErrorCodes.DOB_GREATER_CODE);
		  
	}
	
	@Test
	public void testInvalidRequestEmptyfName(){
		UserBean userBean = new UserBean();
		userBean.setEmail("abc@abc.com");
		userBean.setfName("");
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(REQUEST_DATE_FORMAT);
		cal.set(Calendar.DATE, cal.get(Calendar.DATE)+1);
		userBean.setBirthDate(sdf.format(cal.getTime()));
		UserBeanResponse res = userService.addUser(userBean);
		Assert.assertEquals("Date of Birth Greater",res.getValErrors().get(0).getCode(), ErrorCodes.FNAME_INVALID_CODE);
		  
	}
	@Test
	public void testInvalidRequestNullfName(){
		UserBean userBean = new UserBean();
		userBean.setEmail("abc@abc.com");
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(REQUEST_DATE_FORMAT);
		cal.set(Calendar.DATE, cal.get(Calendar.DATE)+1);
		userBean.setBirthDate(sdf.format(cal.getTime()));
		UserBeanResponse res = userService.addUser(userBean);
		Assert.assertEquals("Date of Birth Greater",res.getValErrors().get(0).getCode(), ErrorCodes.FNAME_INVALID_CODE);
		  
	}
}

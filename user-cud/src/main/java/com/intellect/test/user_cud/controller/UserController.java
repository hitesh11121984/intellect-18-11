/**
 * 
 */
package com.intellect.test.user_cud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.intellect.test.user_cud.request.UserBean;
import com.intellect.test.user_cud.response.UserBeanResponse;
import com.intellect.test.user_cud.service.UserService;

/**
 * @author admin
 *
 */
@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value ="/", method=RequestMethod.PUT)
	public @ResponseBody UserBeanResponse addUser(@RequestBody UserBean user){
		return userService.addUser(user);
	}
	
	@RequestMapping(value ="/{id}", method=RequestMethod.POST)
	public @ResponseBody UserBeanResponse updateUser(@PathVariable String id, @RequestBody UserBean user){
		return userService.updateUser(id,user);
	}
	@RequestMapping(value ="/{id}", method=RequestMethod.DELETE)
	public @ResponseBody UserBeanResponse deleteUser(@PathVariable String id){
		return userService.deleteUser(id);
	}
}

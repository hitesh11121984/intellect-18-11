/**
 * 
 */
package com.intellect.test.user_cud.service;

import com.intellect.test.user_cud.request.UserBean;
import com.intellect.test.user_cud.response.UserBeanResponse;

/**
 * @author admin
 *
 */
public interface UserService {

	public UserBeanResponse addUser(UserBean user);

	public UserBeanResponse updateUser(String id, UserBean user);

	public UserBeanResponse deleteUser(String id);
}

/**
 * 
 */
package com.intellect.test.user_cud.util;

/**
 * @author admin
 *
 */
public class GenericUtil {

	public static boolean checkNullOrEmptyString(String str){
		if(str== null || str.equals(""))
			return true;
		else return false;
	}
}

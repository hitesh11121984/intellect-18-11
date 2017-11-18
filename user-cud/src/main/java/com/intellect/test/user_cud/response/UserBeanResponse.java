/**
 * 
 */
package com.intellect.test.user_cud.response;

import java.util.List;

/**
 * @author admin
 *
 */
public class UserBeanResponse {
	private String resMsg;
	private String userId;
	private List<ErrorBeanResponse> valErrors;
	/**
	 * @return the resMsg
	 */
	public String getResMsg() {
		return resMsg;
	}
	/**
	 * @param resMsg the resMsg to set
	 */
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the valErrors
	 */
	public List<ErrorBeanResponse> getValErrors() {
		return valErrors;
	}
	/**
	 * @param valErrors the valErrors to set
	 */
	public void setValErrors(List<ErrorBeanResponse> valErrors) {
		this.valErrors = valErrors;
	} 
}

/**
 * 
 */
package com.pavan.rest.model;

/**
 * @author pammanchi
 *
 */
public class User {
	private String username;
	private String emailId;
	private String mobileNo;
	
	public User(String username, String emailId, String mobileNo){
		this.username = username;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
}

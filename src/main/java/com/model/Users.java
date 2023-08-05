package com.model;

import jakarta.persistence.Id;

public class Users {
	@Id
	private int userd_id;

	private String user_name;
	private String user_password;
	private String user_mail;
	private long user_phone;

	public Users() {
	}

	public Users(int userd_id, String user_name, String user_password, String user_mail, long user_phone) {
		super();
		this.userd_id = userd_id;
		this.user_name = user_name;
		this.user_password = user_password;
		this.user_mail = user_mail;
		this.user_phone = user_phone;
	}

	public int getUserd_id() {
		return userd_id;
	}

	public void setUserd_id(int userd_id) {
		this.userd_id = userd_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_mail() {
		return user_mail;
	}

	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}

	public long getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(long user_phone) {
		this.user_phone = user_phone;
	}

}

package com.qinjiangbo;

public enum Accounts {
	
	QQ("1105351275@qq.com", "****", "smtp.qq.com", "465"),
	NetEase("13667241394@163.com", "****", "smtp.163.com", "465"),
	Hotmail("qinjiangbo1994@outlook.com", "****", "smtp-mail.outlook.com", "587"),
	iCloud("qinjiangbo1994@icloud.com", "****", "smtp.mail.me.com", "587");
	
	private String username;
	private String password;
	private String hostname;
	private String port;
	
	private Accounts(String username, String password, String hostname, String port) {
		this.username = username;
		this.password = password;
		this.hostname = hostname;
		this.port = port;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	
}

package com.jdbctest.database;

public class Setup {

	private String un;
	private String pw;
	private String url;
	

	public Setup(String un, String pw, String url) {
		this.pw = pw;
		this.un = un;
		this.url = url;
	}


	public String getUn() {
		return un;
	}


	public void setUn(String un) {
		this.un = un;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}

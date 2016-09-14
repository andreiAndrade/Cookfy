package br.com.cookfy.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginDTO {
	private String user, hash, adapter;

	public String getAdapter() {
		return adapter;
	}

	public void setAdapter(String adapter) {
		this.adapter = adapter;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}
	
}

package br.com.cookfy.controller;

import java.util.UUID;

public abstract class UserController {
	
	public String createToken() {
		return UUID.randomUUID().toString();
	}
}

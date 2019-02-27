package com.mse.demo.security;

public enum Roles {

	ADMIN("ADMIN"), USER("USER");

	private final String name;

	private Roles(String s) {
		name = s;
	}

	public String toString() {
		return this.name;
	}
}

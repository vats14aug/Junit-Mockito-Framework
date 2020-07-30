package com.example.service;

public class PartialMocking {
	public static String staticMethod() {
		return "Power Mockito Spy Prototype!";
	}

	public final String finalMethod() {
		return "Power Mockito Spy Prototype!";
	}

	private String privateMethod() {
		return "Power Mockito Spy Prototype!";
	}

	public String privateMethodCaller() {
		return privateMethod() + " Welcome to the Java world.";
	}

	public final String testMethod() {
        return "Hello Test World!";
    }
}

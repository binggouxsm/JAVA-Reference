package com.eden.javalearning.proxy.staticproxy;

import com.eden.javalearning.proxy.Subject;

public class LogProxy implements Subject {
	private Subject target;

	public LogProxy(Subject target) {
		this.target = target;
	}
	
	public void request() {
		// Doing something before request 
		System.out.println("Doing something before request");
		target.request();
		// Doing something after request
		System.out.println("Doing something after request");
	}
}

package com.eden.javalearning.proxy.staticproxy;

import com.eden.javalearning.proxy.Subject;

public class TimeProxy implements Subject {
	private Subject target;

	public TimeProxy(Subject target) {
		this.target = target;
	}
	
	public void request() {
		long start = System.currentTimeMillis();
		target.request();
		long end = System.currentTimeMillis();
		System.out.println("Request finish in " + (end -start));
	}
}

package com.eden.javalearning.proxy.staticproxy;

import com.eden.javalearning.proxy.RealSubject;
import com.eden.javalearning.proxy.Subject;

public class Main {
	public static void main(String[] args) {
		Subject proxy = new TimeProxy(new LogProxy(new RealSubject()));
		proxy.request();
	}
}

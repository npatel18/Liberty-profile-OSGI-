package com.itso.example.osgi.client;

import com.itso.example.osgi.api.HelloAPI;

public class HelloITSOClient {

	private HelloAPI helloService=null;

	public HelloAPI getHelloService() {
		return helloService;
	}

	public void setHelloService(HelloAPI helloService) {
		this.helloService = helloService;
	}
	
	public void init() {
		System.out.println("Client is starting");
		helloService.sayHello();
		System.out.println("Client closing");
	}
	

}

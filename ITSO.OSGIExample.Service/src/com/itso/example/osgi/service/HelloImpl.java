package com.itso.example.osgi.service;

import com.itso.example.osgi.api.HelloAPI;

public class HelloImpl implements HelloAPI {

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		
		System.out.println("Hello Liberty developer for osgi");
		
	}

}

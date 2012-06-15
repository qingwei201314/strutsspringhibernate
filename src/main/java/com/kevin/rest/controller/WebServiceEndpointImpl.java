package com.kevin.rest.controller;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.stereotype.Service;

@Service
@WebService
public class WebServiceEndpointImpl implements WebServiceEndpoint{

	@WebMethod
	public void insertAccount() {
		System.out.println("Kevin WebService.");
	}
}

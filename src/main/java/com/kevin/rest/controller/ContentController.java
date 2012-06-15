package com.kevin.rest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

public abstract class ContentController implements org.springframework.web.servlet.mvc.Controller{
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
    	return null;
    }
}

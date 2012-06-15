package com.kevin.bread.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Service;

import com.kevin.util.CommonAction;

@Service
@Namespace("/resultAction")
public class ResultAction extends CommonAction{
	private static final long serialVersionUID = 1L;
	
	private String name;

	@Action(value = "test", results={@Result(name="input", location= path + "/resultAction/input.jsp")})
	public String test() {
		String result = SUCCESS;
		return result;
	}
	
	@Action(value = "index")
	public String index() {
		String result = SUCCESS;
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

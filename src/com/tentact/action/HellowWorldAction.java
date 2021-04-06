package com.tentact.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class HellowWorldAction {
	public String execute(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));
		request.setAttribute("username", username);
		request.setAttribute("age", age);
		System.out.println("hellowWorldAction");
		return "success";
	}

}

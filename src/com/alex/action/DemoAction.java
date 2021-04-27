package com.alex.action;

import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public class DemoAction {
    private ServletRequest request;

    public ServletRequest getRequest() {
        return request;
    }
    public void setRequest(ServletRequest request) {
        this.request = request;
    }
    public String create(){
        this.setRequest(ServletActionContext.getRequest());
        this.getRequest().setAttribute("error", "add successfully!");
        return "success";
    }
    public String delete(){
        this.setRequest(ServletActionContext.getRequest());
        this.getRequest().setAttribute("error", "delete successfully!");
        return "success";
    }
    public String update(){
        this.setRequest(ServletActionContext.getRequest());
        this.getRequest().setAttribute("error", "update successfully!");
        return "success";
    }
    public String retrieve(){
        this.setRequest(ServletActionContext.getRequest());
        this.getRequest().setAttribute("error", "find successfully!");
        return "success";
    }
}

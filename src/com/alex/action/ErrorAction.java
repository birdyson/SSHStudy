package com.alex.action;

import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class ErrorAction {
    public String login(){
        HttpServletRequest request = ServletActionContext.getRequest();
        System.out.println("【"+Thread.currentThread().getName()+"】用户未登录");
        request.setAttribute("error", "用户未登录。");
        return "login";
    }
    public String loginForward(){
        return "redirect_login";
    }
    public String time(){
        HttpServletRequest request = ServletActionContext.getRequest();
        System.out.println("【"+Thread.currentThread().getName()+"】未在开放时间段。");
        request.setAttribute("error", "未在开放时间段。");
        return "time";
    }
}

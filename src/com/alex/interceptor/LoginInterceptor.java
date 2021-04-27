package com.alex.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 拦截器：
 * 在执行Action方法之前，拦截Action的方法（AOP思想：前置通知）
 * 过滤器与拦截器的区别：
 * 过滤器可以过滤任意资源，拦截器只能拦截Action，
 */
public class LoginInterceptor extends MethodFilterInterceptor {
    @Override
    // 拦截方法
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        System.err.println("拦截器生效");
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null || "".equals(username)){
            System.err.println("拦截器报告：用户未登录。");
            return "login";
        }
        /**
         * 作业：只有在半夜两点到5点才可以登录
         */
        // 访问下一个资源
        return actionInvocation.invoke();
    }
}

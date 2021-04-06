package com.alex.action;

import com.alex.service.UserService;
import com.alex.vo.User;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class UserAction {
    /**
     * 本方法名称为固定的execute
     * @return 返回值为String类型，此类型是为result的name提供的
     */
    public String execute(){
        UserService userService = new UserService();
        return userService.verify(this.packageUser());
    }
    public User packageUser(){
        // ServletActionContext为Struts带的属性
        HttpServletRequest request = ServletActionContext.getRequest();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        return User.builder().username(username).password(password).build();
    }
    public String register(){
        HttpServletRequest request = ServletActionContext.getRequest();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService userService = new UserService();
        return userService.register(username, password);
    }
}

package com.alex.action;

import com.alex.service.UserService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class InfoAction {
    public String delete(){
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String password = request.getParameter("password");
        UserService userService = new UserService();
        boolean result = userService.deleteByUsername(username);
        if (result){
            session.removeAttribute("username");
            request.setAttribute("msg", "注销成功！期待与你再次相遇");
            return "success";
        }
        return "fail";
    }
    public String update(){
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        String password = request.getParameter("password");
        System.out.println("得到的username:"+username+",password:"+password);
        UserService userService = new UserService();
        boolean result = userService.updatePasswordByUsername(username, password);
        if (result){
            return "success";
        }
        return "fail";
    }
}

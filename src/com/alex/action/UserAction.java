package com.alex.action;

import com.alex.dao.UserDao;
import com.alex.service.UserService;
import com.alex.vo.User;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class UserAction {
    private User userUpdate;

    public User getUserUpdate() {
        return userUpdate;
    }

    public void setUserUpdate(User userUpdate) {
        this.userUpdate = userUpdate;
    }

    public String login(){
        HttpServletRequest request = ServletActionContext.getRequest();
        UserService userService = new UserService();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int verifyed = userService.verify(username, password);
        switch (verifyed){
            case 0:
                System.out.println("login access");
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                return "success";
            case -1:
                System.out.println("password failed");
                request.setAttribute("msg", "密码错误");
                return "fail";
            default:
                System.out.println("no username");
                request.setAttribute("msg", "用户名不存在");
                return "fail";
        }
    }
    public String register(){
        HttpServletRequest request = ServletActionContext.getRequest();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService userService = new UserService();
        int result = userService.register(username, password);
        switch(result){
            case 0:
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                return "success";
            case -1:
                request.setAttribute("msg", "用户名已存在！");
                return "fail";
            default:
                request.setAttribute("msg", "请输入完整用户名或密码！");
                return "fail";
        }
    }
    public String findAll(){
        HttpServletRequest request = ServletActionContext.getRequest();
        UserService userService = new UserService();
        List<User> allUser = userService.getAllUser();
        request.setAttribute("userlist", allUser);
        return "success";
    }
    public String delete(){
        HttpServletRequest request = ServletActionContext.getRequest();
        String username = request.getParameter("delUsername");
        UserService userService = new UserService();
        boolean result = userService.deleteByUsername(username);
        if (result){
            return "success";
        }
        return "fail";
    }
    public String update(){
        HttpServletRequest request = ServletActionContext.getRequest();
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserService userService = new UserService();
        boolean b = userService.updateInfoById(id, username, password);
        if (b){
            return "success";
        }
        return "fail";
    }
    public String updateForward(){
        System.out.println("Update: " +
                "\n\t|-id: "+userUpdate.getId()+
                "\n\t|-username: "+userUpdate.getUsername()+
                "\n\t|-password: "+userUpdate.getPassword());
        return "success";
    }
    public String find(){
        HttpServletRequest request = ServletActionContext.getRequest();
        String findUsername = request.getParameter("findUsername");
        UserDao userDao = new UserDao();
        List<User> result = new ArrayList<>();
        User user = userDao.selectUserByUsername(findUsername);
        if (user != null){
            result.add(user);
            request.setAttribute("userlist", result);
        }else{
            result = userDao.getUserList();
            request.setAttribute("userlist", result);
            request.setAttribute("error", "没有找到用户："+findUsername+"，已为您显示所有用户。");
        }
        return "success";
    }
    /**
     * 本方法名称为固定的execute
     * @return 返回值为String类型，此类型是为result的name提供的
     */
//    public String execute(){
//        UserService userService = new UserService();
//        return userService.verifyed(this.packageUser());
//    }
//    public User packageUser(){
//        // ServletActionContext为Struts带的属性
//        HttpServletRequest request = ServletActionContext.getRequest();
//        UserService userService = new UserService();
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        return User.builder().username(username).password(password).build();
//    }
}

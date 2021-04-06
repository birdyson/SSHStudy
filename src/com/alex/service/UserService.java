package com.alex.service;

import com.alex.dao.UserDao;
import com.alex.vo.User;

import java.util.List;

public class UserService {
    public String verify(User user){
        boolean verify = UserDao.verify(user);
        if(verify){
            return "success";
        }
        return "fail";
    }
    public String verifyed(String username, String password){
        UserDao userDao = new UserDao();
        User user = userDao.selectUserByUsernameAndPassword(username, password);
        if(user!=null){
            return "success";
        }
        return "fail";
    }
    public String register(String username, String password){
        System.out.println("此处从表单传来的username:"+username+",password:"+password);
        if (username != null && password != null){
            UserDao userDao = new UserDao();
            Integer id = userDao.getBiggestId() + 1;
            if (userDao.register(id, username, password)){
                System.out.println("注册成功！");
                return "success";
            }
            System.out.println("用户名已注册！");
            return "alreadyRegistered";
        }
        System.out.println("用户名或密码没有输入！！");
        return "haveNull";
    }
    public List<User> getAllUser(){
        UserDao userDao = new UserDao();
        return userDao.getUserList();
    }
}

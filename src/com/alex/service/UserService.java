package com.alex.service;

import com.alex.dao.UserDao;
import com.alex.vo.User;

import java.util.List;

public class UserService {
    /**
     *
     * @param username 前端传过来的username
     * @param password 前端传过来的password
     * @return 0：用户名与密码正确 -1：密码错误 -2：用户名不存在
     */
    public int verify(String username, String password){
        UserDao userDao = new UserDao();
        User user = userDao.selectUserByUsername(username);
        if (user!=null){
            System.out.println("username:"+username+","+password);
            if (user.getPassword().equals(password)){
                return 0;
            }
            return -1;
        }
        return -2;
    }

    /**
     * 根据传来的username和password进行注册操作
     * @param username username
     * @param password password
     * @return 0：注册成功； -1：用户名已存在；-2：传入的数据存在空值；
     */
    public int register(String username, String password){
        System.out.println("此时注册的信息为：username:"+username+",password:"+password);
        if ( !"".equals(username) && !"".equals(password)){
            UserDao userDao = new UserDao();
            Integer biggestId = userDao.getBiggestId() + 1;
            if(userDao.selectUserByUsername(username) == null){
                userDao.addUserByIdUsernamePassword(biggestId, username, password);
                System.out.println("注册成功！");
                return 0;
            }
            System.out.println("用户名已存在！");
            return -1;
        }
        System.out.println("传入的数据存在空值！");
        return -2;
    }
    /**
     * 获得所有的用户信息列表
     * @return 返回用户信息列表
     */
    public List<User> getAllUser(){
        UserDao userDao = new UserDao();
        return userDao.getUserList();
    }
    public boolean deleteByUsername(String username){
        UserDao userDao = new UserDao();
        return userDao.deleteUserByUsername(username);
    }
    public boolean updatePasswordByUsername(String username, String password){
        UserDao userDao = new UserDao();
        return userDao.updatePasswordByName(username, password);
    }
    public boolean updateInfoById(Integer id, String username, String password){
        System.out.println("service得到的信息：id"+id+",username:"+username+",password:"+password);
        UserDao userDao = new UserDao();
        User user = userDao.selectUserByUsername(username);
        if (user == null || (user.getUsername().equals(username) && user.getId().equals(id))){
            return userDao.updateInfoById(id, username, password);
        }
        return false;
    }
    @Deprecated
    public String registered(String username, String password){
        System.out.println("此处从表单传来的username:"+username+",password:"+password);
        if (!"".equals(username) && !"".equals(password)){
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
    @Deprecated
    public String verifyed(User user){
        boolean verify = UserDao.verify(user);
        if(verify){
            return "success";
        }
        return "fail";
    }
}

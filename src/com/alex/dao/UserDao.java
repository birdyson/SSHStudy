package com.alex.dao;

import com.alex.vo.User;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static List<User> userList = new ArrayList<>();
    static {
        User user1 = User.builder().id(1).username("Alexander").password("12138").build();
        User user2 = User.builder().id(4).username("Bill").password("12345").build();
        User user3 = User.builder().id(5).username("Candy").password("123").build();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
    }
    public User selectUserByUsernameAndPassword(String username, String password){
        for (User u : UserDao.userList){
            if(u.getUsername().equals(username)){
                if (u.getUsername().equals(password)){
                    return u;
                }
            }
        }
        return null;
    }
    public User selectUserByUsername(String username){
        for (User u : UserDao.userList){
            if (u.getUsername().equals(username)){
                return u;
            }
        }
        return null;
    }
    // 注册：重名不能注册；id自动生成；
    public Integer getBiggestId(){
        Integer BID = 0;
        for (User u :
                UserDao.userList) {
            if(u.getId()>BID){
                BID = u.getId();
            }
        }
        return BID;
    }
    public boolean register(@NonNull Integer id,@NonNull String username,@NonNull String password){
        User user = selectUserByUsername(username);
        if (user == null){
            return UserDao.userList.add(User.builder().id(id).username(username).password(password).build());
        }
        return false;
    }
    public List<User> getUserList(){
        return userList;
    }
    public static boolean verify(User user){
        for (User u : UserDao.userList) {
            if(u.getUsername().equals(user.getUsername())){
                return u.getPassword().equals(user.getPassword());
            }
        }
        return false;
    }

}

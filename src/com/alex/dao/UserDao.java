package com.alex.dao;

import com.alex.vo.User;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    // 用户的信息存储
    private static List<User> userList = new ArrayList<>();

    // 静态代码块：根据类一起加载用户的信息
    static {
        User user1 = User.builder().id(1).username("Alexander").password("12138").build();
        User user2 = User.builder().id(4).username("Bill").password("12345").build();
        User user3 = User.builder().id(5).username("Candy").password("123").build();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
    }

    /**
     * 根据用户名和密码找到对应的用户信息
     * @param username 用户名
     * @param password 密码
     * @return 返回对应的用户信息
     */
    public User selectUserByUsernameAndPassword(String username, String password) {
        for (User u : UserDao.userList) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    /**
     * 根据用户名查找数据中是否存在
     * @param username 查找的用户名
     * @return 返回找到的用户名对应的用户信息
     */
    public User selectUserByUsername(String username) {
        for (User u : UserDao.userList) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }
    public User selectUserById(Integer id){
        for (User u : UserDao.userList){
            System.out.println("传入的id是："+id+", 正在比较："+u.getId());
            if (u.getId().equals(id)){
                System.out.println("比对到了ID");
                return u;
            }
        }
        System.err.println("没有比对到的ID");
        return null;
    }
    // 注册：重名不能注册；id自动生成；
    public Integer getBiggestId() {
        Integer BID = 0;
        for (User u :
                UserDao.userList) {
            if (u.getId() > BID) {
                BID = u.getId();
            }
        }
        return BID;
    }

    /**
     * 非BaseDao，建议使用addUserByIdUsernamePassword()
     * 注册操作，通过传入的信息进行注册操作，包含数组的添加操作，可进行分解
     * @param id 传入的id
     * @param username 用户名
     * @param password 密码
     * @return 返回注册是否成功
     */
    @Deprecated
    public boolean register(@NonNull Integer id, @NonNull String username, @NonNull String password) {
        User user = selectUserByUsername(username);
        if (user == null) {
            return UserDao.userList.add(User.builder().id(id).username(username).password(password).build());
        }
        return false;
    }

    /**
     * 根据传入的信息进行用户注册操作
     * @param id id
     * @param username username
     * @param password password
     * @return 注册操作是否成功
     */
    public boolean addUserByIdUsernamePassword(@NonNull Integer id, @NonNull String username, @NonNull String password){
        return UserDao.userList.add(User.builder().id(id).username(username).password(password).build());
    }

    /**
     * 返回所有的用户列表
     * @return 用户列表
     */
    public List<User> getUserList() {
        return userList;
    }

    /**
     * 通过传入的username与List进行匹配，如果遇到相同的username，则进行删除操作
     * @param username 需要删除的username
     * @return 删除操作是否成功
     */
    public boolean deleteUserByUsername(String username) {
//        for (User u :
//                userList) {
//            if (u.getUsername().equals(username)){
//                UserDao.userList.remove(u);
//            }
//        }
        return UserDao.userList.removeIf(u -> u.getUsername().equals(username));
    }

    /**
     * 通过传入的username与List进行匹配，如果遇到相同的username，则进行修改密码操作
     * @param username 需要修改的用户名
     * @param password 修改后的密码
     * @return 返回修改的结果
     */
    public boolean updatePasswordByName(String username, String password){
        for (int i = 0; i < UserDao.userList.size(); i++){
            User temp = UserDao.userList.get(i);
            if (temp.getUsername().equals(username)){
                temp.setPassword(password);
                UserDao.userList.set(i, temp);
                return true;
            }
        }
        return false;
    }
    public boolean updateInfoById(Integer id, String username, String password){
        for (int i = 0; i < UserDao.userList.size(); i++){
            User temp = UserDao.userList.get(i);
            if (temp.getId().equals(id)){
                temp.setPassword(password);
                temp.setUsername(username);
                UserDao.userList.set(i, temp);
                return true;
            }
        }
        return false;
    }
    /**
     * 非BaseDao，建议使用selectUserByUsernameAndPassword()
     * @param user 需要验证的封装好的User类型
     * @return 返回用户名与密码是否匹配
     */
    @Deprecated
    public static boolean verify(User user) {
        for (User u : UserDao.userList) {
            if (u.getUsername().equals(user.getUsername())) {
                return u.getPassword().equals(user.getPassword());
            }
        }
        return false;
    }
}

package org.user.service;

import org.user.check.Usercheck;
import org.user.entity.User;

public class LoginService {
    public boolean checkUser(String userName, String password) {
        Usercheck dao = new Usercheck();
        User user = dao.findUserByName(userName);
        System.out.println(user);
        return user != null && password.equals(user.getUserPass()) ? true : false;
    }

}
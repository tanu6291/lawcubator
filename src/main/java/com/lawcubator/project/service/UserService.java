package com.lawcubator.project.service;


import com.lawcubator.project.model.User;
import com.lawcubator.project.repo.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(User user) throws Exception {

        if(userDao.existsById(user.getUserName())) {
            throw new Exception("This user name user already exist");
        }
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userDao.save(user);
    }

    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }
}

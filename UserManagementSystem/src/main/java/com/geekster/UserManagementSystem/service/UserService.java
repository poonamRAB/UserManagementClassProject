package com.geekster.UserManagementSystem.service;

import com.geekster.UserManagementSystem.model.User;
import com.geekster.UserManagementSystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public List<User> getAllUsers(){
        return userRepo.getUsers();
    }

    public String createUsers(List<User> users){
        List<User> originalList = getAllUsers();
        originalList.addAll(users);
        return "New users are added!!!";
    }

    public String createUser(User user){
        List<User> originalList = getAllUsers();
        originalList.add(user);
        return "New user is added!!!";
    }

    public String removeUser(Integer userId) {
        List<User> originalList = getAllUsers();

        for(User U : originalList ){
            if (userId.equals(U.getUserId())) {

                originalList.remove(U);
                return "user removed";
            }
        }
        return "user not found";


    }

    public String updateUserInfo(Integer userId,String userEmail) {
        List<User> originalList = getAllUsers();
        for(User u : originalList){
            if(userId.equals(u.getUserId())){
                u.setUserEmail(userEmail);

                return "Email Id updated";
            }
        }

        return "id not found";
        

    }
}

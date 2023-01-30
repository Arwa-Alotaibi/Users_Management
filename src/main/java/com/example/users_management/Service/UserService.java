package com.example.users_management.Service;

import com.example.users_management.Repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.users_management.Model.User;
@Service
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public List GetUser(){
        return userRepository.findAll();
    }
    public void AddUser(User  user) {
        userRepository.save(user);
    }
    public boolean UpdateUser(Integer id,User user){
        User olduser = userRepository.getById(id);
        if(olduser==null){
            return false;
        }
        else {
             //User class: ID , name , username , password, email ,role, age
            olduser.setName(user.getName());
            olduser.setUsername(user.getUsername());
            olduser.setPassowrd(user.getPassowrd());
            olduser.setEmail(user.getEmail());
            olduser.setRole(user.getRole());
            olduser.setAge(user.getAge());
            userRepository.save(olduser);
            return true;
        }
    }
    public boolean DeleteUser(Integer id){
       User deleteuser =userRepository.getById(id);
       if(deleteuser==null){
           return false;
       }
       userRepository.delete(deleteuser);
        return true;
    }
}

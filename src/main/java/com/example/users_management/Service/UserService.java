package com.example.users_management.Service;

import com.example.users_management.Exception.ApiException;
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
        User olduser = userRepository.findUserById(id);
        if(olduser==null){
            throw new ApiException("id not found !");
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
       User deleteuser =userRepository.findUserById(id);
       if(deleteuser==null){
           throw new ApiException("id not found !");
       }
       userRepository.delete(deleteuser);
        return true;
    }

    //Get user by email
    public User GetUserByEmail(String email){
        User user =userRepository.findUserByEmail(email);
        if(user==null){
            throw new ApiException("email not found !");
        }
        return user;
    }
    //Get All users with specific role
    public List <User>GetALLByRole(String role){
        List <User> user=userRepository.findAllByRole(role);
     if(user.isEmpty()){
         throw new ApiException("try another role");
     }
         return user;
    }
    //Get All users with specific age or above
    public List <User> GetAllbyAge(int age){
        List<User> users = userRepository.findAllByAgeGreaterThanEqual(age);
        if(users.isEmpty()){
            throw new ApiException("try another age");
        }
        return users;
    }

    public User checkuser(String email , String passowrd){
        User user = userRepository.findUserByEmailAndPassowrd( email ,  passowrd);
        if(user==null){
            throw new ApiException("wrong");
        }
        return user;
    }

}

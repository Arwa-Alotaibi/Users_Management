package com.example.users_management.Controller;

import com.example.users_management.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.users_management.Model.User;
import org.springframework.validation.Errors;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users/")
public class UserController {
   private UserService userService;
    public UserController( UserService userService){
        this.userService=userService;
    }
    @GetMapping("/get")
    public ResponseEntity GetUser(User user){
        List<User> users = userService.GetUser();
        return ResponseEntity.status(200).body(users);
    }
    @PostMapping("/add")
    public ResponseEntity AddUser(@Valid @RequestBody User user){
//        if(errors.hasErrors()){
//            String message= errors.getFieldError().getDefaultMessage();
//            return ResponseEntity.status(400).body(message);
//
//        }
        userService.AddUser(user);
       return ResponseEntity.status(200).body("user added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity UpdateUser(@PathVariable Integer id ,@Valid @RequestBody User user){
//        if(errors.hasErrors()){
//            String message= errors.getFieldError().getDefaultMessage();
//            return ResponseEntity.status(400).body(message);
//
//        }
        boolean isupdated = userService.UpdateUser(id,user);
//        if(isupdated){
            return ResponseEntity.status(200).body("update user " );
//        }
//        else {
           // return ResponseEntity.status(400).body("wrong id" );
        //}


    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id ){
        boolean isdeleted = userService.DeleteUser(id);
//        if(isdeleted){
            return ResponseEntity.status(200).body("user deleted" );
//        }
//        else {
//            return ResponseEntity.status(400).body("wrong id " );
//
//        }
    }
    @GetMapping("/getemail/{email}")
    public ResponseEntity Getbyemail(@PathVariable String email){
        User user = userService.GetUserByEmail(email);
        return ResponseEntity.status(200).body(user );
    }

    @GetMapping("/findrole/{role}")
    public ResponseEntity GetAllRole(@PathVariable String role ){
         List <User> user = userService.GetALLByRole(role);
        return ResponseEntity.status(200).body(user );
    }
    @GetMapping("/findage/{age}")
    public ResponseEntity GettAllbyAge(@PathVariable int age){
        List <User> user = userService.GetAllbyAge(age);
        return ResponseEntity.status(200).body(user );

    }

    @GetMapping("/check/{email}/{passowrd}")
    public ResponseEntity check(@PathVariable String email ,@PathVariable String passowrd){
        User user = userService.checkuser(email,passowrd);
        return ResponseEntity.status(200).body("correct" );

    }

}

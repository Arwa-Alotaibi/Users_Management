package com.example.users_management.Repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.users_management.Model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    //Get user by email
    User findUserByEmail(String email);

    User findUserById(Integer id);

    //Get All users with specific role
    List <User> findAllByRole(String role);


    //Get All users with specific age or above
    List<User> findAllByAgeGreaterThanEqual(int age);

    //Check if username and password are correct
  //  User findUserByEmailAndPassowrd(String username , String passowrd);
  @Query("SELECT u from User u WHERE u.username=?1 and u.passowrd=?2 ")
   User check(String username , String passowrd );

 // User findUserByEmailAndPassowrdExists(String email , String password);


}

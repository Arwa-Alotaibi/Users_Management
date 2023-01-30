package com.example.users_management.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //User class: ID , name , username , password, email ,role, age
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;


    @NotEmpty(message = "the name should be not null!")
    @Size(min=3 , message = "length more than 4")
 //  @Column(columnDefinition = "varchar(4) not null")
    private String name ;

    @NotEmpty(message = "the user name should be not null!")
    @Size(min = 3 , message = "length more than 4")
    //@Column(unique=true)
    // @Column(columnDefinition = "varchar(4) unique")
    private String username;

    @NotEmpty(message = "the passowrd Cannot be null" )
  //  @Column(columnDefinition = "varchar(20) not null")
    private String passowrd ;


    @NotEmpty(message = "the email should be not null")
    @Email(message = "the email should be valid email")
// @Column(columnDefinition = "varchar(20) not null  unique")
    //@Column(unique=true)
    private String email;


    @NotEmpty(message = "the role should be not empty")
    @Pattern(regexp = "user|admin")
    //@Column(columnDefinition = "varchar(20) not null check (role='user' or role='admin') " )
    private String role;

    @NotNull(message="age should  be not null")
    @Positive(message = "must be a positive age")
    //@Column(columnDefinition = "varchar(20) not null check (age>0)" )
    private int age ;

}

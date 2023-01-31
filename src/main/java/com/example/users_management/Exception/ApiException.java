package com.example.users_management.Exception;

public class ApiException extends RuntimeException {
    public ApiException(String message){
        super(message);
    }
}

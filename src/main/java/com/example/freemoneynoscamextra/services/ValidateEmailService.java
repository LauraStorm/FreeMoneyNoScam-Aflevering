package com.example.freemoneynoscamextra.services;

import java.sql.Statement;

public class ValidateEmailService {

    public boolean isEmailValid(String email){
        if (email.contains("@") && email.contains(".")){
            System.out.println("your e-mail is valid!");
            return true;
        } else {
            System.out.println("e-mail is not valid");
            return false;
        }
    }


}

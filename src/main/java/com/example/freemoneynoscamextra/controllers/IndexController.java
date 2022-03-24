package com.example.freemoneynoscamextra.controllers;

import com.example.freemoneynoscamextra.repositories.Database;
import com.example.freemoneynoscamextra.services.ValidateEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class IndexController {
    private final ValidateEmailService validateEmailService = new ValidateEmailService();
    private final Database database = new Database();


    @GetMapping("/")
    public String index (){
       database.connectToDB();
       return "index";
    }

    @PostMapping("/create-email")
    public String createEmail(WebRequest dataFromCreateEmailForm){
        //Få fat i inputtet fra brugeren (parameterern--> dataFromCreateEmailForm)
        String emailInput = dataFromCreateEmailForm.getParameter("email");
        //Så skal emailen valideres
        boolean isEmailValid = validateEmailService.isEmailValid(emailInput);

        if (isEmailValid == true){
            //hvis emailen er 'true', skal emailen i databasen
            database.insertInto(emailInput);
            //Hvis html side - hvor email er succes
            return "succesEmailCreatedPage";
        } else {
            //Hvis emailen er 'false', gå til html side failed
            return "failedEmailPage";
        }
    }



}

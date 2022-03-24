package com.example.freemoneynoscamextra.controllers;

import com.example.freemoneynoscamextra.repositories.EmailRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmailController {
    private EmailRepository emailRepository = new EmailRepository();

    @GetMapping("/singleEmailFetch")
    public String getSingleEmailFetch (Model emailToView){  //Vi bruger Model classen til at hente data fra server som skal vises
        //Kalder EmailRepository class for at bruge metoden 'fetchSingleEmail' til at finde en mail
        String email = emailRepository.fetchSingleEmail();
        //Så referere vi til Model 'emailToView' - hvor vi adder til VIEW
        emailToView.addAttribute("singleEmail",email);

        //Så returnerer vi til html siden der skal vise en email
        return "singleEmail";
    }

    @GetMapping("/allEmailFetch")
    public String getAllEmailFetch (Model emailToView){  //Vi bruger Model classen til at hente data fra server som skal vises
        //Kalder EmailRepository class for at bruge metoden 'allEmail'
        List<String> email = emailRepository.allEmails();
        //Så referere vi til Model 'emailToView' - hvor vi adder alle emailene til VIEW
        emailToView.addAttribute("allEmails",email);

        //Så returnerer vi til html siden der skal vise en email
        return "allEmails";
    }


}

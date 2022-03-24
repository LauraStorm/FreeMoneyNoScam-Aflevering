package com.example.freemoneynoscamextra.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmailRepository {
    private Database database = new Database();

    public String fetchSingleEmail() {
        String email = "";

        ResultSet rs = database.getTable();

        try {
            rs.next(); //Springer første row over (colonne navne)
            email = rs.getString("email");
            System.out.println(email);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;
    }

    public List<String> allEmails (){
        ArrayList<String> emails = new ArrayList<String>();

        ResultSet rs = database.getTable();

        try {
            while (rs.next()){
                String email = rs.getString("email");  //kolonne navnet fra tabellen
                emails.add(email);
                //System.out.println(email);    //hvis du vil se at de får fat i emailerne

            }

        } catch (SQLException e) {
                e.printStackTrace();
        }

        return emails;

    }
}

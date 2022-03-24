package com.example.freemoneynoscamextra.repositories;

import java.sql.*;

//Connect til database
public class Database {
    private Connection con = connectToDB();
    private Statement stmt;
    private ResultSet rs;
    private String sqlString;

    public Connection connectToDB(){
        try {
            //Definer referencen/path til databasens schema
            String databaseUrl = "jdbc:mysql://localhost:3306/free_money";
            //Så connecter vi. Skriv user og password
            con = DriverManager.getConnection(databaseUrl,"root","insertPASSWORDhere"); //skriv password her!
            System.out.println("YES - we have a connection to the DB 🥳");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public void insertInto(String emailInput){
        //Bruger INSERT INTO - så det får rette format til sql
        String sql = "INSERT INTO user_emails (`email`)" +
                "VALUES ('" + emailInput + "');";
        try {
            //sætter statement til at create
            stmt = con.createStatement();
            //updatere vores statement med vores sql String
            stmt.executeUpdate(sql);

            System.out.println("INSERT INTO DB - done ✔️ ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getTable (){

        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sqlString = "SELECT * FROM user_emails ";
            rs = stmt.executeQuery(sqlString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;

    }

}

package com.example.app_unit_test;

public class Model_User {
    public String Email;
    public String Password;
    public String Password_Confirm;

    public Model_User (String email, String password, String password_confirm){
        Email=email;
        Password=password;
        Password_Confirm=password_confirm;
    }
}

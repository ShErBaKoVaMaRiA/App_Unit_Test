package com.example.app_unit_test;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Units {

    public static boolean validateAccount(Context ctx,Model_User account){
        if(account.Email.equals("")||account.Password.equals("")||account.Password_Confirm.equals(""))
            Toast.makeText(ctx, "Все или некоторые поля не заполнены!", Toast.LENGTH_SHORT).show();
        else{
                if (checkEmailForValidity(account.Email)) {
                    Toast.makeText(ctx, "Проверка email пройдена!", Toast.LENGTH_SHORT).show();
                    if (checkPasswordForValidity(account.Password)) {
                        Toast.makeText(ctx, "Проверка пароля пройдена!", Toast.LENGTH_SHORT).show();
                        if (checkPasswords(account.Password, account.Password_Confirm)) {
                            Toast.makeText(ctx, "Пароли совпадают!", Toast.LENGTH_SHORT).show();
                            Toast.makeText(ctx, "Аккаунт "+ account.Email+" создан!", Toast.LENGTH_SHORT).show();
                            return true;
                        }
                        else Toast.makeText(ctx, "Пароли не совпадают!", Toast.LENGTH_SHORT).show();
                    }else Toast.makeText(ctx, "Пароль не соотвветствует требованиям!", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(ctx, "Проверка не пройдена!", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
    public static boolean Valid_Account(Model_User user){
        return checkEmailForValidity(user.Email)&&checkPasswordForValidity(user.Password)&&checkPasswords(user.Password, user.Password_Confirm);
    }
    public static boolean checkEmailForValidity(String email){
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }
    public static boolean checkPasswordForValidity(String password){
        Matcher matcher = VALID_PASSWORD_REGEX.matcher(password);
        return matcher.find();
    }
    public static boolean checkPasswords(String password, String password_confirm){
        if(password.equals(password_confirm))
        return true;
        else return false;
    }
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX=
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_PASSWORD_REGEX =
            Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[-.,_!]).{6,30})");
}

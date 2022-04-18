package com.example.app_unit_test;

import org.junit.Assert;
import java.util.regex.Matcher;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

public class ExampleUnitTest {

    @Test
    public void testIsEmailValid(){
        String email_proverka="email@yandex.ru";
        Assert.assertThat(String.format("Email невалидный %s",email_proverka),
                Units.checkEmailForValidity(email_proverka), is(true));
    }
    @Test
    public void testIsPasswordValid(){
        String pass_proverka="Password_123";
        Assert.assertThat(String.format("Пароль невалидный %s",pass_proverka),
                Units.checkPasswordForValidity(pass_proverka), is(true));
    }
    @Test
    public void testIsPasswordsEquals(){
        String pass1_proverka="Password_123";
        String pass2_proverka="Password_123";
        Assert.assertThat(String.format("Пароли не совпадают %s",pass1_proverka,pass2_proverka),
                Units.checkPasswords(pass1_proverka,pass2_proverka), is(true));
    }
    Model_User model = new Model_User("email@gmail.com","Password_123","Password_123");
    @Test
    public void testIsAccount(){
        Assert.assertThat(String.format("Аккаунт не создан %s",model),
                Units.Valid_Account(model), is(true));
    }
}
package com.example.app_unit_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;


public class MainActivity extends AppCompatActivity {

    Units tests = new Units();
    EditText txtEmail, txtpassword,txtpasswordconf;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtEmail=findViewById(R.id.email);
        txtpassword=findViewById(R.id.password);
        txtpasswordconf=findViewById(R.id.password_confirm);
        btnAdd= findViewById(R.id.button);
        btnAdd.setOnClickListener(view -> {
            String email_pr = txtEmail.getText().toString();
            String pass_pr = txtpassword.getText().toString();
            String pass_conf_pr = txtpasswordconf.getText().toString();
            Model_User model = new Model_User(email_pr,pass_pr,pass_conf_pr);
            tests.validateAccount(MainActivity.this, model);
        });
    }
}
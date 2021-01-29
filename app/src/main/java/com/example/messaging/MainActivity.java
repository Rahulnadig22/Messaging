package com.example.messaging;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText mEmail = findViewById(R.id.login_email);
        EditText mPassword = findViewById(R.id.login_password);

    }


    public void onSigninClicked(View view){

    }

    public void onRegisterClicked(View view){
        Intent register = new Intent(MainActivity.this,SignIn.class);
        finish();
        startActivity(register);
    }
}
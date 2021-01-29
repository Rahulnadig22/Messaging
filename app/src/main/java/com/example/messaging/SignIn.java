package com.example.messaging;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {

    private EditText mUsername;
    private EditText mRegEmail;
    private EditText mRegPassword;
    private EditText mConfirmPassword;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mUsername = findViewById(R.id.register_Username);
        mRegEmail = findViewById(R.id.register_email);
        mRegPassword = findViewById(R.id.register_password);
        mConfirmPassword = findViewById(R.id.confirm_password);


        String password = mRegPassword.getText().toString();
        String cpassword = mConfirmPassword.getText().toString();

        if(password.compareTo(cpassword)!=0){
            Toast.makeText(SignIn.this,"Password Does'nt Match",Toast.LENGTH_LONG).show();
        }

        mAuth = FirebaseAuth.getInstance();
    }

    public void onSignUpClicked(View view){
        createFirebaseUser();
    }

    private void createFirebaseUser(){
        String email = mRegEmail.getText().toString();
        String password = mRegPassword.getText().toString();
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d("Chat","User Created"+task.isSuccessful());

                if(!task.isSuccessful()){
                    Log.d("Chat","user creation failed");
                }
            }
        });
    }
}
package com.example.messaging;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText mEmail;
    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEmail = findViewById(R.id.login_email);
        mPassword = findViewById(R.id.login_password);

        mAuth = FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser()!=null){
            Intent intent = new Intent(MainActivity.this,MainChat.class);
            startActivity(intent);
        }

    }


    public void onSigninClicked(View view){
        attempLogin();
    }

    public void onRegisterClicked(View view){
        Intent register = new Intent(MainActivity.this,SignIn.class);
        finish();
        startActivity(register);
    }
    private void attempLogin(){
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();

        if(email.equals("") || password.equals("")) return;
        Toast.makeText(this,"Login in Progress...",Toast.LENGTH_LONG).show();

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d("Chat","SignInWithEmail"+task.isSuccessful());

                if(!task.isSuccessful()){
                    Log.d("Chat","Problem signing In"+task.getException());
                    ShowErrodDialog();
                }else {
                    Intent intent = new Intent(MainActivity.this,MainChat.class);
                    finish();
                    startActivity(intent);
                }
            }
        });
    }


    private void ShowErrodDialog(){
        new AlertDialog.Builder(this).setTitle("OOPS!!!").setMessage("Login Failed").setPositiveButton(android.R.string.ok,null)
                .setIcon(android.R.drawable.ic_dialog_alert).show();
    }
}
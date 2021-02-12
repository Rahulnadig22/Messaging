package com.example.messaging;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;

public class MainChat extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private String mDisplayName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chat);
        setUpDisplayName();

        mRecyclerView = findViewById(R.id.rv_chat_details);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainChat.this,RecyclerView.VERTICAL,false));


    }

    private String setUpDisplayName(){
        SharedPreferences preferences = getSharedPreferences(SignIn.CHAT_PREFS,MODE_PRIVATE);
        mDisplayName = preferences.getString(SignIn.DISPLAY_NAME_KEY,null);

        if(mDisplayName == null) mDisplayName= "Anonymous";

        return mDisplayName;
    }
}
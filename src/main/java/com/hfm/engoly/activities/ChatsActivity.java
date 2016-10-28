package com.hfm.engoly.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.hfm.engoly.R;
import com.hfm.engoly.REST;

public class ChatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);

    }

    @Override
    protected void onStart() {
        super.onStart();
        getChat();
}
    private void getChat(){
        REST rest=new REST(this);
        rest.execute();
    };
}

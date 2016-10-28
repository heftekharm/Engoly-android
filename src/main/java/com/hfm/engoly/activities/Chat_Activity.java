package com.hfm.engoly.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.hfm.engoly.Adapter;
import com.hfm.engoly.Chat;
import com.hfm.engoly.ExClass;
import com.hfm.engoly.R;

public class Chat_Activity extends AppCompatActivity {
    RecyclerView recycle_view;
    Chat chat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        makeReadySomeUIs();
        chat=getChat();
        initialChatList();
    }
    private void makeReadySomeUIs(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    private void initialChatList() {
       recycle_view = (RecyclerView) findViewById(R.id.chat_list);
        recycle_view.setLayoutManager(new LinearLayoutManager(this));
        recycle_view.setItemAnimator( new DefaultItemAnimator());
        recycle_view.setAdapter(new Adapter(this,0,chat));
    }
    private Chat getChat(){
        Bundle data=getIntent().getBundleExtra("data");
        String hi=data.getString("hi");
        Chat chat= (Chat)data.get("chat");
        return chat;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

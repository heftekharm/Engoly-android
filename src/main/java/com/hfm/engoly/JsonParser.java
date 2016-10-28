package com.hfm.engoly;


import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Hosein on 7/21/2016.
 */
public class JsonParser {

    public static ArrayList<Chat> getSpeeches(Context context, String filename){
        ArrayList<Chat> chats =new ArrayList<>();;
        try {
            InputStream is = context.getAssets().open(filename);
            int size=is.available();
            byte[] buffer=new byte[size];
            is.read(buffer);
            is.close();
            String jsonString=new String(buffer);
            JSONObject json=new JSONObject(jsonString);
            JSONArray dialogues= json.getJSONArray("dialogue");


            for (int i=0;i<dialogues.length();i++){
                JSONObject jspeech= dialogues.getJSONObject(i);
                float st= (float) jspeech.getDouble("start");
                float et= (float) jspeech.getDouble("end");
                String person=jspeech.getString("person");
                String text=jspeech.getString("text");
              //  speeches.add(i,new Chat(st,et,person,text));

            };

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return chats;
    }


}

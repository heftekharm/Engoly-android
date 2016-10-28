package com.hfm.engoly;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Hosein on 7/20/2016.
 */
public class Chat implements Serializable {

    private String[] speakers;
    private String Filename;
    private ArrayList<Speech> speeches;

    public Chat(JSONObject json) {
        try {
            speakers = getSpeakersArray(json.getJSONArray("people"));
            Filename = json.getString("filename");
            speeches = getSpeechesfromJSon(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private String[] getSpeakersArray(JSONArray jsonArray){
        String[] speakers=new String[jsonArray.length()];
        for(int i=0;i<jsonArray.length();i++){
            try {
                speakers[i]=jsonArray.getString(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return speakers;
    }
    private ArrayList<Speech> getSpeechesfromJSon(JSONObject json) throws JSONException {
        JSONArray speechesJsonArray = json.getJSONArray("speeches");
        ArrayList<Speech> speeches = new ArrayList<Speech>();
        for (int i = 0; i < speechesJsonArray.length(); i++) {
            JSONObject SpeechJson = speechesJsonArray.getJSONObject(i);
            double starttime = SpeechJson.getDouble("starttime");
            double endtime = SpeechJson.getDouble("endtime");
            String text = SpeechJson.getString("text");
            String speaker = SpeechJson.getString("speaker");
            speeches.add(i, new Speech(speaker, text, starttime, endtime));
        }
        return speeches;
    }

    public ArrayList getSpeeches() {
        return speeches;
    }

    /*static final Parcelable.Creator<Chat> CREATOR = new Parcelable.Creator<Chat>() {

        @Override
        public Chat createFromParcel(Parcel source) {
            return new Chat(source);
        }

        @Override
        public Chat[] newArray(int size) {
            return new Chat[size];
        }
    };
    public Chat(Parcel in) {
        try {
            speakers = new JSONArray(in.readString());
            Filename = in.readString();
            speeches = new ArrayList<Speech>();
            in.readTypedList(speeches, Speech.CREATOR);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(speakers.toString());
        dest.writeString(Filename);
        dest.writeTypedList(speeches);
    }*/


}


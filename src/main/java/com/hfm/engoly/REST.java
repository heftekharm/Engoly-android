package com.hfm.engoly;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;

import com.hfm.engoly.activities.Chat_Activity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Hosein on 9/29/2016.
 */
public class REST extends AsyncTask<Void, Void, Chat> {
    private String name;
    private String urlAddress="localhost:3000/initchat/";
    private Activity activity;
    private ProgressDialog progressDlg;
    public REST(Activity activity) {
        this.activity=activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDlg=new ProgressDialog(activity);
        progressDlg.setMessage("Please wait ...");
        progressDlg.setIndeterminate(true);
        progressDlg.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDlg.setProgress(0);
        progressDlg.show();
    }

    @Override
    protected Chat doInBackground(Void... params) {
        String name="We Seem to Have a Bad Connection";
        String jsonInString= GetJsonAsStringFromServer(name);
        JSONObject json=null;
        Chat chat=null;
        try {
            json=new JSONObject(jsonInString);
            chat=makeAchatFromJson(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return chat;
    }

    @Override
    protected void onPostExecute(Chat chat) {
        super.onPostExecute(chat);
        progressDlg.dismiss();
        Intent intent=new Intent(activity.getApplicationContext(),Chat_Activity.class);
        Bundle data=new Bundle();
        data.putSerializable("chat",chat);
        data.putString("hi","Helllooooo");
        intent.putExtra("data",data);
        activity.startActivity(intent);
    }
    private ExClass getExclass(){
        return new ExClass("Hosein",4,6,9,7,2);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    public String GetJsonAsStringFromServer(String name){
        String modifiedName=name.replaceAll(" ","_");
        String urlAddress="http://192.168.0.104:3000/initchat/";
        String output="";
        try {
            URL url=new URL(urlAddress+modifiedName);
            HttpURLConnection httpConnection=(HttpURLConnection) url.openConnection();
            httpConnection.setRequestMethod("GET");
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
            StringBuilder stringBuiler=new StringBuilder();
            String line;
            while((line=bufferedReader.readLine())!=null){
                stringBuiler.append(line);
            }
            output=stringBuiler.toString();
            bufferedReader.close();
            httpConnection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        storeInDB(name,output);
        return output;
    }

    private  void storeInDB(String name, String data) {
        File path= Environment.getExternalStorageDirectory();
        File chat=new File(path,name);
        try {
            chat.createNewFile();
            FileOutputStream stream=new FileOutputStream(chat);
            OutputStreamWriter writer=new OutputStreamWriter(stream);
            writer.write(data);
            writer.flush();
            writer.close();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Chat makeAchatFromJson(JSONObject json){
            Chat chat=new Chat(json);
        return  chat;
    }
}

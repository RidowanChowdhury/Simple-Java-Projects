package com.example.ridwan.weather;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ridwan on 11/10/2016.
 */

public class DownloadTask extends AsyncTask<String,Void,String> {
    static String placename="";static String hum="";static String setTime="";static String riseTime="";
    static String tr="";
    @Override
    protected String doInBackground(String... urls) {
        String result="";
        URL url ;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL(urls[0]);
            urlConnection = (HttpURLConnection)url.openConnection();
            InputStream in = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            int data = reader.read();
            while(data!=-1) {
                char current = (char)data;
                result+=current;
                data=reader.read();
            }
        }
        catch (Exception e) {

        }

        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONObject jsonObject = new JSONObject(s);
            //String weatherinfo = jsonObject.getString("weather");
            JSONObject datas = new JSONObject(jsonObject.getString("main"));
            double tempint = Double.parseDouble(datas.getString("temp"));
            JSONObject sys = new JSONObject(jsonObject.getString("sys"));
            long rise = Long.parseLong(sys.getString("sunrise"));
            long set = Long.parseLong(sys.getString("sunset"));
            int tempin = (int) (tempint-273.15);//(tempint*1.8-459.67);
             placename = jsonObject.getString("name");
             hum = (datas.getString("humidity"))+"%";
            /*JSONArray jsonArray = new JSONArray(weatherinfo);
            for(i=0; i<jsonArray.length();i++) {
                JSONObject jsonpart = jsonArray.getJSONObject(i);

            }*/
            Date dt = new Date(set * 1000);
            Date dt1 = new Date(rise * 1000);
            SimpleDateFormat sfd = new SimpleDateFormat("HH:mm:ss");
             setTime = sfd.format(dt);
             riseTime = sfd.format(dt1);
            tr= String.valueOf(tempin)+"°C";

        /*MainActivity.tempView.setText("Temparature "+String.valueOf(tempin)+"°C");
            MainActivity.nameView.setText(placename);
            MainActivity.humView.setText("Humidity "+hum+"%");
            MainActivity.riseView.setText("Sunrise "+riseTime+" AM");
            MainActivity.setView.setText("Sunset "+setTime+" PM");*/
        }
        catch (Exception e) {

        }

    }
}

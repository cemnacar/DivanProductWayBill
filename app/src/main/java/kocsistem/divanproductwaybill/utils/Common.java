package kocsistem.divanproductwaybill.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Common{
    public static String getJSON(String url, String params ,int timeout) {
        HttpURLConnection c = null;

        URL u = null;
        try {
            u = new URL(url);

            c = (HttpURLConnection) u.openConnection();
            c.setRequestMethod("GET");
            c.setRequestProperty("Content-length", "0");
            c.setUseCaches(false);
            c.setAllowUserInteraction(false);
            c.setConnectTimeout(timeout);
            c.setReadTimeout(timeout);
            c.connect();



            int status = c.getResponseCode();

            switch (status) {
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line+"\n");
                    }
                    br.close();


                    return sb.toString();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            c.disconnect();
        }

        return null;
    }

    public static String postJSON(String url, String params ,int timeout) {
        HttpURLConnection c = null;

        URL u = null;
        try {
            u = new URL(url);

            c = (HttpURLConnection) u.openConnection();
            c.setRequestMethod("POST");
            c.setRequestProperty("Accept", "application/json");
            c.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            c.setUseCaches(false);
            c.setAllowUserInteraction(false);
            c.setConnectTimeout(timeout);
            c.setDoInput(true);
            c.setDoOutput(true);
            c.setReadTimeout(timeout);

            if(params != null && !params.isEmpty()){
                OutputStream os = c.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(params);
                writer.flush();
                writer.close();
            }

            c.connect();


            int status = c.getResponseCode();

            switch (status) {
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line+"\n");
                    }
                    br.close();


                    return sb.toString();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            c.disconnect();
        }

        return null;
    }

}

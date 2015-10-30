package kocsistem.divanproductwaybill.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Common{
    public static String getJSON(String url, int timeout) {
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
}

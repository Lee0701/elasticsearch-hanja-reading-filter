package io.github.lee0701.hanjareading;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HanjaReadingApi {

    URL url;

    public HanjaReadingApi(String url) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public String request(String text, String format) {
        JSONObject data = new JSONObject();
        data.put("format", format);
        data.put("text", text);
        data.put("group", true);
        data.put("stringify", true);
        byte[] dataBytes = data.toString().getBytes(StandardCharsets.UTF_8);
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Content-Length", String.valueOf(dataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(dataBytes);
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            String line;
            StringBuilder response = new StringBuilder();
            while((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();
            JSONObject result = new JSONObject(response.toString());
            return result.getString("result");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

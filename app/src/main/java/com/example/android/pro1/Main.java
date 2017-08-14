package com.example.android.pro1;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.simple.JSONObject;

/**
 *
 * @author iSaleem
 */
public class Main {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static void main(String[] args) throws IOException {
        String url = "https://fcm.googleapis.com/fcm/send";
//        String token = "dM6WGmledy0:APA91bHdUnYl5G0TU7n1gmzn-2LXR07MkMkayn3xaqqdOx4L119Mi17iWWP4AEoHqhhlZqxKwBaXGbXR6onUdrkHE7hOb0RtJx7WRCC4ur7nB4qUteInj2-hayOJsudeBUIO5y35kv9m";
        String token = "chPaPFLdYh4:APA91bHLcPGZN_YEuNLeTO0Ce6QyE0UvE3CiKPFON0k4vWtMlVIQJfPjUegUpuAav12meNhminGq02iU6zInQYmQucaNRW43jt8KC2MTotuL6W4co4U6pnXEC_C2A_2Uk4RpLfI2H4Bk";

        OkHttpClient client = new OkHttpClient();
        JSONObject root = new JSONObject();
        root.put("to", token);
        root.put("priority", "high");
        JSONObject notification = new JSONObject();
        notification.put("body", "aaa");
        notification.put("title","zzzz");

        root.put("notification", notification);


        JSONObject data = new JSONObject();
        data.put("body", "www");
        data.put("title","eeee");
        root.put("data", data);

        RequestBody body = RequestBody.create(JSON, root.toString());
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Authorization", "key="+"AAAAoZ3LqAg:APA91bHe4GBtJesmWye7KEW46ejXDnYa7Qr19eLxXZRum8oB-8W4K0kdSI3HcqCwF2tB0yk80S5L0KbPEyAUOjwSkZmTUsJo1UDyLG_WnH9H0JsmV5BDSwqRsIEC6Kf6rLwUXtzaPzTT")
                .build();
        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());
    }

}


package com.example.android.pro1;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import org.json.JSONException;
import org.json.simple.JSONObject;
import android.widget.Toast;


import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {
    Button getNotifiaction;
    Button getToken;

    //    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getNotifiaction = (Button) findViewById(R.id.notfication);
        getToken = (Button) findViewById(R.id.token);

        getNotifiaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    run();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (getIntent().hasExtra("body"))
                    Toast.makeText(MainActivity.this, getIntent().getStringExtra("body").toString(), Toast.LENGTH_SHORT).show();
            }
        });

        getToken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String token = FirebaseInstanceId.getInstance().getToken();
                Toast.makeText(MainActivity.this, token, Toast.LENGTH_SHORT).show();
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create channel to show notifications.
            String channelId = "default_notification_channel_id";
            String channelName = "default_notification_channel_name";
            NotificationManager notificationManager =
                    getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(new NotificationChannel(channelId,
                    channelName, NotificationManager.IMPORTANCE_LOW));
        }


//      Singltone singltone=Singltone.getInctance();
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d("Token", token + "");
//        if (getIntent().hasExtra("body"))
//        Toast.makeText(this, getIntent().getStringExtra("body").toString(), Toast.LENGTH_SHORT).show();

    }

   public void run() throws IOException, InterruptedException {
        final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
       String url = "https://fcm.googleapis.com/fcm/send";
//        String token = "dM6WGmledy0:APA91bHdUnYl5G0TU7n1gmzn-2LXR07MkMkayn3xaqqdOx4L119Mi17iWWP4AEoHqhhlZqxKwBaXGbXR6onUdrkHE7hOb0RtJx7WRCC4ur7nB4qUteInj2-hayOJsudeBUIO5y35kv9m";
       final String token = "chPaPFLdYh4:APA91bHLcPGZN_YEuNLeTO0Ce6QyE0UvE3CiKPFON0k4vWtMlVIQJfPjUegUpuAav12meNhminGq02iU6zInQYmQucaNRW43jt8KC2MTotuL6W4co4U6pnXEC_C2A_2Uk4RpLfI2H4Bk";

       final OkHttpClient client = new OkHttpClient();
       final JSONObject root = new JSONObject();
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
       final Request request = new Request.Builder()
               .url(url)
               .post(body)
               .addHeader("Authorization", "key="+"AAAAoZ3LqAg:APA91bHe4GBtJesmWye7KEW46ejXDnYa7Qr19eLxXZRum8oB-8W4K0kdSI3HcqCwF2tB0yk80S5L0KbPEyAUOjwSkZmTUsJo1UDyLG_WnH9H0JsmV5BDSwqRsIEC6Kf6rLwUXtzaPzTT")
               .build();
//       Response response = client.newCall(request).execute();
//       System.out.println(response.body().string());

       client.newCall(request).enqueue(new Callback() {
           @Override
           public void onFailure(Call call, IOException e) {
               call.cancel();
           }

           @Override
           public void onResponse(Call call, Response response) throws IOException {

               final String myResponse = response.body().string();

               MainActivity.this.runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                       try {
                           if (getIntent().hasExtra("body"))
                   Toast.makeText(MainActivity.this, getIntent().getStringExtra("body").toString(), Toast.LENGTH_SHORT).show();
//                           JSONObject json = new JSONObject(myResponse);
//                           txtString.setText(json.getJSONObject("data").getString("first_name")+ " "+json.getJSONObject("data").getString("last_name"));

                       } catch (Exception e) {
                           e.printStackTrace();
                       }
                   }
               });

           }
       });

   }
}

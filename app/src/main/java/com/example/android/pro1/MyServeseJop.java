package com.example.android.pro1;

import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;

public class MyServeseJop extends JobService {

    private static final String TAG = "MyJobService";

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.d(TAG, "Performing long running task in scheduled job");
        // TODO(developer): add long running task here.
//        Toast.makeText(this,getApplicationInfo().getClass().geti, Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

}

//import android.app.job.JobParameters;
//import android.app.job.JobService;
//import android.os.Build;
//import android.support.annotation.RequiresApi;
//import android.util.Log;
//
///**
// * Created by Mahmoud Abdo on 8/13/2017.
// */
//
//@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//public class MyServeseJop extends JobService {
//    private static final String TAG = "MyJobService";
//    @Override
//    public boolean onStartJob(JobParameters jobParameters) {
//        Log.d(TAG, "Performing long running task in scheduled job");
//        return false;
//    }
//
//    @Override
//    public boolean onStopJob(JobParameters jobParameters) {
//        return false;
//    }
//}

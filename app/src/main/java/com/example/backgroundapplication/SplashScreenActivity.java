package com.example.backgroundapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.VideoView;

import com.google.android.material.snackbar.Snackbar;

public class SplashScreenActivity extends AppCompatActivity {
    String TAG = "Splash";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_splash_screen);
            VideoView videoView = findViewById(R.id.splashVideo);

            Uri path = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splash);

            videoView.setVideoURI(path);
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    jump();
                }
            });
            videoView.start();
        } catch (Exception e) {
            Log.e("exception", e.getMessage());
            jump();
        }

    }


    public void jump() {
        if (isFinishing())
            return;
        startActivity(new Intent(this, MainActivity.class));
        finish();

//        else{
//            Log.e("error", "internet error");
//            Toast.makeText(this, "Check your internet connection", Toast.LENGTH_SHORT).show();
//        }
     //   checkInternetConnection(this);
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    public static void checkInternetConnection(final Context context) {
        View rootView = ((Activity) context).getWindow().getDecorView().getRootView();
        if (isOnline(context)) {
            Log.e("check internet", "online");
            return;
        } else {
            Log.e("check internet", "offline");
            Snackbar snackbar = Snackbar.make(rootView, "You are offline, check your internet connection"
                    , Snackbar.LENGTH_INDEFINITE).setAction("Retry", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkInternetConnection(context);
                }
            });

            snackbar.show();
        }
    }

}


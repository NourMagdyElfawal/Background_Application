package com.example.backgroundapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import androidx.viewpager.widget.ViewPager;
import android.app.WallpaperManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgStar,imgShare,imgBackground;


    public Bitmap bitmap1, bitmap2 ;
    DisplayMetrics displayMetrics ;
    int width, height;
    private int indexOfImage = 0;
    ImageAdapter adapter;
    private InterstitialAd interstitial;
    private AdView mAdView;
    TextView bannerTextView,titleTextView;

    AlertDialog.Builder alertdialogbuilder,alertdialogbuilderForExit;

    String[] AlertDialogItems = new String[]{
            "تعيين خلفية للهاتف",
            "تعيين صورة خلفية للقفل",
    };

  final   List<String> ItemsIntoList=Arrays.asList(AlertDialogItems);;

    boolean[] SelectedTrueFalse = new boolean[]{
            false,
            false,
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
//        viewPager.generateViewId();
//        viewPager.setId(R.id.ViewPagerIds);


        adapter = new ImageAdapter(this); //Here we are defining the Imageadapter object

        viewPager.setAdapter(adapter); // Here we are passing and setting the adapter for the images

        viewPager.setOnPageChangeListener(new MyPageChangeListener());

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        InterstitialAdmob();

        // Find Banner ad
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        // Display Banner ad
        mAdView.loadAd(adRequest);


        imgStar=findViewById(R.id.star);
        imgShare=findViewById(R.id.share);
        imgBackground=findViewById(R.id.background);

        bannerTextView=findViewById(R.id.banner);
        titleTextView=findViewById(R.id.title);

        imgStar.setOnClickListener(this);
        imgShare.setOnClickListener(this);
        imgBackground.setOnClickListener(this);



    }


    private void InterstitialAdmob() {


        // Prepare the Interstitial Ad
        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId("ca-app-pub-9975967949099489/8194054750");
        interstitial.loadAd(new AdRequest.Builder().build());

        interstitial.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                interstitial.loadAd(new AdRequest.Builder().build());
            }

        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will

        // automatically handle clicks on the Home/Up button, so long

        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        Toast.makeText(this, id, Toast.LENGTH_SHORT).show();

//        if (id == R.id.action_settings) {
//
//            return true;
//
//        }


        return super.onOptionsItemSelected(item);

    }


    @Override
    public void onClick(View v) {
        // Perform action on click
        switch(v.getId()) {
            case R.id.star:
                ShowOurApplications();
                break;
            case R.id.share:
                ShareApplication();
                break;

            case R.id.background:
                ShowDialog();
                break;

        }

    }

    private void ShowDialog() {
        alertdialogbuilder = new AlertDialog.Builder(MainActivity.this);

//        ItemsIntoList = Arrays.asList(AlertDialogItems);

        alertdialogbuilder.setMultiChoiceItems(AlertDialogItems, SelectedTrueFalse, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                // Get the current focused item
                String currentItem = ItemsIntoList.get(which);

//                // Notify the current action
//                Toast.makeText(getApplicationContext(),
//                        currentItem , Toast.LENGTH_SHORT).show();

            }
        });

        alertdialogbuilder.setCancelable(false);

//        alertdialogbuilder.setTitle("Select Subjects Here");

        alertdialogbuilder.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {



                for (int i = 0; i<SelectedTrueFalse.length; i++){
                    boolean checked = SelectedTrueFalse[i];
                    if (checked) {

                        if(ItemsIntoList.get(i).equalsIgnoreCase("تعيين خلفية للهاتف")) {
                            HomeWallpaper();
                        }else if(ItemsIntoList.get(i).equalsIgnoreCase("تعيين صورة خلفية للقفل")){
                            LockScreen();
                        }
                        prepareAd();

                    }
                }

            }
        });

        alertdialogbuilder.setNeutralButton("خروج", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog dialog = alertdialogbuilder.create();

        dialog.show();
    }




    private void ShowOurApplications() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=M.3.H.D"));
        startActivity(browserIntent);
    }

    private void ShareApplication() {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Your body here";
        String shareSub = "Your subject here";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share using"));

        prepareAd();


    }

    // function for show interstitial Ads
    public void prepareAd() {
        if (interstitial.isLoaded()) {
            interstitial.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }

    private void HomeWallpaper() {

        int id=adapter.GalImages[indexOfImage];
        bitmap1 = BitmapFactory.decodeResource(getResources(), id);


        GetScreenWidthHeight();
        SetBitmapSize();

        WallpaperManager myWallpaperManager = WallpaperManager.getInstance(getApplicationContext());
        try {


            myWallpaperManager.setBitmap(bitmap2);

            myWallpaperManager.suggestDesiredDimensions(width, height);

            Toast.makeText(this, "تم تعيين خلفية الهاتف بنجاح", Toast.LENGTH_LONG).show();


        } catch (IOException e) {
            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }


    }


    private void LockScreen(){
        int id=adapter.GalImages[indexOfImage];
        bitmap1 = BitmapFactory.decodeResource(getResources(), id);

        GetScreenWidthHeight();
        SetBitmapSize();

        WallpaperManager myWallpaperManager = WallpaperManager.getInstance(getApplicationContext());
        try {


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                myWallpaperManager.setBitmap(bitmap2, null, true, WallpaperManager.FLAG_LOCK);
                Toast.makeText(this, "تم تعيين خلفية القفل بنجاح", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "نأسف هذا الهاتف لا يتمتع بهذه الخاصية  ", Toast.LENGTH_LONG).show();

            }

        } catch (IOException e) {
            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }




    }
        
    private void GetScreenWidthHeight() {
        displayMetrics = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        width = displayMetrics.widthPixels;

        height = displayMetrics.heightPixels;

    }

    private void SetBitmapSize() {
        bitmap2 = Bitmap.createScaledBitmap(bitmap1, width, height, false);
    }



    private class MyPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            indexOfImage = position;
            if(String.valueOf(indexOfImage)!=null)
            Log.e("index", String.valueOf(indexOfImage));
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Handle the back button
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            //Ask the user if they want to quit
            alertdialogbuilderForExit = new AlertDialog.Builder(MainActivity.this);
            alertdialogbuilderForExit
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setMessage("هل تريد تقييم البرنامج؟")
                    .setPositiveButton("نعم", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=M.3.H.D"));
                                startActivity(browserIntent);

                        }

                    })

                    .setNeutralButton("خروج", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Stop the activity
                            MainActivity.this.finish();

                        }
                    });
            AlertDialog dialog = alertdialogbuilderForExit.create();

                    dialog.show();

            return true;
        }
        else {
            return super.onKeyDown(keyCode, event);
        }

    }
}


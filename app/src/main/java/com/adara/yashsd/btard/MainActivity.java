package com.adara.yashsd.btard;

import android.media.Image;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView remote, controller, home, rgb, switc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //------------------------------------------------------------------------------------------

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int w = (int) ((float)width/5.0);

        //------------------------------------------------------------------------------------------

        remote = (ImageView) findViewById(R.id.nav_remote);
        remote.setMaxWidth(w);
        remote.setMinimumWidth(w);
        remote.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        remote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new RemoteFragment());
            }
        });

        controller = (ImageView) findViewById(R.id.nav_controller);
        controller.setMaxWidth(w);
        controller.setMinimumWidth(w);
        controller.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        controller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new ControllerFragment());
            }
        });

        home = (ImageView) findViewById(R.id.nav_home);
        home.setMaxWidth(w);
        home.setMinimumWidth(w);
        home.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new HomeFragment());
            }
        });

        rgb = (ImageView) findViewById(R.id.nav_rgb);
        rgb.setMaxWidth(w);
        rgb.setMinimumWidth(w);
        rgb.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        rgb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new RGBFragment());
            }
        });

        switc = (ImageView) findViewById(R.id.nav_switch);
        switc.setMaxWidth(w);
        switc.setMinimumWidth(w);
        switc.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        switc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new SwitchFragment());
            }
        });

        //------------------------------------------------------------------------------------------

        loadFragment(new HomeFragment());

        //------------------------------------------------------------------------------------------
    }

    private boolean loadFragment(Fragment fragment){
        if(fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .setTransitionStyle(FragmentTransaction.TRANSIT_ENTER_MASK)
                    .commit();
            return true;
        }
        return false;
    }

}

package com.nevdia.atta.atta_app;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private Thread splashTread;
    private ImageView imageView;
    private LinearLayout linear;

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StartAnimations();



    }
    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        linear = (LinearLayout) findViewById(R.id.lin_lay);

        linear.clearAnimation();
        linear.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        imageView = (ImageView) findViewById(R.id.splash);
        imageView.clearAnimation();
        imageView.startAnimation(anim);

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 5000) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(MainActivity.this,
                            HomeActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    MainActivity.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    MainActivity.this.finish();
                }

            }
        };
        splashTread.start();
    }
}

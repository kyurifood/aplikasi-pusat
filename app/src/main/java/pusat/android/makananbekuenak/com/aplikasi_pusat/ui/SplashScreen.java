package pusat.android.makananbekuenak.com.aplikasi_pusat.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import pusat.android.makananbekuenak.com.aplikasi_pusat.R;

/**
 * Created by gilang on 05/05/16.
 */

public class SplashScreen extends Activity {

    private static final int SPLASH_TIME = 3 * 1000;
    // Set waktu 3 Detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME);
    }
}
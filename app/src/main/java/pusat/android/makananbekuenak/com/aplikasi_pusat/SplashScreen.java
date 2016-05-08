package pusat.android.makananbekuenak.com.aplikasi_pusat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by fidya on 05/05/16.
 */
public class SplashScreen extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread timer=new Thread(){
            public void run(){
                try{
                    //berapalama splasscreen akan ditampilkan dalam milisecond
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //activity yang akan dijalankan setelah splashscreen selesai
                    Intent i = new Intent(SplashScreen.this,HomeScreen.class);
                    startActivity(i);
                }
            }
        };
        timer.start();
    }
}

package pusat.android.makananbekuenak.com.aplikasi_pusat.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import pusat.android.makananbekuenak.com.aplikasi_pusat.R;

public class Regional extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regional);

        getSupportActionBar().setTitle("REGIONAL");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.bar_ic_placeholder);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }
}
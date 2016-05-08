package pusat.android.makananbekuenak.com.aplikasi_pusat.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import pusat.android.makananbekuenak.com.aplikasi_pusat.R;

public class Marketer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marketer);

        getSupportActionBar().setTitle("MARKETER");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.bar_ic_conversation);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }
}

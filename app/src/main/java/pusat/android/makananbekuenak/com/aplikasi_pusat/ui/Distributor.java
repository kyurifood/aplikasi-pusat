package pusat.android.makananbekuenak.com.aplikasi_pusat.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import pusat.android.makananbekuenak.com.aplikasi_pusat.R;

public class Distributor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.distributor);

        getSupportActionBar().setTitle("DISTRIBUTOR");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.bar_ic_truck_2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }
}
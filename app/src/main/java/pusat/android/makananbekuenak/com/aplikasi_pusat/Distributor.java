package pusat.android.makananbekuenak.com.aplikasi_pusat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Distributor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.distributor);

        getSupportActionBar().setTitle("DISTRIBUTOR");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.bar_ic_maps_local_shipping);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }
}
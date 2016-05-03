package pusat.android.makananbekuenak.com.aplikasi_pusat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Marketer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marketer);

        getSupportActionBar().setTitle("MARKETER");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.bar_ic_action_account_child);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }
}

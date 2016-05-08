package pusat.android.makananbekuenak.com.aplikasi_pusat.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.view.View;
import android.widget.Button;

import pusat.android.makananbekuenak.com.aplikasi_pusat.R;

public class Laporan extends AppCompatActivity {

    private Button btn_prdk, btn_mrktr, btn_dstrbtr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laporan);

        getSupportActionBar().setTitle("LAPORAN");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.bar_ic_clipboard);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        btn_prdk = (Button) findViewById(R.id.btn_produk);

        btn_prdk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Intent intent = new Intent(getApplicationContext(), Produk.class);
                //startActivity(intent);
            }
        });

        btn_mrktr = (Button) findViewById(R.id.btn_marketer);

        btn_mrktr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Intent intent = new Intent(getApplicationContext(), Marketer.class);
                //startActivity(intent);
            }
        });

        btn_dstrbtr = (Button) findViewById(R.id.btn_distributor);

        btn_dstrbtr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Intent intent = new Intent(getApplicationContext(), Distributor.class);
                //startActivity(intent);
            }
        });

    }

}
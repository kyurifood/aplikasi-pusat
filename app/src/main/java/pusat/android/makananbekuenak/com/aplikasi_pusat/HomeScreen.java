package pusat.android.makananbekuenak.com.aplikasi_pusat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    Button btn_produk , btn_regional , btn_distributor , btn_marketer , btn_pesanan , btn_laporan ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

<<<<<<< HEAD


        btn_produk = (Button) findViewById(R.id.btnProduk);
        btn_produk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(HomeScreen.this,
                        DaftarProduk.class);
                startActivity(myIntent);
            }
        });

        btn_regional = (Button) findViewById(R.id.btnRegional);
        btn_regional.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(HomeScreen.this,
                        Regional.class);
                startActivity(myIntent);
            }
        });

        btn_distributor = (Button) findViewById(R.id.btnDistributor);
        btn_distributor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(HomeScreen.this,
                        Distributor.class);
                startActivity(myIntent);
            }
        });

        btn_marketer = (Button) findViewById(R.id.btnMarketer);
        btn_marketer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(HomeScreen.this,
                        Marketer.class);
                startActivity(myIntent);
            }
        });

        btn_pesanan = (Button) findViewById(R.id.btnPesanan);
        btn_pesanan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(HomeScreen.this,
                        MainActivity.class);
                startActivity(myIntent);
            }
        });

        btn_laporan = (Button) findViewById(R.id.btnLaporan);
        btn_laporan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(HomeScreen.this,
                        Laporan.class);
                startActivity(myIntent);
            }
        });

=======
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
>>>>>>> bbf0b270260caaddc4ab54765e6e012af9535960
        //Intent intent = new Intent(this, LoginActivity.class);
        //startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //--Regional---
    public void btn_regional(View v) {

        Intent panggil_class = new Intent(this, pusat.android.makananbekuenak.com.aplikasi_pusat.Regional.class);
        startActivity(panggil_class);
    }

    //--Distibutor---
    public void btn_distributor(View v) {

        Intent panggil_class = new Intent(this, pusat.android.makananbekuenak.com.aplikasi_pusat.Distributor.class);
        startActivity(panggil_class);
    }

    //--Marketer---
    public void btn_marketer(View v) {

        Intent panggil_class = new Intent(this, pusat.android.makananbekuenak.com.aplikasi_pusat.Marketer.class);
        startActivity(panggil_class);
    }

    //--Pesanan---
    public void btn_pesanan(View v) {

        Intent panggil_class = new Intent(this, pusat.android.makananbekuenak.com.aplikasi_pusat.MainActivity.class);
        startActivity(panggil_class);
    }
    //--Laporan---
    public void btn_laporan(View v) {

        Intent panggil_class = new Intent(this, pusat.android.makananbekuenak.com.aplikasi_pusat.Laporan.class);
        startActivity(panggil_class);

        Button pengaturan = (Button) findViewById(R.id.btnPesanan);

        pengaturan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Laporan.class);
                startActivity(intent);
            }
        });

    }

}

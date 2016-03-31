package pusat.android.makananbekuenak.com.aplikasi_pusat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
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
    //--Produk---
    public void btn_produk(View v) {

        Intent panggil_class = new Intent(this, pusat.android.makananbekuenak.com.aplikasi_pusat.Produk.class);
        startActivity(panggil_class);
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

        Intent panggil_class = new Intent(this, pusat.android.makananbekuenak.com.aplikasi_pusat.Pesanan.class);
        startActivity(panggil_class);
    }

    //--Laporan---
    public void btn_laporan(View v) {

        Intent panggil_class = new Intent(this, pusat.android.makananbekuenak.com.aplikasi_pusat.Laporan.class);
        startActivity(panggil_class);
    }
}

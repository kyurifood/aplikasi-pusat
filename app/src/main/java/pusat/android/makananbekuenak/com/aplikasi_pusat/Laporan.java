package pusat.android.makananbekuenak.com.aplikasi_pusat;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pusat.android.makananbekuenak.com.aplikasi_pusat.adapter.ListBarangAdapter;
import pusat.android.makananbekuenak.com.aplikasi_pusat.domain.ListBarang;


public class Laporan extends AppCompatActivity {

    ListView lvBarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lvBarang = (ListView) findViewById(R.id.listview);

        ListBarang barang1 = new ListBarang();
        barang1.setNama_produk("KARAPAO");
        barang1.setBaru("Baru");
        barang1.setLunas("Lunas");
        barang1.setDikirim("DiKirim");
        barang1.setDiterima("DiTerima");

        ListBarang barang2 = new ListBarang();
        barang2.setNama_produk("TERIAKI");
        barang2.setBaru("Baru");
        barang2.setLunas("Lunas");
        barang2.setDikirim("DiKirim");
        barang2.setDiterima("Diterima");

        List<ListBarang> listBarang = new ArrayList<>();
        listBarang.add(barang1);
        listBarang.add(barang2);

        lvBarang.setAdapter(new ListBarangAdapter(Laporan.this, listBarang));
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
        int id = item.getItemId();ListBarang barang2 = new ListBarang();
        barang2.setBaru("Baru");
        barang2.setLunas("Lunas");
        barang2.setDikirim("DiKirim");
        barang2.setDiterima("Diterima");
        barang2.setCheck1(false);
        barang2.setCheck2(true);
        barang2.setCheck3(false);
        barang2.setCheck4(true);

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
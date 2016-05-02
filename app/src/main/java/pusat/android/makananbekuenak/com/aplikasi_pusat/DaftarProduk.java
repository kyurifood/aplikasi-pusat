package pusat.android.makananbekuenak.com.aplikasi_pusat;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;

import pusat.android.makananbekuenak.com.aplikasi_pusat.adapter.ListItemproduk;
import pusat.android.makananbekuenak.com.aplikasi_pusat.domain.ItemProduk;


/**
 * Created by fikran on 21/04/16.
 */
public class DaftarProduk extends AppCompatActivity {


    private ProdukHandler handler;
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_produk);


        handler = new ProdukHandler(getApplicationContext());

        lv = (ListView) findViewById(R.id.lv_daftar);

        loadContactData();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tambah_produk, menu);
        return true;
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.aksi_tambah) {
            panggilclass();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void panggilclass (){
        Intent panggil = new Intent(getApplicationContext(), Produk.class);
        startActivity(panggil);
    }
    private void loadContactData(){
        // Code for loading contact list in ListView
        // Reading all contacts
        List<ItemProduk> produks = handler.readAllProduks();

        // Initialize Custom Adapter
        ListItemproduk adapter = new ListItemproduk(this, produks);

        // Set Adapter to ListView
        lv.setAdapter(adapter);

        // See the log int LogCat
        for(ItemProduk c : produks){
            String record = "ID=" + c.getId() + " | kode=" + c.getKode() + " | " + c.getNama();
            Log.d("Record", record);
        }

    }




}
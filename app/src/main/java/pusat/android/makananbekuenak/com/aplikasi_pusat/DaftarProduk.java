package pusat.android.makananbekuenak.com.aplikasi_pusat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;


import android.widget.ListView;

import pusat.android.makananbekuenak.com.aplikasi_pusat.adapter.ListItemproduk;


/**
 * Created by fikran on 21/04/16.
 */
public class DaftarProduk extends AppCompatActivity {


    ListView lvdaftar;
    ListItemproduk adapter;


    String[] itemkode;
    String[] itemnama;
    int[] flag;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_produk);

        getSupportActionBar().setTitle("PRODUK");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.bar_ic_action_wallet_travel);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        // Generate sample data into string arrays
        itemkode = new String[] { "001", "002", "003", "004" };

        itemnama = new String[] { "karapao", "takoyaki", "ramen", "biyapong" };
        flag = new int[] { R.drawable.produk, R.drawable.produk,
                R.drawable.produk, R.drawable.produk};


        lvdaftar = (ListView) findViewById(R.id.lv_daftar);

        adapter = new ListItemproduk(this, itemkode, itemnama, flag);
       // adapter = new ListItemproduk(getApplicationContext(), items);
        lvdaftar.setAdapter(adapter);
        lvdaftar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent i= new Intent(getApplicationContext(), EditProduk.class);

                // Pass all data rank
                i.putExtra("itemkode", itemkode);
                // Pass all data country
                i.putExtra("itemnama", itemnama);

                // Pass all data flag
                i.putExtra("flag", flag);
                // Pass a single position
                i.putExtra("position", position);
                startActivity(i);
            }
        });


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


}
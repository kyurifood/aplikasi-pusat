package pusat.android.makananbekuenak.com.aplikasi_pusat;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;


import android.widget.ListView;

import java.util.List;

import pusat.android.makananbekuenak.com.aplikasi_pusat.adapter.ListItemproduk;
import pusat.android.makananbekuenak.com.aplikasi_pusat.domain.ItemProduk;
import pusat.android.makananbekuenak.com.aplikasi_pusat.service.ProdukHandler;


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

        getSupportActionBar().setTitle("PRODUK");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.bar_ic_action_wallet_travel);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


<<<<<<< HEAD
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
=======
        handler = new ProdukHandler(getApplicationContext());

        lv = (ListView) findViewById(R.id.lv_daftar);

        loadContactData();
>>>>>>> 86f92a4915a04e215c014169a07e1817eb3bfec9


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
        final List<ItemProduk> produks = handler.readAllProduks();

        // Initialize Custom Adapter
        ListItemproduk adapter = new ListItemproduk(this, produks);

        // Set Adapter to ListView
        lv.setAdapter(adapter);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                final CharSequence[] dialogitem = {"View", "Edit"};
                AlertDialog.Builder builder = new AlertDialog.Builder(DaftarProduk.this);
                builder.setTitle("Pilih Menu");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0:
                                Intent i = new Intent(getApplicationContext(), viewProduk.class);
                                i.putExtra("id", produks.get(position).getId());
                                i.putExtra("kode", produks.get(position).getKode());
                                i.putExtra("nama", produks.get(position).getNama());
                                i.putExtra("image", produks.get(position).getImage());
                                startActivity(i);
                                break;
                            case 1:

                                Intent intent = new Intent(DaftarProduk.this, EditProduk.class);
                                intent.putExtra("id", produks.get(position).getId());
                                intent.putExtra("kode", produks.get(position).getKode());
                                intent.putExtra("nama", produks.get(position).getNama());
                                intent.putExtra("image", produks.get(position).getImage());
                                startActivity(intent);
                                break;

                        }
                    }
                });
                builder.create().show();
                return false;
            }
        });


        // See the log int LogCat
        for(ItemProduk c : produks){
            String record = "ID=" + c.getId() + " | kode=" + c.getKode() + " | " + c.getNama();
            Log.d("Record", record);
        }

    }




}
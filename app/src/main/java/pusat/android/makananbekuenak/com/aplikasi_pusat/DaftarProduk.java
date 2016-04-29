package pusat.android.makananbekuenak.com.aplikasi_pusat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import pusat.android.makananbekuenak.com.aplikasi_pusat.adapter.ListItemproduk;
import pusat.android.makananbekuenak.com.aplikasi_pusat.domain.ItemProduk;


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


        final List<ItemProduk> items = new ArrayList<>();
        ItemProduk item1 = new ItemProduk();
        item1.setKode("001");
        item1.setNama("karapao");

        ItemProduk item2 = new ItemProduk();
        item2.setKode("002");
        item2.setNama("takoyaki");

        ItemProduk item3 = new ItemProduk();
        item3.setKode("003");
        item3.setNama("okonomiyahi");

        final ItemProduk item4 = new ItemProduk();
        item4.setKode("004");
        item4.setNama("biyapong");

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);

//        itemkode = new String[] { "001", "002", "003", "004" };
//
//        itemnama = new String[] { "karapao", "takoyaki", "ramen", "biyapong" };
//        flag = new int[] { R.drawable.produk, R.drawable.produk,
//                R.drawable.produk, R.drawable.produk};
//

        lvdaftar = (ListView) findViewById(R.id.lv_daftar);

        lvdaftar = (ListView) findViewById(R.id.lv_daftar);


      adapter = new ListItemproduk(getApplicationContext(), items);
        lvdaftar.setAdapter(adapter);
        lvdaftar.setChoiceMode(ListView.CHOICE_MODE_NONE);
        lvdaftar.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

//                final String selection = items [position];
                final CharSequence[] dialogitem = {"View", "Edit"};
                AlertDialog.Builder builder = new AlertDialog.Builder(DaftarProduk.this);
                builder.setTitle("Pilih Menu");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0:
                                Intent i = new Intent(getApplicationContext(), Produk.class);


                                startActivity(i);
                                break;
                            case 1:
                                Intent in = new Intent(getApplicationContext(), EditProduk.class);


                                in.putExtra("itemkode", itemkode);
                                // Pass all data country
                                in.putExtra("itemnama", itemnama);

                                // Pass all data flag
                                in.putExtra("flag", flag);
                                // Pass a single position
//                                in.putExtra("position", selection);
                                startActivity(in);
                                break;

                        }
                    }
                });
                builder.create().show();
                return true;
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
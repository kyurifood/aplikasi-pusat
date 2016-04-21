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
    Button tambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_produk);


        List<ItemProduk> items = new ArrayList<>();
        ItemProduk item1 = new ItemProduk();
        item1.setKode("001");
        item1.setNama("karapao");

        ItemProduk item2 = new ItemProduk();
        item2.setKode("002");
        item2.setNama("takoyaki");

        ItemProduk item3 = new ItemProduk();
        item3.setKode("003");
        item3.setNama("okonomiyahi");

        ItemProduk item4 = new ItemProduk();
        item4.setKode("004");
        item4.setNama("biyapong");

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);



        lvdaftar = (ListView) findViewById(R.id.lv_daftar);

        adapter = new ListItemproduk(getApplicationContext(), items);
        lvdaftar.setAdapter(adapter);
        lvdaftar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(),Produk.class);
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
package pusat.android.makananbekuenak.com.aplikasi_pusat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
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

        tambah = (Button)findViewById(R.id.tambah_produk);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaftarProduk.this, Produk.class));
            }
        });

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
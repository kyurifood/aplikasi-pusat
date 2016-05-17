package pusat.android.makananbekuenak.com.aplikasi_pusat.ui;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pusat.android.makananbekuenak.com.aplikasi_pusat.R;
import pusat.android.makananbekuenak.com.aplikasi_pusat.adapter.ListItemLiat;
import pusat.android.makananbekuenak.com.aplikasi_pusat.domain.Item;
import pusat.android.makananbekuenak.com.aplikasi_pusat.service.ProdukHandler;

/**
 * Created by fikran on 02/05/16.
 */
public class viewProduk extends AppCompatActivity {

   private ProdukHandler handler;
    ListView lvItem;
    ListItemLiat adapter;
    List<Item> items = new ArrayList<>();
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_produk_scrol);

        getSupportActionBar().setTitle("Lihat Produk");

        extras = getIntent().getExtras();
        handler = new ProdukHandler(getApplicationContext());

        ImageView iv_photo = (ImageView) findViewById(R.id.poto);
        if (extras.getString("image").isEmpty()){
            iv_photo.setImageResource(R.drawable.poot);
        }else {
            iv_photo.setImageBitmap(BitmapFactory.decodeFile(extras.getString("image")));
        }

        TextView tv_kode = (TextView) findViewById(R.id.liatkode);
        tv_kode.setText(extras.getString("kode"));

        TextView tv_nama = (TextView) findViewById(R.id.liatnama);
        tv_nama.setText(extras.getString("nama"));

        TextView tv_hrgaawal = (TextView) findViewById(R.id.liathargaawal);
        tv_hrgaawal.setText(extras.getString("hargaawal"));
        Log.i("id produk ", String.valueOf(extras.getString("id")));
        List<Item> items = handler.getProdukDetailByProdukId(String.valueOf(extras.getString("id")));
        lvItem = (ListView) findViewById(R.id.lv_item_liat);

        adapter = new ListItemLiat(viewProduk.this, items, "0");
        lvItem.setAdapter(adapter);







    }
}

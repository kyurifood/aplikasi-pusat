package pusat.android.makananbekuenak.com.aplikasi_pusat;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import pusat.android.makananbekuenak.com.aplikasi_pusat.service.ProdukHandler;

/**
 * Created by fikran on 02/05/16.
 */
public class viewProduk extends AppCompatActivity {

   private ProdukHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_produk);

        Bundle extras = getIntent().getExtras();

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



        Button btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                finish();
                Intent intent = new Intent(viewProduk.this, DaftarProduk.class);
                startActivity(intent);
            }
        });

    }
}

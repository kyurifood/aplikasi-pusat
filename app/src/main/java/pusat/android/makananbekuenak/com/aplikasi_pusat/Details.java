package pusat.android.makananbekuenak.com.aplikasi_pusat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import pusat.android.makananbekuenak.com.aplikasi_pusat.domain.Item_Pesanan;

/**
 * Created by gilang on 29/04/16.
 */
public class Details extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lihat_detail_tmpl);

        final Item_Pesanan item = new Item_Pesanan();

        getSupportActionBar().setTitle("Details Order");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        TextView no = (TextView) findViewById(R.id.no_order);
//        TextView tanggal = (TextView) findViewById(R.id.tanggal_pesan);
//        TextView nm_penerima = (TextView) findViewById(R.id.nama_penerima);
        TextView bank = (TextView) findViewById(R.id.bank);


        no.setText(item.getNo_order());
//        tanggal.setText(item.getTanggal_pesan());
//        nm_penerima.setText(item.getNama());
        bank.setText(item.getBank());
    }
}

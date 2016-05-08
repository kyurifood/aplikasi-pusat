package pusat.android.makananbekuenak.com.aplikasi_pusat.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pusat.android.makananbekuenak.com.aplikasi_pusat.R;
import pusat.android.makananbekuenak.com.aplikasi_pusat.adapter.ListItemDaftarBelanja;
import pusat.android.makananbekuenak.com.aplikasi_pusat.domain.Item_lihat_detail;

/**
 * Created by rinaldy on 25/04/16.
 */

public class Lihatdetail extends AppCompatActivity {

    String get_nama, get_bank, get_kode, get_tanggal, get_nominal, get_regional, get_distributor, get_marketer,
            get_costomer, get_nohp, get_alamatpenerima, get_produk, get_ongkir, get_pajak;

    private List<Item_lihat_detail> lihat_details;
    ListView lvItem;
    ListItemDaftarBelanja adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lihat_detail_tmpl);

        getSupportActionBar().setTitle("Details Order");

        TextView nama = (TextView) findViewById(R.id.nama_penerima);
        TextView bank = (TextView) findViewById(R.id.bank);
        TextView kode = (TextView) findViewById(R.id.no_order);
        TextView tanggal = (TextView) findViewById(R.id.tanggal_pesan);
        TextView nilai_transaksi = (TextView) findViewById(R.id.nilai_transaksi);
        TextView regional = (TextView) findViewById(R.id.regional);
        TextView distributor = (TextView) findViewById(R.id.distributor);
        TextView marketer = (TextView) findViewById(R.id.marketer);
        TextView customer = (TextView) findViewById(R.id.costumer);
        TextView nohp = (TextView) findViewById(R.id.hp_penerima);
        TextView alamat = (TextView) findViewById(R.id.alamat_penerima);
        TextView produk = (TextView) findViewById(R.id.produk);
        TextView ongkir = (TextView) findViewById(R.id.ongkir);
        TextView pajak = (TextView) findViewById(R.id.pajak);


        Bundle b = getIntent().getExtras();
        get_nama = b.getString("panggil_nama");
        get_bank = b.getString("panggil_bank");
        get_kode = b.getString("panggil_kode");
        get_tanggal = b.getString("panggil_tanggal");
        get_nominal = b.getString("panggil_nominal");
        get_regional = b.getString("panggil_regional");
        get_distributor = b.getString("panggil_distributor");
        get_marketer = b.getString("panggil_marketer");
        get_costomer = b.getString("panggil_customer");
        get_nohp = b.getString("panggil_nohp");
        get_alamatpenerima = b.getString("panggil_alamat");
        get_produk = b.getString("panggil_produk");
        get_ongkir = b.getString("panggil_ongkir");
        get_pajak = b.getString("panggil_pajak");
        nama.setText("" + get_nama);
        bank.setText("" + get_bank);
        kode.setText("" + get_kode);
        tanggal.setText("" + get_tanggal);
        nilai_transaksi.setText("" + get_nominal);
        regional.setText(""+get_regional);
        distributor.setText(""+get_distributor);
        marketer.setText(""+get_marketer);
        customer.setText(""+get_costomer);
        nohp.setText(""+get_nohp);
        alamat.setText(""+get_alamatpenerima);
        produk.setText(""+get_produk);
        ongkir.setText(""+get_ongkir);
        pajak.setText(""+get_pajak);




        List<Item_lihat_detail> items = new ArrayList<>();
        Item_lihat_detail daftar1 = new Item_lihat_detail();
        daftar1.setTipe_produk("KRP.001-KARAPAU");
        daftar1.setHarga("25.000");
        daftar1.setQuantiti("2");
        daftar1.setTotal_list("50.000");

        Item_lihat_detail daftar2 = new Item_lihat_detail();
        daftar2.setTipe_produk("KRP.002-KARAPAU-A4");
        daftar2.setHarga("30.000");
        daftar2.setQuantiti("4");
        daftar2.setTotal_list("120.000");

        Item_lihat_detail daftar3 = new Item_lihat_detail();
        daftar3.setTipe_produk("KRP.003-KARAPAU-A6");
        daftar3.setHarga("35.000");
        daftar3.setQuantiti("2");
        daftar3.setTotal_list("70.000");

        items.add(daftar1);
        items.add(daftar2);
        items.add(daftar3);


        lvItem = (ListView) findViewById(R.id.lv_detail);

        ViewGroup.LayoutParams listViewParams = (ViewGroup.LayoutParams)

                lvItem.getLayoutParams();
        listViewParams.height = 360;
        listViewParams.width = 630;
        lvItem.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        lvItem.requestLayout();

        adapter = new ListItemDaftarBelanja(Lihatdetail.this, items);
        lvItem.setAdapter(adapter);
    }

}

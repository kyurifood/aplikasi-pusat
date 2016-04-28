package pusat.android.makananbekuenak.com.aplikasi_pusat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import pusat.android.makananbekuenak.com.aplikasi_pusat.R;
import pusat.android.makananbekuenak.com.aplikasi_pusat.domain.Item_lihat_detail;

/**
 * Created by rinaldy on 29/04/16.
 */
public class LihatDetailAdapter extends BaseAdapter {



    public Context context;

//    private List<ListBarang> barangList;
    private List<Item_lihat_detail> lihat_details;


    public LihatDetailAdapter(Context context, List<Item_lihat_detail> lihat_details){
        this.context = context;
        this.lihat_details = lihat_details;


    }

    @Override
    public int getCount() {
        return lihat_details.size();
    }

    @Override
    public Item_lihat_detail getItem(int position) {
        return lihat_details.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.lihat_detail, parent, false);

        final Item_lihat_detail item = lihat_details.get(position);

        TextView no_order =(TextView)convertView.findViewById(R.id.no_order);
        TextView tanggal_pesan =(TextView)convertView.findViewById(R.id.tanggal_pesan);
        TextView regional =(TextView)convertView.findViewById(R.id.regional);
        TextView distributor =(TextView)convertView.findViewById(R.id.distributor);
        TextView marketer =(TextView)convertView.findViewById(R.id.marketer);
        TextView costumer =(TextView)convertView.findViewById(R.id.costumer);
        TextView nama_penerima =(TextView)convertView.findViewById(R.id.nama_penerima);
        TextView hp_penerima =(TextView)convertView.findViewById(R.id.hp_penerima);
        TextView alamat_penerima =(TextView)convertView.findViewById(R.id.alamat_penerima);
        TextView bank =(TextView)convertView.findViewById(R.id.bank);
        TextView nilai_transaksi =(TextView)convertView.findViewById(R.id.nilai_transaksi);
        TextView produk =(TextView)convertView.findViewById(R.id.produk);
        TextView ongkir =(TextView)convertView.findViewById(R.id.ongkir);
        TextView pajak =(TextView)convertView.findViewById(R.id.pajak);
        TextView total =(TextView)convertView.findViewById(R.id.total);

//        bank.setText(item.getBank());
        no_order.setText(item.getNo_order());
        tanggal_pesan.setText(item.getTanggal());
        regional.setText(item.getRegional());
        distributor.setText(item.getDistributor());
        marketer.setText(item.getMarketer());
        costumer.setText(item.getCustomer());
        nama_penerima.setText(item.getNama_penerima());
        hp_penerima.setText(item.getNo_hp_penerima());
        alamat_penerima.setText(item.getAlamat_penerima());
        bank.setText(item.getBank());
        nilai_transaksi.setText(item.getNilai_transaksi());
        produk.setText(item.getProduk());
        ongkir.setText(item.getOngkir());
        pajak.setText(item.getPajak());
        total.setText(item.getPajak());

        return convertView;
    }
}
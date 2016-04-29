package pusat.android.makananbekuenak.com.aplikasi_pusat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import pusat.android.makananbekuenak.com.aplikasi_pusat.R;
import pusat.android.makananbekuenak.com.aplikasi_pusat.domain.Item_lihat_detail;

/**
 * Created by rinaldy on 29/04/16.
 */
public class ListItemDaftarBelanja extends BaseAdapter {
    private Context context;
    private List<Item_lihat_detail> items;


    public ListItemDaftarBelanja(Context context, List<Item_lihat_detail> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        if(items == null)
            return -1;
        else
            return items.size();
    }

    @Override
    public Item_lihat_detail getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent ) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.daftar_belanja_lihat_detail, parent, false);

        final Item_lihat_detail item = items.get(position);

        TextView jenis = (TextView)convertView.findViewById(R.id.jenis);
        TextView harga = (TextView)convertView.findViewById(R.id.harga_daftar);
        TextView quantiti = (TextView)convertView.findViewById(R.id.quantity_daftar);
        TextView total = (TextView)convertView.findViewById(R.id.total_daftar);

        jenis.setText(item.getTipe_produk());
        harga.setText(item.getHarga());
        quantiti.setText(item.getQuantiti());
        total.setText(item.getTotal_list());

        Item_lihat_detail daftar1 = new Item_lihat_detail();
        daftar1.setTipe_produk("KRP.001-KARAPAU");
        daftar1.setHarga("25.000");
        daftar1.setQuantiti("2");
        daftar1.setTotal_list("50.000");

        Item_lihat_detail daftar2 = new Item_lihat_detail();
        daftar2.setTipe_produk("KRP.002-KARAPAU-A4");
        daftar2.setHarga("30.000");
        daftar2.setQuantiti("4");



        return convertView;
    }
}

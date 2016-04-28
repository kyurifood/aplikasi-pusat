package pusat.android.makananbekuenak.com.aplikasi_pusat.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import pusat.android.makananbekuenak.com.aplikasi_pusat.Laporan;
import pusat.android.makananbekuenak.com.aplikasi_pusat.Lihatdetail;
import pusat.android.makananbekuenak.com.aplikasi_pusat.LoginActivity;
import pusat.android.makananbekuenak.com.aplikasi_pusat.MainActivity;
import pusat.android.makananbekuenak.com.aplikasi_pusat.R;
import pusat.android.makananbekuenak.com.aplikasi_pusat.domain.Item_Pesanan;

/**
 * Created by opaw on 3/30/16.
 */
public class ListItemAdapter extends BaseAdapter {
    public Context context;
    private List<Item_Pesanan> items;

    public ListItemAdapter(Context context, List<Item_Pesanan> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Item_Pesanan getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_layout_pesanan, parent, false);

        final Item_Pesanan item = items.get(position);

        TextView no_order = (TextView) convertView.findViewById(R.id.no_order);
        TextView tanggal_pesan = (TextView) convertView.findViewById(R.id.tgl_pesan);
        TextView nama = (TextView) convertView.findViewById(R.id.nama);
        TextView bank = (TextView) convertView.findViewById(R.id.bank);
        TextView nominal = (TextView) convertView.findViewById(R.id.nominal);


        Button btnAction1 = (Button) convertView.findViewById(R.id.btn_action_1);
        Button btnAction2 = (Button) convertView.findViewById(R.id.btn_action_2);
        CheckBox baru = (CheckBox) convertView.findViewById(R.id.cb_baru);
        final CheckBox lunas = (CheckBox) convertView.findViewById(R.id.cb_lunas);

        lunas.setChecked(item.isLunas()== true);
        no_order.setText(item.getNo_order());
        tanggal_pesan.setText(item.getTanggal_pesan());
        nama.setText(item.getNama());
        bank.setText(item.getBank());
        nominal.setText(item.getNominal());

        //btnAction2.setClickable(item.isButton2());

        btnAction1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD

                Toast.makeText(context, item.getNo_order(), Toast.LENGTH_SHORT).show();
=======
                lunas.setChecked(true);
                Toast.makeText(context, item.getNo_order() + ", Lunas", Toast.LENGTH_SHORT).show();
>>>>>>> 6787e3b41ac6c6b60a1b3700d27423f4b9200592
            }
        });

        btnAction2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((MainActivity) context).lihatdetails();
            }
        });

        return convertView;
    }



    public void unselectAllItems(){
        for (int i = 0; i < items.size(); i++){
            Item_Pesanan item = items.get(i);
            item.setSelected(false);
        }
    }


}

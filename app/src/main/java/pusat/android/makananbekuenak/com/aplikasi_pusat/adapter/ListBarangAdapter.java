package pusat.android.makananbekuenak.com.aplikasi_pusat.adapter;

import android.content.Context;
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

import pusat.android.makananbekuenak.com.aplikasi_pusat.R;
import pusat.android.makananbekuenak.com.aplikasi_pusat.domain.ListBarang;

/**
 * Created by id-oz on 3/28/16.
 */
public class ListBarangAdapter extends BaseAdapter {

    public Context context;
    private List<ListBarang> barangList;


    public ListBarangAdapter(Context context, List<ListBarang> barangList){
        this.context = context;
        this.barangList = barangList;


    }

    @Override
    public int getCount() {
        return barangList.size();
    }

    @Override
    public ListBarang getItem(int position) {
        return barangList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.list_barang_layout, parent, false);

        TextView namaproduk = (TextView) convertView.findViewById(R.id.nama_produk);

        TextView lblItemBaru = (TextView) convertView.findViewById(R.id.item_baru);
        TextView lblItemLunas = (TextView) convertView.findViewById(R.id.item_lunas);
        TextView lblItemdiKirim = (TextView) convertView.findViewById(R.id.item_dikirim);
        TextView lblItemdiTerima = (TextView) convertView.findViewById(R.id.item_diterima);
        CheckBox cbBarangcheck1 = (CheckBox) convertView.findViewById(R.id.item_check1);
        CheckBox cbBarangcheck2 = (CheckBox) convertView.findViewById(R.id.item_check2);
        CheckBox cbBarangcheck3 = (CheckBox) convertView.findViewById(R.id.item_check3);
        CheckBox cbBarangcheck4 = (CheckBox) convertView.findViewById(R.id.item_check4);

        Button profil = (Button) convertView.findViewById(R.id.profil);
        final Button pop = (Button) convertView.findViewById(R.id.btn_pop);

        final ListBarang barang = getItem(position);

        namaproduk.setText(barang.getNama_produk());
        lblItemBaru.setText(barang.getBaru());
        lblItemLunas.setText(barang.getLunas());
        lblItemdiKirim.setText(barang.getDikirim());
        lblItemdiTerima.setText(barang.getDiterima());
        cbBarangcheck1.setChecked(barang.isCheck1());
        cbBarangcheck2.setChecked(barang.isCheck2());
        cbBarangcheck3.setChecked(barang.isCheck3());
        cbBarangcheck4.setChecked(barang.isCheck4());

        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, barang.getNama_produk(), Toast.LENGTH_SHORT).show();
            }


        });


        //opsi menu
        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                PopupMenu popup = new PopupMenu(context, pop);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.satu:
                                Toast.makeText(context, item.getTitle(), Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.dua:
                                Toast.makeText(context, item.getTitle(), Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                Toast.makeText(context, item.getTitle(), Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });

                popup.show();
            }
        });
        //batas opsi menu

        return convertView;
    }
}

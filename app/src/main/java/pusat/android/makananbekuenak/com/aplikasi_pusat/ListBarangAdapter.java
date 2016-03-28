package pusat.android.makananbekuenak.com.aplikasi_pusat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by id-oz on 3/28/16.
 */
public class ListBarangAdapter extends BaseAdapter {

    private Context context;
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

        TextView lblItemBaru = (TextView) convertView.findViewById(R.id.item_baru);
        TextView lblItemLunas = (TextView) convertView.findViewById(R.id.item_lunas);
        TextView lblItemdiKirim = (TextView) convertView.findViewById(R.id.item_dikirim);
        TextView lblItemdiTerima = (TextView) convertView.findViewById(R.id.item_diterima);
        CheckBox cbBarangcheck1 = (CheckBox) convertView.findViewById(R.id.item_check1);
        CheckBox cbBarangcheck2 = (CheckBox) convertView.findViewById(R.id.item_check2);
        CheckBox cbBarangcheck3 = (CheckBox) convertView.findViewById(R.id.item_check3);
        CheckBox cbBarangcheck4 = (CheckBox) convertView.findViewById(R.id.item_check4);

        ListBarang barang = getItem(position);

        lblItemBaru.setText(barang.getBaru());
        lblItemLunas.setText(barang.getLunas());
        lblItemdiKirim.setText(barang.getDikirim());
        lblItemdiTerima.setText(barang.getDiterima());
        cbBarangcheck1.setChecked(barang.isCheck1());
        cbBarangcheck2.setChecked(barang.isCheck2());
        cbBarangcheck3.setChecked(barang.isCheck3());
        cbBarangcheck4.setChecked(barang.isCheck4());

        return convertView;
    }
}

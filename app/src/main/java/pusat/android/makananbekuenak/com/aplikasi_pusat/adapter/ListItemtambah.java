package pusat.android.makananbekuenak.com.aplikasi_pusat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import pusat.android.makananbekuenak.com.aplikasi_pusat.R;
import pusat.android.makananbekuenak.com.aplikasi_pusat.domain.ItemProduk;

/**
 * Created by fikran on 25/04/16.
 */
public class ListItemtambah extends BaseAdapter {
    private Context context;
    private List<ItemProduk> items;



    public ListItemtambah(Context context, List<ItemProduk> items) {

        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public ItemProduk getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.list_produk, parent, false);

        final ItemProduk item = items.get(position);

        TextView itemkode = (TextView) convertView.findViewById(R.id.item_kode);
        TextView itemnama = (TextView) convertView.findViewById(R.id.item_nama);

        itemkode.setText(item.getKode());
        itemnama.setText(item.getNama());

        return convertView;
    }
    public void tambahItem(ItemProduk item){
        items.add(item);
        notifyDataSetChanged();
    }
}

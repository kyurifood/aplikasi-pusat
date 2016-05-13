package pusat.android.makananbekuenak.com.aplikasi_pusat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import pusat.android.makananbekuenak.com.aplikasi_pusat.R;
import pusat.android.makananbekuenak.com.aplikasi_pusat.domain.Item;

/**
 * Created by fikran on 13/05/16.
 */
public class ListItemLiat extends BaseAdapter {
    private Context context;
    private List<Item> items;
    private String flag;


    public ListItemLiat(Context context, List<Item> items, String flag) {
        this.context = context;
        this.flag = flag;
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
    public Item getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent ) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.view_produk_list, parent, false);

        final Item item = items.get(position);

        TextView regional = (TextView)convertView.findViewById(R.id.list_item_regional_liat);
        TextView harga = (TextView)convertView.findViewById(R.id.list_item_harga_liat);

        regional.setText(item.getRegional());
        harga.setText(item.getHarga());



        return convertView;
    }



}

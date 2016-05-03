package pusat.android.makananbekuenak.com.aplikasi_pusat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import pusat.android.makananbekuenak.com.aplikasi_pusat.Produk;
import pusat.android.makananbekuenak.com.aplikasi_pusat.R;
import pusat.android.makananbekuenak.com.aplikasi_pusat.domain.Item;

/**
 * Created by fikran on 20/04/16.
 */
public class ListItem extends BaseAdapter {
    private Context context;
    private List<Item> items;


    public ListItem(Context context, List<Item> items) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_produk, parent, false);

        final Item item = items.get(position);

        TextView regional = (TextView)convertView.findViewById(R.id.list_item_regional);
        TextView harga = (TextView)convertView.findViewById(R.id.list_item_harga);

        regional.setText(item.getRegional());
        harga.setText(item.getHarga());

        final Button delete = (Button)convertView.findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                deleteItem(position);
                Toast.makeText(context,"Regional " + item.getRegional() + " Berhasil Dihapus", Toast.LENGTH_SHORT).show();
            }
        });

        Button edit = (Button) convertView.findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Produk) context).showEditDialog(position, item);
            }
        });

        return convertView;
    }

    public void addItem(Item item){
        items.add(item);
        notifyDataSetChanged();
    }

    public void deleteItem(int position){
        items.remove(position);
        notifyDataSetChanged();
    }
    public void editItem(int position, Item item){
        items.set(position, item);
        notifyDataSetChanged();
    }

}

package pusat.android.makananbekuenak.com.aplikasi_pusat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import pusat.android.makananbekuenak.com.aplikasi_pusat.R;

/**
 * Created by fikran on 21/04/16.
 */
public class ListItemproduk extends BaseAdapter {
/*
    private Context context;
    private List<ItemProduk> items;



    public ListItemproduk(Context context, List<ItemProduk> items) {

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

*/


    Context context;
    String[] itemkode;
    String[] itemnama;
    int[] flag;
    LayoutInflater inflater;

    public ListItemproduk(Context context, String[] itemkode, String[] itemnama, int[] flag) {
        this.context = context;
        this.itemkode = itemkode;
        this.itemnama = itemnama;
        this.flag = flag;

    }

    @Override
    public int getCount() {
        return itemkode.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // Declare Variables
        TextView txtkode;
        TextView txtnama;
        ImageView imgflag;


        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.list_produk, parent, false);

        // Locate the TextViews in listview_item.xml
        txtkode = (TextView) itemView.findViewById(R.id.item_kode);
        txtnama= (TextView) itemView.findViewById(R.id.item_nama);
        imgflag = (ImageView) itemView.findViewById(R.id.flag);


        // Capture position and set to the TextViews
        txtkode.setText(itemkode[position]);
        txtnama.setText(itemnama[position]);
        // Capture position and set to the ImageView
        imgflag.setImageResource(flag[position]);

        return itemView;
    }


}

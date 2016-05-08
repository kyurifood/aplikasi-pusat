package pusat.android.makananbekuenak.com.aplikasi_pusat.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pusat.android.makananbekuenak.com.aplikasi_pusat.R;
import pusat.android.makananbekuenak.com.aplikasi_pusat.domain.ItemProduk;

/**
 * Created by fikran on 21/04/16.
 */
public class ListItemproduk extends BaseAdapter {

    private List<ItemProduk> items;
    private Context context;
    private LayoutInflater inflater;
    public ListItemproduk(Context _context, List<ItemProduk> _items){
        inflater = LayoutInflater.from(_context);
        this.items = _items;
        this.context = _context;

    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemProduk produk = items.get(position);

        View view = convertView;

        if(view == null)
            view = inflater.inflate(R.layout.list_produk, null);


        TextView kode = (TextView) view.findViewById(R.id.item_kode);
        TextView nama = (TextView) view.findViewById(R.id.item_nama);

        ImageView flag = (ImageView) view.findViewById(R.id.flag);

        kode.setText(produk.getKode());
        nama.setText(produk.getNama());
        if(produk.getImage().isEmpty())
            flag.setImageResource(R.drawable.poot);
        else
            flag.setImageBitmap(BitmapFactory.decodeFile(produk.getImage()));


        return view;
    }
    }

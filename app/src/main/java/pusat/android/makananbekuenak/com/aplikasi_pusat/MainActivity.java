package pusat.android.makananbekuenak.com.aplikasi_pusat;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import pusat.android.makananbekuenak.com.aplikasi_pusat.adapter.ListItemAdapter;
import pusat.android.makananbekuenak.com.aplikasi_pusat.domain.Item_Pesanan;

public class MainActivity extends AppCompatActivity {

    ListView lvItem;
    ListItemAdapter adapter;
    Button btnAction2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD


=======
        getSupportActionBar().setTitle("PESANAN");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.bar_ic_action_add_shopping_cart);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
>>>>>>> 6787e3b41ac6c6b60a1b3700d27423f4b9200592

        List<Item_Pesanan> items = new ArrayList<>();
        Item_Pesanan item1 = new Item_Pesanan();
        item1.setNo_order("001");
        item1.setTanggal_pesan("15-04-2016");
        item1.setNama("Reksin Lewo");
        item1.setBank("Mandiri");
        item1.setNominal("20000");


        Item_Pesanan item2 = new Item_Pesanan();
        item2.setNo_order("002");
        item2.setTanggal_pesan("15-05-2016");
        item2.setNama("Alfandi");
        item2.setBank("Mandiri");
        item2.setNominal("26000");

        Item_Pesanan item3 = new Item_Pesanan();
        item3.setNo_order("003");
        item3.setTanggal_pesan("15-05-2016");
        item3.setNama("Angki Nusi");
        item3.setBank("Mandiri");
        item3.setNominal("32000");

        items.add(item1);
        items.add(item2);
        items.add(item3);


        lvItem = (ListView) findViewById(R.id.lv_item);
        adapter = new ListItemAdapter(MainActivity.this, items);

        lvItem.setAdapter(adapter);
        lvItem.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                Item_Pesanan item = (Item_Pesanan) lvItem.getAdapter().getItem(position);
                item.setSelected(checked);
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.menu_list_item, menu);
                mode.setTitle("Select Items");
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_submit:
                        StringBuilder sb = new StringBuilder();
                        for(int i = 0; i < lvItem.getAdapter().getCount(); i++){
                            Item_Pesanan x = (Item_Pesanan) lvItem.getAdapter().getItem(i);
                            if(x.isSelected()){
                                sb.append(x.getNo_order());
                                sb.append(", ");
                                x.setLunas(true);
                            }

                        }

                        String text = sb.toString();
                        text = text.substring(0, text.length() - 2);
                        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                        mode.finish();
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Clicked " + item.getTitle(),
                                Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                adapter.unselectAllItems();
            }
        });
    }

    public void lihatdetails (){
        Intent yerin = new Intent(this, pusat.android.makananbekuenak.com.aplikasi_pusat.Lihatdetail.class);
        startActivity(yerin);
    }

}

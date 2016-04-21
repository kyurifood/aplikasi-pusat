package pusat.android.makananbekuenak.com.aplikasi_pusat;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import pusat.android.makananbekuenak.com.aplikasi_pusat.adapter.ListItem;
import pusat.android.makananbekuenak.com.aplikasi_pusat.domain.Item;

public class Produk extends AppCompatActivity {
    private static final int PICK_FROM_CAMERA = 1;
    private static final int PICK_FROM_GALLERY = 2;
    ImageView imgview;
    ListView lvItem;
    ListItem adapter;

    private Spinner spinnerregional;

    AlertDialog.Builder addNewItemDialogBuilder = null;
    AlertDialog addNewItemDialog = null;
    View promptsView;
    EditText txtharga;
    List<Item> items = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.produk);

        imgview = (ImageView) findViewById(R.id.foto);
        Button buttonGallery = (Button) findViewById(R.id.button);
        Button addNewItem = (Button) findViewById(R.id.tambahharga);
        Spinner mSpinner= (Spinner)findViewById(R.id.spinnerregional);
        lvItem = (ListView) findViewById(R.id.lv_item);
        ViewGroup.LayoutParams listViewParams = (ViewGroup.LayoutParams) lvItem.getLayoutParams();
        listViewParams.height = 835;
        lvItem.requestLayout();

        lvItem.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });


        addNewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddDialog();
            }
        });

        buttonGallery.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
// call android default gallery
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
// ******** code for crop image
                intent.putExtra("crop", "true");
                intent.putExtra("aspectX", 0);
                intent.putExtra("aspectY", 0);
                intent.putExtra("outputX", 200);
                intent.putExtra("outputY", 150);

                try {

                    intent.putExtra("return-data", true);
                    startActivityForResult(Intent.createChooser(intent,
                            "Complete action using"), PICK_FROM_GALLERY);

                } catch (ActivityNotFoundException e) {
// Do nothing for now
                }
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == PICK_FROM_CAMERA) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                Bitmap photo = extras.getParcelable("data");
                imgview.setImageBitmap(photo);

            }
        }

        if (requestCode == PICK_FROM_GALLERY) {
            Bundle extras2 = data.getExtras();
            if (extras2 != null) {
                Bitmap photo = extras2.getParcelable("data");
                imgview.setImageBitmap(photo);

            }
        }



    }


    public void showAddDialog() {
        if (addNewItemDialogBuilder == null) {
            addNewItemDialogBuilder = new AlertDialog.Builder(Produk.this);
        }

        promptsView = LayoutInflater.from(Produk.this).inflate(R.layout.hargarigional, null);

        final Spinner mSpinner= (Spinner) promptsView.findViewById(R.id.spinnerregional);
        txtharga = (EditText) promptsView.findViewById(R.id.harga);
        spinnerregional = (Spinner) promptsView.findViewById(R.id.spinnerregional);

        mSpinner.setOnItemSelectedListener(new OnSpinnerItemClicked());


        Button save = (Button) promptsView.findViewById(R.id.ok);
        save.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                if (!hasError()) {
                    Item item = new Item();
                    String s = (String) (spinnerregional.getSelectedItem());
                    item.setRegional(s);
                    item.setHarga(txtharga.getText().toString());


                    if (adapter == null) {
                        items.add(item);
                        adapter = new ListItem(Produk.this, items);
                        lvItem.setAdapter(adapter);
                    } else {
                        adapter.addItem(item);
                    }
                    addNewItemDialog.dismiss();
                }
            }
        });

        Button cancel = (Button) promptsView.findViewById(R.id.kembali);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewItemDialog.dismiss();
            }
        });



        addNewItemDialogBuilder.setView(promptsView);
        addNewItemDialogBuilder.setCancelable(false);
        addNewItemDialog = addNewItemDialogBuilder.create();
        addNewItemDialog.show();
    }

    private boolean hasError(){
        boolean isError = false;
        if(TextUtils.isEmpty(txtharga.getText().toString())){
            isError = true;
            txtharga.setError("This field is required");
        }

        return isError;
    }

    public class OnSpinnerItemClicked implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

        }


        public void onNothingSelected(AdapterView parent) {
            // Do nothing.


        }
    }


}
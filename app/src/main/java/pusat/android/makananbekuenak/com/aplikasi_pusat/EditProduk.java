package pusat.android.makananbekuenak.com.aplikasi_pusat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pusat.android.makananbekuenak.com.aplikasi_pusat.adapter.ListItem;
import pusat.android.makananbekuenak.com.aplikasi_pusat.domain.Item;

/**
 * Created by fikran on 23/04/16.
 */
public class EditProduk extends AppCompatActivity {
    private static final int SELECT_PHOTO = 100;
    ImageView imgview;
    ListView lvItem;
    ListItem adapter;

    private Spinner spinnerregional;

    AlertDialog.Builder addNewItemDialogBuilder = null;
    AlertDialog addNewItemDialog = null;
    View promptsView;

    List<Item> items = new ArrayList<>();

    EditText txtkode, txtnama, txtharga,txthargaawal;





    String[] isikode;
    String[] isinama;

    int[] flag;
    int position;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.produk);



        // Locate the TextViews in singleitemview.xml


        txtkode = (EditText) findViewById(R.id.kode);
        txtnama = (EditText) findViewById(R.id.nama);
        txthargaawal = (EditText) findViewById(R.id.hargaawal);

        // Locate the ImageView in singleitemview.xml
        imgview = (ImageView) findViewById(R.id.foto);



        Button addNewItem = (Button) findViewById(R.id.tambahharga);
        Spinner mSpinner= (Spinner)findViewById(R.id.spinnerregional);


        lvItem = (ListView) findViewById(R.id.lv_item);
        ViewGroup.LayoutParams listViewParams = (ViewGroup.LayoutParams) lvItem.getLayoutParams();
        listViewParams.height = 380;
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

        imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, SELECT_PHOTO);
            }
        });

             // Retrieve data from MainActivity on listview item click
       Intent i = getIntent();
        // Get a single position
        position = i.getExtras().getInt("position");
        // Get the list of rank
        isikode = i.getStringArrayExtra("itemkode");
        // Get the list of country
        isinama = i.getStringArrayExtra("itemnama");
        // Get the list of flag
        flag = i.getIntArrayExtra("flag");

        // Load the text into the TextViews followed by the position
        txtkode.setText(isikode[position]);
        txtnama.setText(isinama[position]);


        // Load the image into the ImageView followed by the position
        imgview.setImageResource(flag[position]);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case SELECT_PHOTO:
                if(resultCode == RESULT_OK){
                    android.net.Uri selectedImage = data.getData();
                    java.io.InputStream imageStream = null;
                    try {
                        imageStream = getContentResolver().openInputStream(selectedImage);
                    } catch (java.io.FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    Bitmap yourSelectedImage = android.graphics.BitmapFactory.decodeStream(imageStream);
                    imgview.setImageBitmap(yourSelectedImage);
                }
        }
    }

    public void showAddDialog() {

        if (addNewItemDialogBuilder == null) {
            addNewItemDialogBuilder = new AlertDialog.Builder(EditProduk.this);
        }

        promptsView = LayoutInflater.from(EditProduk.this).inflate(R.layout.hargarigional, null);

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
                        adapter = new ListItem(EditProduk.this, items);
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

    public void showEditDialog(final int position, Item item) {
        if (addNewItemDialogBuilder == null) {
            addNewItemDialogBuilder = new AlertDialog.Builder(EditProduk.this);
        }

        promptsView = LayoutInflater.from(EditProduk.this).inflate(R.layout.hargarigional, null);

        Spinner mSpinner= (Spinner) promptsView.findViewById(R.id.spinnerregional);


        txtharga = (EditText) promptsView.findViewById(R.id.harga);
        txtharga.setText(item.getHarga());
        spinnerregional = (Spinner) promptsView.findViewById(R.id.spinnerregional);
        String s = (String)(spinnerregional.getSelectedItem());
        item.setRegional(s);

        mSpinner.setOnItemSelectedListener(new OnSpinnerItemClicked());


        Button save = (Button) promptsView.findViewById(R.id.ok);
        save.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
                if (!hasError()) {
                    Item newitem = new Item();
                    String s = (String)(spinnerregional.getSelectedItem());
                    newitem.setRegional(s);
                    newitem.setHarga(txtharga.getText().toString());


                    adapter.editItem(position, newitem);
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






    private void submitForm() {
        // Submit your form here. your form is valid
        Toast.makeText(EditProduk.this, "Data Diedit", Toast.LENGTH_SHORT).show();

        panggilclass();
    }




    //    public boolean validasiCPass(String cpass) {
//        return cpass.length() > 0;
//    }
    public boolean validateKode(String kode) {
        return kode.length() > 0;
    }
    public boolean validateNama(String nama) {
        return nama.length() > 0;
    }
    public boolean validatehargaawal(String hargaawal) {
        return hargaawal.length() > 0;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_produk, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.simpan) {





            //String cpass = txtcpas.getText().toString();
            String kode = txtkode.getText().toString();
            String nama = txtnama.getText().toString();
            String hargawal = txthargaawal.getText().toString();



            if (!validateKode(kode)) {
                txtkode.setError("silahkan masukan kode");
                {

                    Toast.makeText(EditProduk.this, "Kesalahan dalam pengisian kode", Toast.LENGTH_SHORT).show();
                }
            } else if (!validateNama(nama)) {
                txtnama.setError("silahkan masukan nama anda");
                {
                    Toast.makeText(EditProduk.this, "Kesalahan dalam pengisian nama", Toast.LENGTH_SHORT).show();
                }
            } else if (!validatehargaawal(hargawal)) {
                txthargaawal.setError("silahkan masukan Harga awal");
                {
                    Toast.makeText(EditProduk.this, "Kesalahan dalam Harga Awal", Toast.LENGTH_SHORT).show();
                }


            }
            else submitForm();

            return true;

        }

        return super.onOptionsItemSelected(item);
    }
    public void panggilclass (){
        Intent panggil = new Intent(getApplicationContext(), DaftarProduk.class);
        startActivity(panggil);
    }





}
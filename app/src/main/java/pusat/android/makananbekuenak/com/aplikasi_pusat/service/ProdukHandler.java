package pusat.android.makananbekuenak.com.aplikasi_pusat.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import pusat.android.makananbekuenak.com.aplikasi_pusat.domain.Item;
import pusat.android.makananbekuenak.com.aplikasi_pusat.domain.ItemProduk;

/**
 * Created by fikran on 02/05/16.
 */
public class ProdukHandler extends SQLiteOpenHelper {

    // All variables about DB
    // Database name
    private static final String DATABASE_NAME = "produkBook";

    // Database version
    private static final int DATABASE_VERSION = 1;

    // Contacts table name
    private static final String TABLE_PRODUK = "produk";
    private static final String TABLE_PRODUK_DETAIL = "produk_detail";
    // Table Column names
    private static final String COLUMN_ID = "id_produk";
    private static final String COLUMN_KODE = "kode";
    private static final String COLUMN_NAMA = "nama";
    private static final String COLUMN_HARGAAWAL = "hargaawal";
    private static final String COLUMN_IMAGE = "image";
    private static final String COLUMN_PRODUK_DETAIL_ID = "id_produk_detail";
    private static final String COLUMN_PRODUK_DETAIL_REGIONAL = "regional";
    private static final String COLUMN_PRODUK_DETAIL_HARGA = "harga";


    private String[] columns= {COLUMN_ID, COLUMN_KODE, COLUMN_NAMA, COLUMN_HARGAAWAL, COLUMN_IMAGE};
    private String[] columnsDetail= {COLUMN_PRODUK_DETAIL_ID, COLUMN_PRODUK_DETAIL_REGIONAL, COLUMN_PRODUK_DETAIL_HARGA};


    // Create database
    public ProdukHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    // Create table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_PRODUK + "("
                + COLUMN_ID + " TEXT PRIMARY KEY,"
                + COLUMN_KODE + " TEXT,"
                + COLUMN_NAMA + " TEXT,"
                + COLUMN_HARGAAWAL + " TEXT,"
                + COLUMN_IMAGE + " TEXT"
                + ")";
        db.execSQL(CREATE_TABLE);
        String CREATE_TABLE_DETAIL = "CREATE TABLE " + TABLE_PRODUK_DETAIL + "("
                + COLUMN_PRODUK_DETAIL_ID + " TEXT PRIMARY KEY,"
                + COLUMN_PRODUK_DETAIL_REGIONAL + " TEXT,"
                + COLUMN_PRODUK_DETAIL_HARGA + " TEXT,"
                + COLUMN_ID + " TEXT"
                + ")";
        db.execSQL(CREATE_TABLE_DETAIL);
    }

    // Drop table if older version exist
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUK);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUK_DETAIL);
        onCreate(db);
    }

	/*
	 * Handling Contact table using sql queries.
	 * */


    // Add Contact
    public boolean addProdukDetails(ItemProduk contact){
        // Get db writable
        SQLiteDatabase db = this.getWritableDatabase();

        // Get the values to insert
        ContentValues vals = new ContentValues();

        vals.put(COLUMN_ID, contact.getId());
        vals.put(COLUMN_KODE, contact.getKode());
        vals.put(COLUMN_NAMA, contact.getNama());
        vals.put(COLUMN_HARGAAWAL, contact.getHargaawal());
        vals.put(COLUMN_IMAGE, contact.getImage());

        // Insert values into table
        long i = db.insert(TABLE_PRODUK, null, vals);
        // Close database
        db.close();

        if(i != 0){
            return true;
        }else{
            return false;
        }
    }
    public boolean addProdukDetail(Item contact){
        // Get db writable
        SQLiteDatabase db = this.getWritableDatabase();

        // Get the values to insert
        ContentValues vals = new ContentValues();
        vals.put(COLUMN_PRODUK_DETAIL_ID, contact.getId());
        vals.put(COLUMN_PRODUK_DETAIL_REGIONAL, contact.getRegional());
        vals.put(COLUMN_PRODUK_DETAIL_HARGA, contact.getHarga());
        vals.put(COLUMN_ID, contact.getIdproduk());

        // Insert values into table
        long i = db.insert(TABLE_PRODUK_DETAIL, null, vals);
        // Close database
        db.close();

        if(i != 0){
            return true;
        }else{
            return false;
        }
    }


    // Reading all contacts
    public List<ItemProduk> readAllProduks(){
        // Get db writable
        SQLiteDatabase db = this.getWritableDatabase();

        // Define contacts list
        List<ItemProduk> produks = new ArrayList<ItemProduk>();

        Cursor cursor = db.query(TABLE_PRODUK, columns, null, null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            ItemProduk produk = new ItemProduk();
            produk.setId(cursor.getString(0));
            produk.setKode(cursor.getString(1));
            produk.setNama(cursor.getString(2));
            produk.setHargaawal(cursor.getString(3));
            produk.setImage(cursor.getString(4));

            produks.add(produk);
            cursor.moveToNext();
        }

        // Make sure to close the cursor
        cursor.close();
        return produks;
    }
    public List<Item> getProdukDetailByProdukId(String idProduk){
        // Get db writable
        Log.i("id produk ", idProduk);
        SQLiteDatabase db = this.getWritableDatabase();

        // Define contacts list
        List<Item> produks = new ArrayList<Item>();

        Cursor cursor = db.query(TABLE_PRODUK_DETAIL, columnsDetail, COLUMN_ID+"="+idProduk, null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Item produk = new Item();
            produk.setId(cursor.getString(cursor.getColumnIndex(COLUMN_PRODUK_DETAIL_ID)));
            produk.setRegional(cursor.getString(cursor.getColumnIndex(COLUMN_PRODUK_DETAIL_REGIONAL)));
            produk.setHarga(cursor.getString(cursor.getColumnIndex(COLUMN_PRODUK_DETAIL_HARGA)));
//            produk.setIdproduk(cursor.getString(cursor.getColumnIndex(COLUMN_ID)));
            produks.add(produk);
            cursor.moveToNext();
        }

        // Make sure to close the cursor
        cursor.close();
        return produks;
    }


    // Update contact contact
    public boolean editProduk(ItemProduk produk){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues vals = new ContentValues();
        vals.put(COLUMN_KODE, produk.getKode());
        vals.put(COLUMN_NAMA, produk.getNama());
        vals.put(COLUMN_HARGAAWAL, produk.getHargaawal());
        vals.put(COLUMN_IMAGE, produk.getImage());

        // updating row
        int i = db.update(TABLE_PRODUK, vals, COLUMN_ID + " = ?",  new String[] { String.valueOf(produk.getId()) });

        db.close();

        if(i != 0){
            return true;
        }else{
            return false;
        }

    }

    // Deleting contact
    public boolean deleteProduk(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        int i = db.delete(TABLE_PRODUK, COLUMN_ID + " = ?",  new String[] { String.valueOf(id) });

        db.close();

        if(i != 0){
            return true;
        }else{
            return false;
        }
    }

}
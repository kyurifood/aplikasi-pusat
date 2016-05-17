package pusat.android.makananbekuenak.com.aplikasi_pusat.ui;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import pusat.android.makananbekuenak.com.aplikasi_pusat.R;

public class DetailPengiriman extends Fragment {

    String get_nama, get_tgl, get_pengirim, get_resi;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View preview = inflater.inflate(R.layout.activity_detail_pengiriman, container, false);

        EditText nama = (EditText) preview.findViewById(R.id.penerima);
        EditText tgl = (EditText) preview.findViewById(R.id.tgl_penerima);
        EditText pengirim = (EditText) preview.findViewById(R.id.pengiriman);
        EditText noresi = (EditText) preview.findViewById(R.id.no_resi);

        Bundle bb = getActivity().getIntent().getExtras();

        get_nama = bb.getString("panggil_nama");
        get_tgl = bb.getString("panggil_tgl");
        get_pengirim = bb.getString("panggil_pengirim");
        get_resi = bb.getString("panggil_resi");

        nama.setText("" + get_nama);
        tgl.setText("" + get_tgl);
        noresi.setText("" + get_resi);
        pengirim.setText("" + get_pengirim);

        return preview;
    }
}

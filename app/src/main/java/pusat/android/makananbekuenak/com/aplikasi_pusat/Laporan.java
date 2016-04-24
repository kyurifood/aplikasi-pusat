package pusat.android.makananbekuenak.com.aplikasi_pusat;




import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import pusat.android.makananbekuenak.com.aplikasi_pusat.adapter.ListBarangAdapter;
import pusat.android.makananbekuenak.com.aplikasi_pusat.domain.ListBarang;


public class Laporan extends AppCompatActivity {

    private Button btn_prdk, btn_mrktr, btn_dstrbtr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laporan);


        btn_prdk = (Button) findViewById(R.id.btn_produk);


        btn_prdk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Produk.class);
                startActivity(intent);
            }
        });

        btn_mrktr = (Button) findViewById(R.id.btn_marketer);

        btn_mrktr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Marketer.class);
                startActivity(intent);
            }
        });

        btn_dstrbtr = (Button) findViewById(R.id.btn_distributor);

        btn_dstrbtr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Distributor.class);
                startActivity(intent);
            }
        });

    }

}
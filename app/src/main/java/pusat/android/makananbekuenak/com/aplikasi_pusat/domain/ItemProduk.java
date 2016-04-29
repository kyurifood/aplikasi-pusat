package pusat.android.makananbekuenak.com.aplikasi_pusat.domain;

/**
 * Created by fikran on 21/04/16.
 */
public class ItemProduk {

    private String kode;
    private String nama;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    private boolean selected;


    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }


}

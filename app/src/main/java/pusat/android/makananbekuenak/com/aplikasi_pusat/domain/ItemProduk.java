package pusat.android.makananbekuenak.com.aplikasi_pusat.domain;

/**
 * Created by fikran on 21/04/16.
 */
public class ItemProduk {


    private int id;
    private String kode;
    private String nama;
    private String image;

    public ItemProduk(){

    }

    public ItemProduk (String kode, String nama, String image){
        this.kode = kode;
        this.nama = nama;
        this.image = image;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

package pusat.android.makananbekuenak.com.aplikasi_pusat.domain;

/**
 * Created by fikran on 20/04/16.
 */
public class Item {

    private String regional;
    private String harga;
    private String id;
    private String idproduk;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdproduk() {
        return idproduk;
    }

    public void setIdproduk(String idproduk) {
        this.idproduk = idproduk;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}

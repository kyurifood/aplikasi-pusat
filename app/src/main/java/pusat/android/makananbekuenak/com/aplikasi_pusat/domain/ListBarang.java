package pusat.android.makananbekuenak.com.aplikasi_pusat.domain;

/**
 * Created by id-oz on 3/28/16.
 */
public class ListBarang {
    private String nama_produk;

    private String baru;
    private String lunas;
    private String dikirim;
    private String diterima;
    private boolean button;
    private boolean check1;
    private boolean check2;
    private boolean check3;
    private boolean check4;


    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public String getBaru() {
        return baru;
    }

    public void setBaru(String baru) {
        this.baru = baru;
    }

    public String getLunas() {
        return lunas;
    }

    public void setLunas(String lunas) {
        this.lunas = lunas;
    }

    public String getDikirim() {
        return dikirim;
    }

    public void setDikirim(String dikirim) {
        this.dikirim = dikirim;
    }

    public String getDiterima() {
        return diterima;
    }

    public void setDiterima(String diterima) {
        this.diterima = diterima;
    }

    public boolean isButton() {
        return button;
    }

    public void setButton(boolean button) {
        this.button = button;
    }

    public boolean isCheck1() {
        return check1;
    }

    public void setCheck1(boolean check1) {
        this.check1 = check1;
    }

    public boolean isCheck2() {
        return check2;
    }

    public void setCheck2(boolean check2) {
        this.check2 = check2;
    }

    public boolean isCheck3() {
        return check3;
    }

    public void setCheck3(boolean check3) {
        this.check3 = check3;
    }

    public boolean isCheck4() {
        return check4;
    }

    public void setCheck4(boolean check4) {
        this.check4 = check4;
    }
}

package solfa.ratri.kegiatan.Adapter;

import android.database.Cursor;

/**
 * Created by Ratri on 12/10/2016.
 */
public class KegiatanModel {
    int id;
    String nama;
    String namaTempat;
    String alamat;
    String tanggal;
    String ll;

    public KegiatanModel(Cursor c){
        id = c.getInt(0);
        nama = c.getString(1);
        namaTempat = c.getString(2);
        tanggal = c.getString(3);
        alamat = c.getString(4);
        ll = c.getString(5);
    }
    public KegiatanModel(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNamaTempat() {
        return namaTempat;
    }

    public void setNamaTempat(String namaTempat) {
        this.namaTempat = namaTempat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getLl() {
        return ll;
    }

    public void setLl(String ll) {
        this.ll = ll;
    }
}

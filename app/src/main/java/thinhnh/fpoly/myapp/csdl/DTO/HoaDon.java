package thinhnh.fpoly.myapp.csdl.DTO;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "HoaDon", foreignKeys = {
        @ForeignKey(entity = KhungGio.class, parentColumns = "id_khunggio", childColumns = "id_khunggio", onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = San.class, parentColumns = "id_san", childColumns = "id_san", onDelete = ForeignKey.CASCADE),
})
public class HoaDon implements Serializable {
    @PrimaryKey(autoGenerate = true)
    int id_hoadon;
    String tenkh;
    String sdtkh;
    @ColumnInfo(name = "id_san")
    int id_san;
    String tensan;
    String giasan;
    @ColumnInfo(name = "id_khunggio")
    int id_khunggio;
    String khunggio;

    int tongtien;

    String ngaythue;
    public HoaDon() {
    }

    public HoaDon(String tenkh, String sdtkh, int id_san, String tensan, String giasan, int id_khunggio, String khunggio, int tongtien , String ngaythue) {

        this.tenkh = tenkh;
        this.sdtkh = sdtkh;
        this.id_san = id_san;
        this.tensan = tensan;
        this.giasan = giasan;
        this.id_khunggio = id_khunggio;
        this.khunggio = khunggio;

        this.tongtien = tongtien;

        this.ngaythue = ngaythue;
    }

    public String getSdtkh() {
        return sdtkh;
    }

    public void setSdtkh(String sdtkh) {
        this.sdtkh = sdtkh;
    }

    public String getNgaythue() {
        return ngaythue;
    }

    public void setNgaythue(String ngaythue) {
        this.ngaythue = ngaythue;
    }

    public int getId_hoadon() {
        return id_hoadon;
    }

    public void setId_hoadon(int id_hoadon) {
        this.id_hoadon = id_hoadon;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public int getId_san() {
        return id_san;
    }

    public void setId_san(int id_san) {
        this.id_san = id_san;
    }

    public String getTensan() {
        return tensan;
    }

    public void setTensan(String tensan) {
        this.tensan = tensan;
    }

    public String getGiasan() {
        return giasan;
    }

    public void setGiasan(String giasan) {
        this.giasan = giasan;
    }

    public int getId_khunggio() {
        return id_khunggio;
    }

    public void setId_khunggio(int id_khunggio) {
        this.id_khunggio = id_khunggio;
    }

    public String getKhunggio() {
        return khunggio;
    }

    public void setKhunggio(String khunggio) {
        this.khunggio = khunggio;
    }






    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }
}

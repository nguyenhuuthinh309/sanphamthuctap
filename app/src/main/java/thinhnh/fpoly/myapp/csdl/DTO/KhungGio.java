package thinhnh.fpoly.myapp.csdl.DTO;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "KhungGio")
public class KhungGio {
    @PrimaryKey(autoGenerate = true)
    int id_khunggio;
    String khunggio;




    public KhungGio(String khunggio) {
        this.khunggio = khunggio;
    }

    public KhungGio() {
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


}



package thinhnh.fpoly.myapp.csdl.DTO;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "San")
public class San {
    @PrimaryKey(autoGenerate = true)

     int id_san;
     String tensan;
     String vitrisan;
     String giasan;




    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] avatar_san;

    public San() {
    }

    public San(String tensan, String vitrisan, String giasan, byte[] avatar_san) {
        this.tensan = tensan;
        this.vitrisan = vitrisan;
        this.giasan = giasan;

        this.avatar_san = avatar_san;
    }


    public byte[] getAvatar_san() {
        return avatar_san;
    }

    public void setAvatar_san(byte[] avatar_san) {
        this.avatar_san = avatar_san;
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

    public String getVitrisan() {
        return vitrisan;
    }

    public void setVitrisan(String vitrisan) {
        this.vitrisan = vitrisan;
    }

    public String getGiasan() {
        return giasan;
    }

    public void setGiasan(String giasan) {
        this.giasan = giasan;
    }


}

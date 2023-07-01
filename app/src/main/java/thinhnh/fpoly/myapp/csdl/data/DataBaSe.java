package thinhnh.fpoly.myapp.csdl.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import thinhnh.fpoly.myapp.csdl.DAO.DAO_Admin;
import thinhnh.fpoly.myapp.csdl.DAO.DAO_HOADON;
import thinhnh.fpoly.myapp.csdl.DAO.DAO_KHUNGGIO;
import thinhnh.fpoly.myapp.csdl.DAO.DAO_NV;
import thinhnh.fpoly.myapp.csdl.DAO.DAO_SAN;
import thinhnh.fpoly.myapp.csdl.DTO.Admin;
import thinhnh.fpoly.myapp.csdl.DTO.HoaDon;
import thinhnh.fpoly.myapp.csdl.DTO.KhungGio;
import thinhnh.fpoly.myapp.csdl.DTO.NhanVien;
import thinhnh.fpoly.myapp.csdl.DTO.San;


@Database(entities = {Admin.class,NhanVien.class, San.class, KhungGio.class,HoaDon.class,}, version = 1)
public abstract class DataBaSe extends RoomDatabase {
    private static final String DATABASE_NAME = "db.db1";
    private static DataBaSe instance;
    public static synchronized DataBaSe getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), DataBaSe.class, DATABASE_NAME)
                    .allowMainThreadQueries().build();
        }
        return instance;
    }


    public abstract DAO_SAN dao_san();

    public abstract DAO_KHUNGGIO dao_khunggio();
    public abstract DAO_NV dao_nv();

    public  abstract DAO_HOADON dao_hoadon();
    public  abstract DAO_Admin dao_admin();






}
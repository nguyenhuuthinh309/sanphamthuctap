package thinhnh.fpoly.myapp.csdl.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import thinhnh.fpoly.myapp.csdl.DTO.KhungGio;


@Dao
public interface DAO_KHUNGGIO {



    @Insert
    void insertKHUNGGIO(KhungGio khungGio);
    @Update
    void updataKHUNGGIO(KhungGio khungGio);
    @Delete
    void deleteKHUNGGIO(KhungGio khungGio);
    @Query("select * from KhungGio")
    List<KhungGio> getAllkhunggio();

}

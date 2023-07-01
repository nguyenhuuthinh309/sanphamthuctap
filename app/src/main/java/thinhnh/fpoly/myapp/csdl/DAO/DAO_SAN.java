package thinhnh.fpoly.myapp.csdl.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import thinhnh.fpoly.myapp.csdl.DTO.San;
@Dao
public interface DAO_SAN {

    @Insert
    void insertSan(San san);
    @Update
    void updataSan(San san);
    @Delete
    void deleteSan(San san);
    @Query("select * from San")
    List<San> getAllSan();


}

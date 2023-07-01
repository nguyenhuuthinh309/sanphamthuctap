package thinhnh.fpoly.myapp.csdl.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import thinhnh.fpoly.myapp.csdl.DTO.Admin;
import thinhnh.fpoly.myapp.csdl.DTO.NhanVien;

@Dao
public interface DAO_Admin {
    @Insert
    void insertad(Admin nv);
    @Update
    void updataad(Admin nv);
    @Delete
    void deletead(Admin nv);

    @Query("select * from Admin")
    List<Admin> getAllad();
    @Query("select * from Admin where email= :user and matkhau = :pass")
    List<Admin> CheckLogin(String user, String pass);

    @Query("select * from Admin where email= :user")
    List<Admin> getAdtheoUser(String user);




}

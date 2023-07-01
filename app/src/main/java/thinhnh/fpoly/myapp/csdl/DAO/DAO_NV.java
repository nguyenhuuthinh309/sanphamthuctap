package thinhnh.fpoly.myapp.csdl.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import thinhnh.fpoly.myapp.csdl.DTO.NhanVien;
@Dao
public interface DAO_NV {
    @Insert
    void insertNV(NhanVien nv);
    @Update
    void updataNV(NhanVien nv);
    @Delete
    void deleteHV(NhanVien nv);

    @Query("select * from NhanVien")
    List<NhanVien> getAllNV();
    @Query("select * from NhanVien where tk_NV= :user and mk_NV = :pass")
   List<NhanVien> CheckLogin(String user, String pass);

    @Query("select * from NhanVien where tk_NV= :user")
    List<NhanVien> getNVtheoUser(String user);
    @Query("select * from NhanVien where id_NV= :id")
    List<NhanVien> getNVtheoId(int id);


    @Query("select * from NhanVien where tk_NV= :user")
    List<NhanVien> getHVtheoUser(String user);





}

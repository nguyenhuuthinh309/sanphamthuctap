package thinhnh.fpoly.myapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import thinhnh.fpoly.myapp.ACtyviti.DSNhanVien;
import thinhnh.fpoly.myapp.ACtyviti.DSSan;
import thinhnh.fpoly.myapp.ACtyviti.DoanhThuNgay;
import thinhnh.fpoly.myapp.ACtyviti.HoaDonHomNay;
import thinhnh.fpoly.myapp.ACtyviti.KhungGio;
import thinhnh.fpoly.myapp.ACtyviti.LichDatSan;
import thinhnh.fpoly.myapp.ACtyviti.ThongTin;
import thinhnh.fpoly.myapp.ACtyviti.TimKiem;
import thinhnh.fpoly.myapp.csdl.DTO.Admin;
import thinhnh.fpoly.myapp.csdl.DTO.NhanVien;
import thinhnh.fpoly.myapp.csdl.data.DataBaSe;

public class ManHinhAdmin  extends AppCompatActivity{


EditText timkiem1;
    private TextView an2, tennguoidung;
    private ImageView anhnguoidung;

    private LinearLayout hoadonhomnay,timkiemhoadon;

    private LinearLayout dsnhanvien;

    private LinearLayout dssan;

    private LinearLayout tinhtrang;
    private LinearLayout khunggio;
    private LinearLayout trangthai;
    private LinearLayout doimk, dangxuat, mDoanhThu;

    private LinearLayout an1, lichsan;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homeadmin);

        tennguoidung = (TextView) findViewById(R.id.tennguoidung);

        dangxuat =findViewById(R.id.dangxuat);
        dangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ManHinhAdmin.this);
                builder.setTitle("Thông báo!");
                builder.setMessage("Bạn có chắc chắn muốn đăng xuất không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(ManHinhAdmin.this, ManHinhLogin.class));
                        finish();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        an2 = (TextView) findViewById(R.id.an2);

        timkiem1 =  findViewById(R.id.timkiem1);
        timkiem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ManHinhAdmin.this, "Chức Năng Đang Phát Triển", Toast.LENGTH_SHORT).show();
            }
        });
        anhnguoidung = (ImageView) findViewById(R.id.anhnguoidung);
        hoadonhomnay = (LinearLayout) findViewById(R.id.hoadonhomnay);
        dsnhanvien = (LinearLayout) findViewById(R.id.dsnhanvien);
        dssan = (LinearLayout) findViewById(R.id.dssan);
        an1 = (LinearLayout) findViewById(R.id.an1);
            timkiemhoadon = findViewById(R.id.timkiemhoadon);

        khunggio = (LinearLayout) findViewById(R.id.khunggio);

        mDoanhThu = (LinearLayout) findViewById(R.id.mDoanhThu);

        lichsan = (LinearLayout) findViewById(R.id.lichsan);
timkiemhoadon.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(ManHinhAdmin.this, TimKiem.class);
        startActivity(intent);
    }
});
        lichsan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManHinhAdmin.this, LichDatSan.class);
                startActivity(intent);
            }
        });



        Bundle bundle = getIntent().getExtras();
        String permission = bundle.getString("value");

        dssan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManHinhAdmin.this, DSSan.class);
                startActivity(intent);
            }
        });



   khunggio.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           Intent intent = new Intent(ManHinhAdmin.this, KhungGio.class);
           startActivity(intent);
       }
   });

   mDoanhThu.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           Intent intent = new Intent(ManHinhAdmin.this, DoanhThuNgay.class);
           startActivity(intent);
       }
   });
   anhnguoidung.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           Toast.makeText(ManHinhAdmin.this, "Đang Phát Triển Thông Tin Người Dùng", Toast.LENGTH_SHORT).show();
       }
   });


          dsnhanvien.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent = new Intent(ManHinhAdmin.this, DSNhanVien.class);
                  startActivity(intent);
              }
          });
        hoadonhomnay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManHinhAdmin.this, HoaDonHomNay.class);
                startActivity(intent);
            }
        });

        if(permission.equalsIgnoreCase("ADMIN")){

        tennguoidung.setText(getIntent().getStringExtra("tenHV"));

        }else if(permission.equalsIgnoreCase("Nhân Viên")){
            tennguoidung.setText(getIntent().getStringExtra("tennv"));
      dsnhanvien.setVisibility(View.INVISIBLE);

       mDoanhThu.setVisibility(View.INVISIBLE);
dangxuat.setVisibility(View.VISIBLE);
dssan.setVisibility(View.INVISIBLE);
khunggio.setVisibility(View.INVISIBLE);
an2.setVisibility(View.INVISIBLE);
        }

    }




}
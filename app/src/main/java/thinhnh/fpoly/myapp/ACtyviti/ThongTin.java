package thinhnh.fpoly.myapp.ACtyviti;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import thinhnh.fpoly.myapp.ManHinhAdmin;
import thinhnh.fpoly.myapp.ManHinhLogin;
import thinhnh.fpoly.myapp.R;
import thinhnh.fpoly.myapp.csdl.DTO.Admin;
import thinhnh.fpoly.myapp.csdl.DTO.NhanVien;
import thinhnh.fpoly.myapp.csdl.data.DataBaSe;

public class ThongTin extends AppCompatActivity {
    TextView txtname;
    TextView txtsdt;
    NhanVien nhanVien;
    Admin admin;
    Button doimk, dangxuat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_thong_tin);

        txtname = (TextView) findViewById(R.id.txtname);
        txtsdt = (TextView)findViewById(R.id.txtsdt);
        doimk =  findViewById(R.id.mDoiMatKhau);
        dangxuat =findViewById(R.id.dangxuat);


        Bundle bundle = getIntent().getExtras();
        String permission = bundle.getString("value");
        if(permission.equalsIgnoreCase("ADMIN")){

            txtname.setText(getIntent().getStringExtra("tenHV"));
            txtsdt.setText(getIntent().getStringExtra("userHV"));

        }else if(permission.equalsIgnoreCase("Nhân Viên")){


        }
//





    }
}
package thinhnh.fpoly.myapp.ACtyviti;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import thinhnh.fpoly.myapp.R;
import thinhnh.fpoly.myapp.csdl.DTO.Admin;
import thinhnh.fpoly.myapp.csdl.DTO.NhanVien;
import thinhnh.fpoly.myapp.csdl.data.DataBaSe;

public class DoiMK extends AppCompatActivity {
    TextInputEditText old_pass;
    TextInputEditText mk_moi,chek_mkmoi;
    Admin admin;
    Button btndoi,btnhuy;
    NhanVien nhanVien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_doi_m_k);
        savedInstanceState =DoiMK.this.getIntent().getExtras();
        String permission = savedInstanceState.getString("value");
        String userHV = savedInstanceState.getString("userHV");
        String  userNv= savedInstanceState.getString("tknv");

        old_pass = (TextInputEditText) findViewById(R.id.edOldPass_changge);
        mk_moi = (TextInputEditText) findViewById(R.id.edNewPass_changge);
        chek_mkmoi = (TextInputEditText) findViewById(R.id.edReNewPass_changge);
        btndoi = (Button) findViewById(R.id.btnSwapPass_changge);

        TextView a = findViewById(R.id.text1);


        btndoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chek_mkmoi.setTextColor(Color.BLACK);
                if (permission.equalsIgnoreCase("Admin")) {
                    admin = DataBaSe.getInstance(DoiMK.this).dao_admin().getAdtheoUser(userHV).get(0);
                    String oldPass = old_pass.getText().toString();
                    String newPass = mk_moi.getText().toString();
                    if (oldPass.equals(admin.getMatkhau())) {
                        admin.setMatkhau(newPass);
                        DataBaSe.getInstance(DoiMK.this).dao_admin().updataad(admin);
                        Toast.makeText(DoiMK.this, "Đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
                        a.setText("Đổi mật khẩu thành công");

                    } else {
                        Toast.makeText(DoiMK.this ,"Mật khẩu cũ không đúng", Toast.LENGTH_SHORT).show();
                        a.setText("Mật khẩu cũ không đúng");
                    }
                } else if (permission.equalsIgnoreCase("Nhân Viên")) {
                    nhanVien = DataBaSe.getInstance(DoiMK.this).dao_nv().getHVtheoUser(userNv).get(0);
                    String oldPass = old_pass.getText().toString();
                    String newPass = mk_moi.getText().toString();
                    if (oldPass.equals(nhanVien.getMk_NV())) {
                        nhanVien.setMk_NV(newPass);
                        DataBaSe.getInstance(DoiMK.this).dao_nv().updataNV(nhanVien);
                        Toast.makeText(DoiMK.this, "Đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(DoiMK.this, "Mật khẩu cũ không đúng", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });



    }
}
package thinhnh.fpoly.myapp.ACtyviti;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import thinhnh.fpoly.myapp.Fragment.nhanvien.ThemHoaDonActivity;
import thinhnh.fpoly.myapp.R;
import thinhnh.fpoly.myapp.adapter.AdapterListView_HoaDon;
import thinhnh.fpoly.myapp.adapter.AdapterListView_HoaDonNhanVien;
import thinhnh.fpoly.myapp.csdl.DTO.HoaDon;
import thinhnh.fpoly.myapp.csdl.data.DataBaSe;

public class LichDatSan extends AppCompatActivity {

    ListView lisCs;
    FloatingActionButton floatCs;
    EditText tvtentimkiem;
    ImageView imgtimkiem;


    HoaDon hd;

    ArrayList<HoaDon> listhoadon = new ArrayList<>();
    AdapterListView_HoaDon adapterListView_hoaDon;
    AdapterListView_HoaDonNhanVien adapterListView_hoaDonNhanVien;



    TextView soluong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_hoa_don);

        Resources res = getResources();
        int color = res.getColor(R.color.maudo);
        Resources resa =getResources();
        int colorxanh = resa.getColor(R.color.purple_700);
        floatCs = (FloatingActionButton) findViewById(R.id.float_cs);
        lisCs = (ListView) findViewById(R.id.lis_cs);
        imgtimkiem = findViewById(R.id.imgtimkiemten);
        tvtentimkiem = findViewById(R.id.lis_edttenhdtimkiem);
        soluong = findViewById(R.id.sonv1);
        loadDataa();
        imgtimkiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listhoadon = (ArrayList<HoaDon>) DataBaSe.getInstance(LichDatSan.this).dao_hoadon().gettenhoadon(tvtentimkiem.getText().toString());
                loadData();
            }
        });



        soluong.setText(Integer.toString(demsoluong()));
        lisCs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Dialog dialog = new Dialog(LichDatSan.this);
                dialog.setContentView(R.layout.dialog_hoadon_chitiet);
                hd = listhoadon.get(i);
                TextView tvtenkh = (TextView) dialog.findViewById(R.id.tenchitiet);
                TextView tvsdtkh = (TextView) dialog.findViewById(R.id.sdtchitiet);
                TextView tvngaythue = (TextView) dialog.findViewById(R.id.ngaythuechitiet);
                TextView khunggio = (TextView) dialog.findViewById(R.id.khunggiochitiet);
                TextView tensan = (TextView) dialog.findViewById(R.id.tensanchitiet);
                TextView giabong = (TextView) dialog.findViewById(R.id.giabongchitiet);
                TextView giaao = (TextView) dialog.findViewById(R.id.giaaochitiet);
                TextView gianuoc = (TextView) dialog.findViewById(R.id.gianuocchitiet);
                TextView tongtien = (TextView) dialog.findViewById(R.id.tongtienchitiet);
                TextView trangthai = (TextView) dialog.findViewById(R.id.trangthaichitiet);
                tvtenkh.setText(hd.getTenkh());
                tvsdtkh.setText(hd.getSdtkh());
                tvngaythue.setText(hd.getNgaythue());
                khunggio.setText(hd.getKhunggio());
                tensan.setText(hd.getTensan());

                tongtien.setText(String.valueOf(hd.getTongtien()));

                if (trangthai.getText().toString().equals("Chua thanh toan")){
                    trangthai.setTextColor(color);
                }else{
                    trangthai.setTextColor(colorxanh);
                }
                Toast.makeText(LichDatSan.this, "Bạn đang xem hóa đơn khách hàng: "+ hd.getTenkh(), Toast.LENGTH_SHORT).show();
                dialog.show();
            }

        });

        loadDataa();
        floatCs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LichDatSan.this, ThemHoaDonActivity.class));

            }
        });

    }


    public void loadData() {
        //listhoadon = (ArrayList<HoaDon>) DataBaSe.getInstance(getActivity()).dao_hoadon().getAllHOADON();
        adapterListView_hoaDon = new AdapterListView_HoaDon(LichDatSan.this,this::loadData);
        adapterListView_hoaDon.setdata(listhoadon);
        lisCs.setAdapter(adapterListView_hoaDon);
    }
    public void loadDataa() {
        listhoadon = (ArrayList<HoaDon>) DataBaSe.getInstance(LichDatSan.this).dao_hoadon().getAllHOADON();
        adapterListView_hoaDon = new AdapterListView_HoaDon(LichDatSan.this,this::loadDataa);
        adapterListView_hoaDon.setdata(listhoadon);
        lisCs.setAdapter(adapterListView_hoaDon);
    }
    public int demsoluong(){
        int x = 0;
        listhoadon =(ArrayList<HoaDon>) DataBaSe.getInstance(LichDatSan.this).dao_hoadon().getAllHOADON();
        for(int i  = 0 ; i<listhoadon.toArray().length;i++){
            x = i+1;
        }
        return x;

    }
}
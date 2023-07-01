package thinhnh.fpoly.myapp.Fragment.nhanvien;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

import thinhnh.fpoly.myapp.ACtyviti.DSNhanVien;
import thinhnh.fpoly.myapp.ACtyviti.LichDatSan;
import thinhnh.fpoly.myapp.ManHinhAdmin;
import thinhnh.fpoly.myapp.R;
import thinhnh.fpoly.myapp.adapter.AdapterListView_HoaDon;
import thinhnh.fpoly.myapp.csdl.DTO.HoaDon;
import thinhnh.fpoly.myapp.csdl.DTO.KhungGio;
import thinhnh.fpoly.myapp.csdl.DTO.San;
import thinhnh.fpoly.myapp.csdl.data.DataBaSe;
////////////////////////////////////////////////////////////////////
public class
ThemHoaDonActivity extends AppCompatActivity {
    //wexrdfgvhbuinuytvrerxctyvbun
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
    int myear,mmonth,mday;

    HoaDon hd = new HoaDon();
    ImageView imgngay;
    San san = new San();
    KhungGio kg;

     TextInputEditText tenkh,sdtkh;
     Spinner spnkhunggio;
     TextView giakhunggio;
     Spinner spntensan;
     TextView giasanset;
     EditText edsoluongbong;
     TextView tvgianbong;
     EditText edsoluongnuoc;
     TextView tvgianuoc;
     EditText edsoluongao;
     TextView tvgiaao;
     Button tongtienbutton;
     TextView texttongtien;
     Spinner spntrangthai1;
     Button btnAddhdd;
     TextView edtngaythue;
     Button btnngaythue;
     Button btnHuyAddhdd;
     ImageView timkiemhoadon;
    ListView lv_BT;
    ArrayList<San> listsan = new ArrayList<>();
    ArrayList<KhungGio> listkhunggio = new ArrayList<>();


    ArrayList<HoaDon> listhoadon = new ArrayList<>();

    AdapterListView_HoaDon adapterListView_hoaDon;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_hoa_don);
        imgngay = findViewById(R.id.imgngay);

        lv_BT = findViewById(R.id.lis_BT);
        tenkh = (TextInputEditText) findViewById(R.id.tenkh);
        sdtkh = (TextInputEditText) findViewById(R.id.sdtkh);
        spnkhunggio = (Spinner) findViewById(R.id.spnkhunggio);
        spntensan = (Spinner) findViewById(R.id.spntensan);
        giasanset = (TextView) findViewById(R.id.giasan1);

        tongtienbutton = (Button) findViewById(R.id.tongtien);
        spntrangthai1 = (Spinner) findViewById(R.id.spntrangthai1);
        btnAddhdd = (Button) findViewById(R.id.btnAddhdd);
        btnHuyAddhdd = (Button) findViewById(R.id.btnHuyAddhdd);
        edtngaythue = (TextView) findViewById(R.id.edtngaythue);
        texttongtien = (TextView) findViewById(R.id.texttongtien);

        AdapterListView_HoaDon adapterListView_hoaDon;

        //set item cho spiner vai trò
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Vai_tro1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spntrangthai1.setAdapter(adapter);



        SimpleAdapter simpleAdapter1 = new SimpleAdapter(this, getDSSan(), android.R.layout.simple_list_item_1, new String[]{"tensan"}, new int[]{android.R.id.text1});
        spntensan.setAdapter(simpleAdapter1);


        spntensan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String,Object> hssan = (HashMap<String, Object>) spntensan.getSelectedItem();
                String tensan = (String) hssan.get("tensan");
                String giasan = (String) hssan.get("giasan");
                int giasan1 = Integer.parseInt(giasan);
                giasanset.setText(giasan1+"vnd");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        SimpleAdapter simpleAdapter2 = new SimpleAdapter(this, getDSKhungGio(), android.R.layout.simple_list_item_1, new String[]{"khunggio"}, new int[]{android.R.id.text1});
        spnkhunggio.setAdapter(simpleAdapter2);



        imgngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                myear = calendar.get(Calendar.YEAR);
                mmonth = calendar.get(Calendar.MONTH);
                mday = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(ThemHoaDonActivity.this
                        , 0, mdatetungay, myear, mmonth, mday);
                dialog.show();
            }
        });
//        timkiemhoadon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String ngaythue = edtngaythue.getText().toString();
//                HashMap<String,Object> hs2 = (HashMap<String, Object>) spnkhunggio.getSelectedItem();
//                int makg1 = (int) hs2.get("makhunggio");
//                String tenkhunggio = (String) hs2.get("khunggio");
//                HashMap<String,Object> hssan = (HashMap<String, Object>) spntensan.getSelectedItem();
//                String tensan = (String) hssan.get("tensan");
//                listhoadon = (ArrayList<HoaDon>) DataBaSe.getInstance(getApplicationContext()).dao_hoadon().checkadd(tensan,ngaythue,tenkhunggio);
//
//loadData();
//
//
//            }
//        });

        tongtienbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {






                HashMap<String, Object> hs1 = (HashMap<String, Object>) spntensan.getSelectedItem();
                int masan = (int) hs1.get("masan");
                String tensan = (String) hs1.get("tensan");
                String giasan = (String) hs1.get("giasan");

                int giasan1 = Integer.parseInt(giasan);

                int tongtientatca1 =  giasan1;
                texttongtien.setText(String.valueOf(tongtientatca1));
            }
        });


        lv_BT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        btnHuyAddhdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnAddhdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9]" +
                        ")|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)" +
                        "?(\\d{3})(\\s|\\.)?(\\d{3})$";
                String t =  tenkh.getText().toString();
                String a = sdtkh.getText().toString();
                String b = edtngaythue.getText().toString();
                String c = spnkhunggio.getSelectedItem().toString();

                String tenkh1 = tenkh.getText().toString();
                String sdtkh1 = sdtkh.getText().toString();


                String edtngay = edtngaythue.getText().toString();




                HashMap<String, Object> hs1 = (HashMap<String, Object>) spntensan.getSelectedItem();
                int masan = (int) hs1.get("masan");

                String tensan = (String) hs1.get("tensan");
                String giasan = (String) hs1.get("giasan");

                int giasan1 = Integer.parseInt(giasan);

                int tongtientatca1 =  giasan1;
                texttongtien.setText(String.valueOf(tongtientatca1));

                HashMap<String, Object> hs2 = (HashMap<String, Object>) spnkhunggio.getSelectedItem();
                int makg = (int) hs2.get("makhunggio");
                String khunggio = (String) hs2.get("khunggio");


                listhoadon = (ArrayList<HoaDon>) DataBaSe.getInstance(getApplicationContext()).dao_hoadon().checkadd(tensan,edtngay,khunggio);
                if(listhoadon.isEmpty()){
                     if(a.trim().isEmpty()){
                        Toast.makeText(ThemHoaDonActivity.this, "Bạn chưa nhập tên khách hàng xin hãy nhập?", Toast.LENGTH_SHORT).show();
                    }else if(a.length()<9||a.length()>13||a.matches(reg)){
                        Toast.makeText(ThemHoaDonActivity.this, "Không đúng định dạng số điện thoại vui lòng kiểm tra lại!", Toast.LENGTH_SHORT).show();
                    }
                    else if(t.trim().isEmpty()){
                        Toast.makeText(ThemHoaDonActivity.this, "Bạn chưa nhập số điện thoại  khách hàng xin hãy nhập?", Toast.LENGTH_SHORT).show();
                    }else if(b.trim().isEmpty()){
                        Toast.makeText(ThemHoaDonActivity.this, "Bạn chưa chọn ngày cho hóa đơn xin hãy chọn?", Toast.LENGTH_SHORT).show();
                    }else{
                        hd = new HoaDon(tenkh1, sdtkh1, masan, tensan, giasan, makg, khunggio,tongtientatca1, edtngay);
                        //Add hv vào database
                        DataBaSe.getInstance(getApplicationContext()).dao_hoadon().insertHOADON(hd);
                        //View list hv lên màn hình
                        // Khởi tạo Fragment
                         Intent intent = new Intent(ThemHoaDonActivity.this, LichDatSan.class);
                         startActivity(intent);
                    }

                }else{
                    Toast.makeText(ThemHoaDonActivity.this, "Sân đã đặt vui lòng kiểm tra lại: ", Toast.LENGTH_SHORT).show();
                }

                //set thuộc tính HV

            }
        });


    }
//    public void checkadd(){
//        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9]" +
//            ")|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)" +
//            "?(\\d{3})(\\s|\\.)?(\\d{3})$";
//       String t =  tenkh.getText().toString();
//        String a = sdtkh.getText().toString();
//        String b = edtngaythue.getText().toString();
//        String c = spnkhunggio.getSelectedItem().toString();
//        String d = edsoluongao.getText().toString();
//        String e = edsoluongbong.getText().toString();
//        String x = edsoluongnuoc.getText().toString();
//        if(t.trim().isEmpty()&&a.isEmpty()&&b.isEmpty()&&d.trim().isEmpty()&&e.trim().isEmpty()&&x.trim().isEmpty()){
//            Toast.makeText(this, "Bạn chưa nhập gì xin hãy nhập:", Toast.LENGTH_SHORT).show();
//        }else if(a.trim().isEmpty()){
//            Toast.makeText(this, "Bạn chưa nhập tên khách hàng xin hãy nhập?", Toast.LENGTH_SHORT).show();
//        }else if(a.length()<9&&a.length()>13&&a.matches(reg)){
//            Toast.makeText(this, "Không đúng định dạng số điện thoại vui lòng kiểm tra lại!", Toast.LENGTH_SHORT).show();
//        }
//        else if(t.trim().isEmpty()){
//            Toast.makeText(this, "Bạn chưa nhập số điện thoại  khách hàng xin hãy nhập?", Toast.LENGTH_SHORT).show();
//        }else if(b.trim().isEmpty()){
//            Toast.makeText(this, "Bạn chưa chọn ngày cho hóa đơn xin hãy chọn?", Toast.LENGTH_SHORT).show();
//        }else if(d.trim().isEmpty()){
//            Toast.makeText(this, "Bạn chưa chọn số lượng combo áo!", Toast.LENGTH_SHORT).show();
//        }else if(x.trim().isEmpty()){
//            Toast.makeText(this, "Bạn chưa chọn số lượng combo áo!", Toast.LENGTH_SHORT).show();
//        }
//    }
    public void loadData() {
        //listhoadon = (ArrayList<HoaDon>) DataBaSe.getInstance(getActivity()).dao_hoadon().getAllHOADON();
        adapterListView_hoaDon = new AdapterListView_HoaDon(getApplicationContext(),this::loadData);
        adapterListView_hoaDon.setdata(listhoadon);
        lv_BT.setAdapter(adapterListView_hoaDon);
    }
    public void reFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_ly_mhAdmin, fragment);
        transaction.commit();
    }
    private ArrayList<HashMap<String, Object>> getDSKhungGio() {

        listkhunggio = (ArrayList<KhungGio>) DataBaSe.getInstance(this).dao_khunggio().getAllkhunggio();
        ArrayList<HashMap<String, Object>> listHM = new ArrayList<>();

        for (KhungGio khungGio : listkhunggio) {
            HashMap<String, Object> hs2 = new HashMap<>();
            hs2.put("makhunggio", khungGio.getId_khunggio());
            hs2.put("khunggio", khungGio.getKhunggio());
            listHM.add(hs2);
        }
        return listHM;

    }




    DatePickerDialog.OnDateSetListener mdatetungay = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            myear = i;
            mmonth = i1;
            mday = i2;
            GregorianCalendar c = new GregorianCalendar(myear, mmonth, mday);
            edtngaythue.setText(simpleDateFormat.format(c.getTime()));
        }
    };
    private ArrayList<HashMap<String, Object>> getDSSan() {

        listsan = (ArrayList<San>) DataBaSe.getInstance(this).dao_san().getAllSan();
        ArrayList<HashMap<String, Object>> listHM = new ArrayList<>();

        for (San san : listsan) {
            HashMap<String, Object> hs1 = new HashMap<>();
            hs1.put("masan", san.getId_san());
            hs1.put("tensan", san.getTensan());
            hs1.put("giasan", san.getGiasan());
            listHM.add(hs1);
        }
        return listHM;

    }
}



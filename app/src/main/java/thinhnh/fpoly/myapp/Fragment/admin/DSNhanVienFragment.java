package thinhnh.fpoly.myapp.Fragment.admin;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import thinhnh.fpoly.myapp.R;
import thinhnh.fpoly.myapp.adapter.AdapterListView_NV;
import thinhnh.fpoly.myapp.csdl.DTO.NhanVien;
import thinhnh.fpoly.myapp.csdl.data.DataBaSe;


public class DSNhanVienFragment extends Fragment {

    ArrayList<NhanVien> lissonv = new ArrayList<>();
    NhanVien nv;
    private ListView lisCs;
    private FloatingActionButton floatCs;
    ArrayList<NhanVien> list = new ArrayList<>();
    AdapterListView_NV adapterListView_nv;
    TextView tvsnv;
     TextInputEditText tkAdd,loaitk;
     TextInputEditText mkAdd;
     TextInputEditText tenAdd;
     TextInputEditText sdtAdd;
     TextInputEditText cccdAdd;
     Button btnAddNV;
     Button btnHuyAddNv;

    ImageView imageView;



    public DSNhanVienFragment() {
        // Required empty public constructor
    }


    public static DSNhanVienFragment newInstance() {
        DSNhanVienFragment fragment = new DSNhanVienFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
        tvsnv.setText("Số Lượng : "+sonv());

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_d_s_nhan_vien, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lisCs = (ListView) view.findViewById(R.id.lis_cs);
        floatCs = (FloatingActionButton) view.findViewById(R.id.float_cs);
        imageView=new ImageView(getActivity());
        tvsnv = view.findViewById(R.id.sonv);
        lisCs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.dialog_nhanvien_chitiet);
                nv = list.get(position);
                TextView tennv = (TextView) dialog.findViewById(R.id.tennvchitiet);
                TextView matkhau = (TextView) dialog.findViewById(R.id.matkhaunvchitiet);
                TextView hoten = (TextView) dialog.findViewById(R.id.hotennvchitiet);
                TextView sdt = (TextView) dialog.findViewById(R.id.sdtnvchitiet);
                tennv.setText(nv.getTk_NV());
               matkhau.setText(nv.getMk_NV());
               hoten.setText(nv.getTen_NV());
               sdt.setText(nv.getSdt_NV());
                dialog.show();


            }
        });
    imageView.setImageResource(R.drawable.avtnv);


        floatCs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.dialog_add_nv);

                tkAdd = (TextInputEditText) dialog.findViewById(R.id.tk_add);
                mkAdd = (TextInputEditText)  dialog.findViewById(R.id.mk_add);
                tenAdd = (TextInputEditText)  dialog.findViewById(R.id.ten_add);
                sdtAdd = (TextInputEditText)  dialog.findViewById(R.id.sdt_add);

                btnAddNV = (Button)  dialog.findViewById(R.id.btnAddNV);
                btnHuyAddNv = (Button) dialog.findViewById(R.id.btnHuyAddNv);
                btnAddNV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9]" +
                                ")|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)" +
                                "?(\\d{3})(\\s|\\.)?(\\d{3})$";
//                        boolean kt = sdtAdd.(reg);
//                        if (validate()){}
                            String tk = tkAdd.getText().toString();
                            String mk = mkAdd.getText().toString();
                            String ten = tenAdd.getText().toString();
                            String sdt = sdtAdd.getText().toString();


                        String regexStr = "^[0-9]$";

                            //set thuộc tính HV

                            nv = new NhanVien(tk,mk,ten,sdt,Image_to_bye(imageView) );
                            //Add hv vào database
                        if(tkAdd.getText().toString().trim().equals("")&&mkAdd.getText().toString().trim().equals("")&&
                        tenAdd.getText().toString().trim().equals("")&&sdtAdd.getText().toString().trim().equals("")){
                            Toast.makeText(getActivity(), "Bạn chưa nhập gì xịn hãy nhập", Toast.LENGTH_SHORT).show();
                        }
                        else if(tkAdd.getText().toString().trim().length()<6){
                            Toast.makeText(getActivity(), "Tên đăng nhập phải lớn hơn 6 kí tự!", Toast.LENGTH_SHORT).show();
                        }else if(mkAdd.getText().toString().trim().length()<6){
                            Toast.makeText(getActivity(), "Mật khẩu phải lớn hơn 6 kí tự!", Toast.LENGTH_SHORT).show();
                        }else if(sdtAdd.getText().toString().trim().length()<10||sdtAdd.getText().toString().length()>13||sdtAdd.getText().toString().matches(reg)){
                            Toast.makeText(getActivity(), "Không đúng định dạng số điện thoại!", Toast.LENGTH_SHORT).show();
                        }else if(tenAdd.getText().toString().trim().length()<3){
                            Toast.makeText(getActivity(), "Hãy nhập tên đầy đủ! ", Toast.LENGTH_SHORT).show();
                        }else{
                            DataBaSe.getInstance(getActivity()).dao_nv().insertNV(nv);
                            loadData();
                            dialog.dismiss();
                        }
//                        if(tkAdd.getText().toString().length()>5&&sdtAdd.getText().toString().length()<10&&sdtAdd.getText().toString().length()>13||sdtAdd.getText().toString().matches(regexStr)==false&&
//                                mkAdd.getText().toString().length()>6 && tenAdd.getText().toString().length()>10 && sdtAdd.getText().toString().length()==10)
//                        {
//
//                        }else{
//                            Toast.makeText(getActivity(), "Hay nhap dung cac truong thong tin", Toast.LENGTH_SHORT).show();
//                        }
                            //View list hv lên màn hình

                            sonv();
                            Log.d("zzz", "onViewCreated: " + list.size());


                    }
                });
                btnHuyAddNv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });


    }
    public void vadilate(){
        if(tkAdd.getText().toString().length()>5){

        }
    }

    public void loadData() {
        list = (ArrayList<NhanVien>) DataBaSe.getInstance(getActivity()).dao_nv().getAllNV();
        adapterListView_nv = new AdapterListView_NV(getActivity(),this::loadData);
        adapterListView_nv.setdata(list);
        lisCs.setAdapter(adapterListView_nv);

    }
    public byte[] Image_to_bye(ImageView imageView) {
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] bytes = stream.toByteArray();
        return bytes;
    }
    public int sonv(){
        int x = 0;
        lissonv =(ArrayList<NhanVien>) DataBaSe.getInstance(getActivity()).dao_nv().getAllNV();
        for (int i = 0;i<lissonv.toArray().length;i++){

            x=i+1;
        }
        return x;
    }
}
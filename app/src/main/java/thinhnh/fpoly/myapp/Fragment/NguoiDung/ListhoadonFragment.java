package thinhnh.fpoly.myapp.Fragment.NguoiDung;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import thinhnh.fpoly.myapp.R;
import thinhnh.fpoly.myapp.adapter.AdapterListView_HoaDon;
import thinhnh.fpoly.myapp.csdl.DTO.HoaDon;
import thinhnh.fpoly.myapp.csdl.data.DataBaSe;

public class ListhoadonFragment extends Fragment {
    ListView lisCs;
    FloatingActionButton floatCs;
    EditText tvtentimkiem;
    ImageView imgtimkiem;
    HoaDon hd;
    TextView tvngaylist;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
    int myear,mmonth,mday;
    ArrayList<HoaDon> listhoadon = new ArrayList<>();
    AdapterListView_HoaDon adapterListView_hoaDon;
    public ListhoadonFragment() {
        // Required empty public constructor
    }

    public static ListhoadonFragment newInstance() {
        ListhoadonFragment fragment = new ListhoadonFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listhoadon, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();


    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Resources res = view.getResources();
        int color = res.getColor(R.color.maudo);
        Resources resa = view.getResources();
        int colorxanh = resa.getColor(R.color.purple_700);
        imgtimkiem = view.findViewById(R.id.imgtimkiemten);
        tvtentimkiem = view.findViewById(R.id.lis_edttenhdtimkiem);
        lisCs = (ListView) view.findViewById(R.id.lis_cs);
        tvngaylist = view.findViewById(R.id.tvngaylist);
        Calendar calendar = Calendar.getInstance();
        myear = calendar.get(Calendar.YEAR);
        mmonth = calendar.get(Calendar.MONTH);
        mday = calendar.get(Calendar.DAY_OF_MONTH);
        Calendar c = Calendar.getInstance();
        tvngaylist.setText("Ngày: "+simpleDateFormat.format(c.getTime()));
        String ngay = tvngaylist.getText().toString();
        lisCs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Dialog dialog = new Dialog(getContext());
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
                Toast.makeText(getContext(), "Bạn đang xem hóa đơn khách hàng: "+ hd.getTenkh(), Toast.LENGTH_SHORT).show();
                dialog.show();
            }

        });
        listhoadon = (ArrayList<HoaDon>) DataBaSe.getInstance(getActivity()).dao_hoadon().gettten(simpleDateFormat.format(c.getTime()));
       loadData();
    }
    public void loadData() {
        //listhoadon = (ArrayList<HoaDon>) DataBaSe.getInstance(getActivity()).dao_hoadon().getAllHOADON();
        adapterListView_hoaDon = new AdapterListView_HoaDon(getActivity(),this::loadData);
        adapterListView_hoaDon.setdata(listhoadon);
        lisCs.setAdapter(adapterListView_hoaDon);
    }
    public void loadDataa() {
        adapterListView_hoaDon = new AdapterListView_HoaDon(getActivity(),this::loadDataa);
        adapterListView_hoaDon.setdata(listhoadon);
        lisCs.setAdapter(adapterListView_hoaDon);
    }
//    public int demsoluong(){
//        int x = 0;
//        listhoadon =(ArrayList<HoaDon>) DataBaSe.getInstance(getActivity()).dao_hoadon().getAllHOADON();
//        for(int i  = 0 ; i<listhoadon.toArray().length;i++){
//            x = i+1;
//        }
//        return x;
//    }
}
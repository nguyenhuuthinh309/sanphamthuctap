package thinhnh.fpoly.myapp.Fragment.nhanvien;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import thinhnh.fpoly.myapp.R;
import thinhnh.fpoly.myapp.adapter.AdapterListView_HoaDon;
import thinhnh.fpoly.myapp.adapter.AdapterListView_HoaDonNhanVien;
import thinhnh.fpoly.myapp.csdl.DTO.HoaDon;
import thinhnh.fpoly.myapp.csdl.data.DataBaSe;

public class HoaDonNhanVienFragment extends Fragment {

     ListView lisCs;
     FloatingActionButton floatCs;



    HoaDon hd;

    ArrayList<HoaDon> listhoadon = new ArrayList<>();
    AdapterListView_HoaDon adapterListView_hoaDon;
    AdapterListView_HoaDonNhanVien adapterListView_hoaDonNhanVien;



    TextView soluong;


    public HoaDonNhanVienFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static HoaDonNhanVienFragment newInstance() {
        HoaDonNhanVienFragment fragment = new HoaDonNhanVienFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hoa_don, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        soluong = view.findViewById(R.id.sonv1);


        lisCs = (ListView) view.findViewById(R.id.lis_cs);
        floatCs = (FloatingActionButton) view.findViewById(R.id.float_cs);
        loadData();
        floatCs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), ThemHoaDonActivity.class));


            }
        });
    }


    public void loadData() {
        listhoadon = (ArrayList<HoaDon>) DataBaSe.getInstance(getActivity()).dao_hoadon().getAllHOADON();
        adapterListView_hoaDonNhanVien = new AdapterListView_HoaDonNhanVien(getActivity(),this::loadData);
        adapterListView_hoaDonNhanVien.setdata(listhoadon);
        lisCs.setAdapter(adapterListView_hoaDonNhanVien);
    }



}
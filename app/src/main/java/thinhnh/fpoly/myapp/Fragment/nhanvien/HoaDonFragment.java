package thinhnh.fpoly.myapp.Fragment.nhanvien;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import thinhnh.fpoly.myapp.R;
import thinhnh.fpoly.myapp.adapter.AdapterListView_HoaDon;
import thinhnh.fpoly.myapp.adapter.AdapterListView_HoaDonNhanVien;
import thinhnh.fpoly.myapp.csdl.DTO.HoaDon;
import thinhnh.fpoly.myapp.csdl.data.DataBaSe;

public class HoaDonFragment extends Fragment {

     ListView lisCs;
     FloatingActionButton floatCs;
     EditText tvtentimkiem;
     ImageView imgtimkiem;


    HoaDon hd;

    ArrayList<HoaDon> listhoadon = new ArrayList<>();
    AdapterListView_HoaDon adapterListView_hoaDon;
    AdapterListView_HoaDonNhanVien adapterListView_hoaDonNhanVien;



    TextView soluong;


    public HoaDonFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static HoaDonFragment newInstance() {
        HoaDonFragment fragment = new HoaDonFragment();

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
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onStart() {
        super.onStart();
      //  loadDataa();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}
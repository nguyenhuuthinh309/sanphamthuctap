package thinhnh.fpoly.myapp.Fragment.NguoiDung;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import thinhnh.fpoly.myapp.R;
import thinhnh.fpoly.myapp.csdl.DTO.Admin;
import thinhnh.fpoly.myapp.csdl.DTO.NhanVien;
import thinhnh.fpoly.myapp.csdl.data.DataBaSe;


public class ThongTinFragment extends Fragment {
     TextView txtname;
     TextView txtsdt;
     NhanVien nhanVien;
Admin admin;
    public ThongTinFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ThongTinFragment newInstance() {
        ThongTinFragment fragment = new ThongTinFragment();

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
        return inflater.inflate(R.layout.fragment_thong_tin, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        savedInstanceState = getActivity().getIntent().getExtras();
        String permission = savedInstanceState.getString("value");
        String userHV = savedInstanceState.getString("userHV");
        String  userNv= savedInstanceState.getString("tknv");
        txtname = (TextView) view.findViewById(R.id.txtname);
        txtsdt = (TextView) view.findViewById(R.id.txtsdt);

        if (permission.equalsIgnoreCase("Admin")) {
            admin = DataBaSe.getInstance(getActivity()).dao_admin().getAdtheoUser(userHV).get(0);
            txtname.setText(admin.getHoten());



//            Toast.makeText(getActivity(), idPT + " là id của ", Toast.LENGTH_SHORT).show();
        } else if (permission.equalsIgnoreCase("Nhân Viên")) {
            nhanVien = DataBaSe.getInstance(getActivity()).dao_nv().getHVtheoUser(userNv).get(0);
            txtname.setText(nhanVien.getTen_NV());
            txtsdt.setText(nhanVien.getSdt_NV());


        }

    }
}
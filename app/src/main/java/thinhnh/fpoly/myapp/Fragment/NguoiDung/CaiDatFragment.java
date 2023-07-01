package thinhnh.fpoly.myapp.Fragment.NguoiDung;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import thinhnh.fpoly.myapp.R;

public class CaiDatFragment extends Fragment {


    public CaiDatFragment() {
        // Required empty public constructor
    }


    public static CaiDatFragment newInstance() {
        CaiDatFragment fragment = new CaiDatFragment();

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
        return inflater.inflate(R.layout.fragment_cai_dat, container, false);
    }
}
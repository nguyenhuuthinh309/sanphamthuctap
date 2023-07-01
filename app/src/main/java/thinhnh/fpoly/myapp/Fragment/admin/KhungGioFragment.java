package thinhnh.fpoly.myapp.Fragment.admin;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import thinhnh.fpoly.myapp.R;
import thinhnh.fpoly.myapp.adapter.AdapterListView_KhungGio;
import thinhnh.fpoly.myapp.csdl.DTO.KhungGio;
import thinhnh.fpoly.myapp.csdl.data.DataBaSe;


public class KhungGioFragment extends Fragment {
     ListView lisCs;
     FloatingActionButton floatCs;
     TextView khunggio;
     Button huykhunggio;
     Button themkhunggio;
     KhungGio khungGio;
 AdapterListView_KhungGio adapterListView_khungGio;
    ArrayList<KhungGio> list = new ArrayList<>();
    public KhungGioFragment() {
        // Required empty public constructor
    }


    public static KhungGioFragment newInstance() {
        KhungGioFragment fragment = new KhungGioFragment();

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
        return inflater.inflate(R.layout.fragment_khung_gio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lisCs = (ListView) view.findViewById(R.id.lis_cs);
        floatCs = (FloatingActionButton) view.findViewById(R.id.float_cs);
        loadData();
        floatCs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.dialog_add_khunggio);

                khunggio = (TextInputEditText) dialog.findViewById(R.id.khunggio_add);

                themkhunggio = (Button) dialog.findViewById(R.id.btnAddkhunggio);
                huykhunggio = (Button) dialog.findViewById(R.id.btnHuyAddkhunggio);


                themkhunggio.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        if (validate()){}
                        String khunggio1 = khunggio.getText().toString();


                        //set thuộc tính HV
                        khungGio  = new KhungGio(khunggio1);
                        //Add hv vào database
                        DataBaSe.getInstance(getActivity()).dao_khunggio().insertKHUNGGIO(khungGio);
                        //View list hv lên màn hình
                        loadData();
                        Log.d("zzz", "onViewCreated: " + list.size());
                        dialog.dismiss();

                    }
                });
                huykhunggio.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });

    }

    public void loadData() {
        list = (ArrayList<KhungGio>) DataBaSe.getInstance(getActivity()).dao_khunggio().getAllkhunggio();
        adapterListView_khungGio = new AdapterListView_KhungGio(getActivity(),this::loadData);
        adapterListView_khungGio.setdata(list);
        lisCs.setAdapter(adapterListView_khungGio);
    }

}
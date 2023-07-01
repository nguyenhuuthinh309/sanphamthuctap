package thinhnh.fpoly.myapp.Fragment.admin;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import thinhnh.fpoly.myapp.R;
import thinhnh.fpoly.myapp.adapter.AdapterListView_San;
import thinhnh.fpoly.myapp.csdl.DTO.San;
import thinhnh.fpoly.myapp.csdl.data.DataBaSe;


public class DSSanFragment extends Fragment {


     ListView lisCs;
     FloatingActionButton floatCs;
    ImageView imageView;
    San san;

     TextInputEditText tensan;
     TextInputEditText vitri;
     TextInputEditText giasan;
     Spinner spnloaisan;
     Button btnAddSan;
     Button btnHuyAddSan;



    ArrayList<San> list1 = new ArrayList<>();


AdapterListView_San adapterListView_san;


    public DSSanFragment() {
        // Required empty public constructor
    }


    public static DSSanFragment newInstance() {
        DSSanFragment fragment = new DSSanFragment();

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
        return inflater.inflate(R.layout.fragment_d_s_san, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        lisCs = (ListView) view.findViewById(R.id.lis_cs);
        floatCs = (FloatingActionButton) view.findViewById(R.id.float_cs);

        imageView=new ImageView(getActivity());
        imageView.setImageResource(R.drawable.sanbong);
        loadData();

        floatCs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.dialog_add_san);

                tensan = (TextInputEditText) dialog.findViewById(R.id.tensan);
                vitri = (TextInputEditText) dialog.findViewById(R.id.vitri);
                giasan = (TextInputEditText) dialog.findViewById(R.id.giasan);

                btnAddSan = (Button) dialog.findViewById(R.id.btnAddSan);
                btnHuyAddSan = (Button) dialog.findViewById(R.id.btnHuyAddSan);

                btnAddSan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        if (validate()){}
                        String tensan1 = tensan.getText().toString();
                        String vitri1 = vitri.getText().toString();
                        String giasan1 = giasan.getText().toString();



                        //set thuộc tính HV
                       san  = new San(tensan1,vitri1,giasan1,Image_to_bye(imageView));
                        //Add hv vào database
                        DataBaSe.getInstance(getActivity()).dao_san().insertSan(san);
                        //View list hv lên màn hình
                     loadData();

                        dialog.dismiss();

                    }
                });
                btnHuyAddSan.setOnClickListener(new View.OnClickListener() {
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
        list1 = (ArrayList<San>) DataBaSe.getInstance(getActivity()).dao_san().getAllSan();
        adapterListView_san = new AdapterListView_San(getActivity(),this::loadData);
        adapterListView_san.setdata(list1);
        lisCs.setAdapter(adapterListView_san);



    }



    public byte[] Image_to_bye(ImageView imageView) {
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] bytes = stream.toByteArray();
        return bytes;
    }
}
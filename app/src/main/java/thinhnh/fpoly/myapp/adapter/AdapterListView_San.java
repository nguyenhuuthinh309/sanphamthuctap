package thinhnh.fpoly.myapp.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.HashMap;

import thinhnh.fpoly.myapp.R;
import thinhnh.fpoly.myapp.csdl.DTO.San;
import thinhnh.fpoly.myapp.csdl.data.DataBaSe;
import thinhnh.fpoly.myapp.interfaces.InteLoadData;

public class AdapterListView_San extends BaseAdapter {
    ArrayList<San> list = new ArrayList<>();
    Context context;

    InteLoadData inteCS;
    ArrayList<HashMap<String, Object>> listHM;


    public AdapterListView_San(Context context, InteLoadData inteCS) {
        this.context = context;
        this.inteCS = inteCS;
    }

    public void setdata(ArrayList<San> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (list != null) {
            return list.size();
        }
        return 0;

    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        San san = list.get(i);
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.layout_item_san, null);

            viewHolder.itemTensan = (TextView) view.findViewById(R.id.item_tensan);
            viewHolder.itemVitri = (TextView) view.findViewById(R.id.item_vitri);
            viewHolder.itemGia = (TextView) view.findViewById(R.id.item_gia);
            viewHolder.avt = view.findViewById(R.id.item_avata_san);
            viewHolder.itemsua = (ImageView) view.findViewById(R.id.itemsua);
            viewHolder.itemxoa = (ImageView) view.findViewById(R.id.itemxoa);
            viewHolder.itemtenloaisan = (TextView) view.findViewById(R.id.item_tenloaisan);


            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        if (san.getAvatar_san()!=null){
            Bitmap bitmap= BitmapFactory.decodeByteArray(san.getAvatar_san(),0,san.getAvatar_san().length);
            viewHolder.avt.setImageBitmap(bitmap);
        }else {
        }
        viewHolder.itemTensan.setText("Tên Sân  :  "+san.getTensan());
        viewHolder.itemVitri.setText("Vị Trí       :  "+san.getVitrisan());
        viewHolder.itemGia.setText("Giá Sân   :  "+san.getGiasan());



        ViewHolder finalViewHolder = viewHolder;

        viewHolder.itemsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialogEdit = new Dialog(context);
                dialogEdit.setContentView(R.layout.dialog_san_edit);

                TextInputEditText   tensanedit = (TextInputEditText) dialogEdit.findViewById(R.id.tensanedit);
                TextInputEditText   vitriedit = (TextInputEditText) dialogEdit.findViewById(R.id.vitriedit);
                TextInputEditText    giaedit = (TextInputEditText) dialogEdit.findViewById(R.id.giaedit);
                Spinner  spnloaisanedit = (Spinner) dialogEdit.findViewById(R.id.spnloaisanedit);
                Button btneditcs = (Button) dialogEdit.findViewById(R.id.btneditcs);
                Button  btnHuyEditcs = (Button) dialogEdit.findViewById(R.id.btnHuyEditcs);


                tensanedit.setText(san.getTensan());
                vitriedit.setText(san.getVitrisan());
                giaedit.setText(san.getGiasan());



                tensanedit.setText(san.getTensan());
                vitriedit.setText(san.getVitrisan());
                giaedit.setText(san.getGiasan());








                btneditcs.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        san.setTensan(tensanedit.getText().toString());
                        san.setVitrisan(vitriedit.getText().toString());
                        san.setGiasan(giaedit.getText().toString());


                        DataBaSe.getInstance(context).dao_san().updataSan(san);

                        inteCS.loadData();


                        Toast.makeText(context, "Đã sửa thành công!!!", Toast.LENGTH_SHORT).show();


                        dialogEdit.dismiss();


                    }
                });
                btnHuyEditcs.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogEdit.dismiss();
                    }
                });
                dialogEdit.show();
                Toast.makeText(context, " sửa", Toast.LENGTH_SHORT).show();
            }
        });
viewHolder.itemxoa.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle("DELETE");
        builder.setMessage("Do you want delete ?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DataBaSe.getInstance(context).dao_san().deleteSan(san);
                Toast.makeText((context), "Đã xóa", Toast.LENGTH_SHORT).show();
                inteCS.loadData();
                Toast.makeText(context, " xóa", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("NO",null);
        builder.show();
    }
});

        return view;

    }
    public class ViewHolder {

         TextView itemTensan;
         TextView itemVitri;
         TextView itemGia;
         TextView itemLoaisan, itemtenloaisan;
         ImageView avt, itemsua,itemxoa;









    }

}

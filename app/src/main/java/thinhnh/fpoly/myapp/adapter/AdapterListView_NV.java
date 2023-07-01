package thinhnh.fpoly.myapp.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import thinhnh.fpoly.myapp.R;
import thinhnh.fpoly.myapp.csdl.DTO.NhanVien;
import thinhnh.fpoly.myapp.csdl.data.DataBaSe;
import thinhnh.fpoly.myapp.interfaces.InteLoadData;


public class AdapterListView_NV extends BaseAdapter {

    ArrayList<NhanVien> list = new ArrayList<>();
    Context context;
    InteLoadData inteloadData;
    public AdapterListView_NV(Context context, InteLoadData inteloadData) {
        this.context = context;
        this.inteloadData=inteloadData;
    }

    public void setdata(ArrayList<NhanVien> list) {
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
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NhanVien nv = list.get(position);
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_item_nv, null);
            viewHolder.itemTennv = (TextView) convertView.findViewById(R.id.item_tennv);
            viewHolder.itemSdtnv = (TextView)  convertView.findViewById(R.id.item_sdtnv);
            viewHolder.avata = convertView.findViewById(R.id.item_pt_avata);
            viewHolder.itemsua = (ImageView)  convertView.findViewById(R.id.itemsua);
            viewHolder.itemxoa = (ImageView)  convertView.findViewById(R.id.itemxoa);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (nv.getAvatar_PT()!=null){
            Bitmap bitmap= BitmapFactory.decodeByteArray(nv.getAvatar_PT(),0,nv.getAvatar_PT().length);
            viewHolder.avata.setImageBitmap(bitmap);
        }else {
        }
//        viewHolder.avata.setImageResource(R.drawable.img_avatar_main);
        viewHolder.itemTennv.setText(nv.getTen_NV());
        viewHolder.itemSdtnv.setText(nv.getSdt_NV());
        ViewHolder finalViewHolder = viewHolder;

        viewHolder.itemsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Dialog dialogEdit = new Dialog(context);
                dialogEdit.setContentView(R.layout.dialog_nv_edit);
                Button btnEditHV = dialogEdit.findViewById(R.id.btnedit_HV);
                Button btnHuyEditHV = dialogEdit.findViewById(R.id.btnHuyEditHV);


                TextInputEditText  tkEdit = (TextInputEditText) dialogEdit.findViewById(R.id.tk_edit);
                TextInputEditText  mkEdit = (TextInputEditText) dialogEdit.findViewById(R.id.mk_edit);
                TextInputEditText   tenEdit = (TextInputEditText) dialogEdit.findViewById(R.id.ten_edit);
                TextInputEditText  sdtEdit = (TextInputEditText) dialogEdit.findViewById(R.id.sdt_edit);



                tkEdit.setText(nv.getTk_NV());
                mkEdit.setText(nv.getMk_NV());
                tenEdit.setText(nv.getTen_NV());
                sdtEdit.setText(nv.getSdt_NV());

                btnEditHV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        nv.setTk_NV(tkEdit.getText().toString());
                        nv.setMk_NV(mkEdit.getText().toString());
                        nv.setTen_NV(tenEdit.getText().toString());
                        nv.setSdt_NV(sdtEdit.getText().toString());

                        DataBaSe.getInstance(context).dao_nv().updataNV(nv);
                        inteloadData.loadData();
                        Toast.makeText(context, "Đã sửa thành công!!!", Toast.LENGTH_SHORT).show();
                        dialogEdit.dismiss();
                    }
                });
                btnHuyEditHV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogEdit.dismiss();
                    }
                });
                dialogEdit.show();
            }
        });

        viewHolder.itemxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setTitle("DELETE");
                builder.setMessage("Do you want delete?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DataBaSe.getInstance(context).dao_nv().deleteHV(nv);
                        Toast.makeText(context, "Đã xóa", Toast.LENGTH_SHORT).show();
                        inteloadData.loadData();
                    }
                });
                builder.setNegativeButton("NO",null);
                builder.show();
            }
        });

        return convertView;
    }
    public void vadilate(){

    }

    public class ViewHolder {

         TextView itemTennv;
         TextView itemSdtnv;
         ImageView avata,itemsua,itemxoa;

           LinearLayout shownv;

    }
}

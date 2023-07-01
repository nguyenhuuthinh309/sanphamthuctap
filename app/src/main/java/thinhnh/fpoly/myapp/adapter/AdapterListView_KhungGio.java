package thinhnh.fpoly.myapp.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import thinhnh.fpoly.myapp.R;
import thinhnh.fpoly.myapp.csdl.DTO.KhungGio;
import thinhnh.fpoly.myapp.csdl.data.DataBaSe;
import thinhnh.fpoly.myapp.interfaces.InteLoadData;

public class AdapterListView_KhungGio extends BaseAdapter {
    ArrayList<KhungGio> list = new ArrayList<>();
    Context context;
    InteLoadData intels;

    public AdapterListView_KhungGio(Context context, InteLoadData intels) {
        this.context = context;
        this.intels = intels;
    }

    public void setdata(ArrayList<KhungGio> list) {
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
        KhungGio ls = list.get(i);
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.layout_item_khunggio, null);


            viewHolder.itemKhunggio = (TextView) view.findViewById(R.id.item_khunggio);
            viewHolder.itemsua = (ImageView) view.findViewById(R.id.itemsua);
            viewHolder.itemxoa = (ImageView) view.findViewById(R.id.itemxoa);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.itemKhunggio.setText(ls.getKhunggio());
        ViewHolder finalViewHolder = viewHolder;

        viewHolder.itemxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setTitle("DELETE");
                builder.setMessage("Do you want delete ?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DataBaSe.getInstance(context).dao_khunggio().deleteKHUNGGIO(ls);
                        Toast.makeText((context), "Đã xóa", Toast.LENGTH_SHORT).show();
                        intels.loadData();
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







         TextView itemKhunggio;
         ImageView itemsua,itemxoa;






    }
}

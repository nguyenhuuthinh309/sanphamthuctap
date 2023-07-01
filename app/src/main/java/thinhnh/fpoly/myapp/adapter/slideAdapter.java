package thinhnh.fpoly.myapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import thinhnh.fpoly.myapp.R;
import thinhnh.fpoly.myapp.model.model_slideImage;
public class slideAdapter extends PagerAdapter {
    private Context mContext;
    private ArrayList<model_slideImage> model_slideImages;

    public slideAdapter(Context mContext, ArrayList<model_slideImage> model_slideImages) {
        this.mContext = mContext;
        this.model_slideImages = model_slideImages;
    }

    @Override
    public int getCount() {
        if (model_slideImages != null) {
            return model_slideImages.size();
        }
        return 0;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.slide_item, container, false);
        ImageView imgslide = view.findViewById(R.id.Img_item);
        TextView tv1 = view.findViewById(R.id.tv_silde_item_TieuDe);
        TextView tv2 = view.findViewById(R.id.tv_slide_item_GhiChu);
        TextView tv3 = view.findViewById(R.id.tv_slide_item_GhiChu2);
        model_slideImage model_slideImage = model_slideImages.get(position);
        if (imgslide != null) {
            Glide.with(mContext).load(model_slideImage.getImg()).into(imgslide);
            tv1.setText(model_slideImage.getTv1());
            tv2.setText(model_slideImage.getTv2());
            tv3.setText(model_slideImage.getTv3());
        }
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);

    }
}

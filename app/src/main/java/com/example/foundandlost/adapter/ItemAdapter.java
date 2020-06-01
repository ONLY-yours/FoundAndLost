package com.example.foundandlost.adapter;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foundandlost.R;
import com.example.foundandlost.bean.ItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: lijunjie
 * @createDate: 2020/5/31  16:21
 * @purpose：
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private String foundWord="";

    private List<ItemBean> listbean;

    public ItemAdapter(List<ItemBean> list){
        listbean=list;
    }

    public ItemAdapter(){

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_home_reserve,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (listbean!=null && listbean.size()>1) {
            if (listbean.get(position).getIdnumber() % 4 == 0) {
                holder.iv_img.setVisibility(View.VISIBLE);
            } else if (listbean.get(position).getIdnumber() % 4 == 1) {
                holder.iv_img1.setVisibility(View.VISIBLE);
            } else if (listbean.get(position).getIdnumber() % 4 == 2) {
                holder.iv_img2.setVisibility(View.VISIBLE);
            } else if (listbean.get(position).getIdnumber() % 4 == 3) {
                holder.iv_img3.setVisibility(View.VISIBLE);
            }
            holder.tvDescribe1.setText(listbean.get(position).getName());
            holder.tvDescribe2.setText(listbean.get(position).getDescribe());
            holder.tvDescribe3.setText(listbean.get(position).getTime());
        }else {
            if (position % 4 == 0) {
                holder.iv_img.setVisibility(View.VISIBLE);
                holder.tvDescribe1.setText("灰色手表");
                holder.tvDescribe2.setText("详细描述： 于下午丢失于操场，\n请有缘人捡到归还，谢谢！");
                holder.tvDescribe3.setText("时间：5月30日 18：30");
            } else if (position % 4 == 1) {
                holder.iv_img1.setVisibility(View.VISIBLE);
                holder.tvDescribe1.setText("寝室钥匙");
                holder.tvDescribe2.setText("详细描述：本人于早上晨跑时丢\n失寝室钥匙一串，有缘人捡到请\n归还");
                holder.tvDescribe3.setText("时间：6月1日 8：50");
            } else if (position % 4 == 2) {
                holder.iv_img2.setVisibility(View.VISIBLE);
                holder.tvDescribe1.setText("mc周边T恤");
                holder.tvDescribe2.setText("详细描述：本人于30日晚打球时丢\n失T恤一件，有缘人捡到请\n归还");
                holder.tvDescribe3.setText("时间：6月30日 20：50");
            } else if (position % 4 == 3) {
                holder.iv_img3.setVisibility(View.VISIBLE);
                holder.tvDescribe1.setText("饭卡");
                holder.tvDescribe2.setText("详细描述：本人于2日中午吃饭时丢\n失夏校园卡一张，有缘人捡到请\n归还");
                holder.tvDescribe3.setText("时间：6月30日 20：50");
            }

        }
    }

    @Override
    public int getItemCount() {
        if (listbean!=null && listbean.size()>0){
            return listbean.size();
        }else{
            return 8;
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        //这些控件都可以设置监听事件
        View view;
        ImageView iv_img;
        ImageView iv_img1;
        ImageView iv_img2;
        ImageView iv_img3;


        TextView tvDescribe1;
        TextView tvDescribe2;
        TextView tvDescribe3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view=itemView.findViewById(R.id.view_detial);
            iv_img=itemView.findViewById(R.id.iv_img);

            iv_img1=itemView.findViewById(R.id.iv_img1);
            iv_img2=itemView.findViewById(R.id.iv_img2);
            iv_img3=itemView.findViewById(R.id.iv_img3);

            tvDescribe1=itemView.findViewById(R.id.tvdescribe1);
            tvDescribe2=itemView.findViewById(R.id.tvdescribe2);
            tvDescribe3=itemView.findViewById(R.id.tvdescribe3);
        }
    }
}

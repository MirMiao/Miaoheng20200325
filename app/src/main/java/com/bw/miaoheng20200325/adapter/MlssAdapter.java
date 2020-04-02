package com.bw.miaoheng20200325.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.miaoheng20200325.R;
import com.bw.miaoheng20200325.entity.HomeDataEntity;

import java.util.List;

/**
 * 时间 :2020/4/1  13:51
 * 作者 :苗恒
 * 功能 :
 */
public class MlssAdapter extends RecyclerView.Adapter<MlssAdapter.MyViewHolder> {
    Context context;
    List<HomeDataEntity.ResultBean.MlssBean.CommodityListBeanXX> commodityList;
    public MlssAdapter(Context context, List<HomeDataEntity.ResultBean.MlssBean.CommodityListBeanXX> commodityList) {
        this.commodityList=commodityList;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.mlsh_item_layout, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.tv_name.setText(commodityList.get(position).getCommodityName());
            holder.tv_price.setText("￥"+commodityList.get(position).getPrice());
        Glide.with(context).load(commodityList.get(position).getMasterPic()).into(holder.iv_image);
    }

    @Override
    public int getItemCount() {
        return commodityList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView iv_image;
        private final TextView tv_name;
        private final TextView tv_price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_image = itemView.findViewById(R.id.iv_image);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_price = itemView.findViewById(R.id.tv_price);
        }
    }
}

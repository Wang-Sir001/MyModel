package com.bawei.mymodel.model.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.mymodel.R;
import com.bawei.mymodel.model.entity.ProductEntity;
import com.bumptech.glide.Glide;

import java.util.List;

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.MyViewHolder> {

    private Context context;
    private List<ProductEntity.Product> list;

    public RecyAdapter(Context context, List<ProductEntity.Product> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.fragment_layout, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context)
                .load(list.get(position).masterPic)
                .circleCrop()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.img);
        holder.name.setText(list.get(position).commodityName);
        holder.price.setText(list.get(position).price);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rectCallback.success();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView name,price;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.pricce);
        }
    }

    public RectCallback rectCallback;

    public void setRectCallback(RectCallback rectCallback) {
        this.rectCallback = rectCallback;
    }

    public interface RectCallback{
        void success();
    }
}

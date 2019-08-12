package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListDataAdapter extends RecyclerView.Adapter<ListDataAdapter.ViewHolder> {

    private ArrayList<ListData> list;
    private final Context context;

    public void setListAdapter(ArrayList<ListData> listData){
        this.list = listData;
    }

    public ListDataAdapter(Context context){
        this.context = context;
        list = new ArrayList<>();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card_data, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final ListData listData = list.get(position);

        Glide.with(viewHolder.itemView.getContext())
                .load(listData.getPhoto())
                .into(viewHolder.imgPhoto);

        viewHolder.tvName.setText(listData.getName());
        viewHolder.tvYear.setText(listData.getYear());
        viewHolder.tvDesc.setText(listData.getLongDesc());

        viewHolder.btnReadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListData list = new ListData();
                list.setName(listData.getName());
                list.setYear(listData.getYear());
                list.setLongDesc(listData.getLongDesc());
                list.setPhoto(listData.getPhoto());

                Intent sendData = new Intent(context,DetailActivity.class);
                sendData.putExtra(DetailActivity.EXTRA_DATA,list);
                context.startActivity(sendData);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvYear;
        TextView tvDesc;
        ImageView imgPhoto;
        Button btnReadMore;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_item_name);
            tvYear = itemView.findViewById(R.id.tv_item_year);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvDesc = itemView.findViewById(R.id.longdesc_item);
            btnReadMore = itemView.findViewById(R.id.btn_read_more);
        }
    }
}
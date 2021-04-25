package com.example.ontapgiuaky;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListCharAdapter extends RecyclerView.Adapter<ListCharAdapter.ItemCharViewHolder> {
    private ArrayList<ItemChar> list;
    private LayoutInflater inflater;
    private OnItemClickListener mListener;

    public ListCharAdapter(Context context, ArrayList<ItemChar> list) {
        inflater = LayoutInflater.from(context);
        this.list = list;
    }

    public  interface OnItemClickListener{
        void onItemClick(int position);
    }
    public  void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    @NonNull
    @Override
    public ItemCharViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.viewchar, parent, false);
        return new ItemCharViewHolder(view, this,mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemCharViewHolder holder, int position) {
        ItemChar item = list.get(position);
        holder.img.setImageResource(item.getImg());
        holder.tvName.setText(item.getTvName() + "");
        holder.tvPrice.setText("$"+item.getTvPrice() + "");
    }

    public static   class ItemCharViewHolder extends RecyclerView.ViewHolder{
        public final ListCharAdapter mAdapter;
        public final ImageView img;
        public final TextView tvName;
        public final TextView tvPrice;
        public ItemCharViewHolder(@NonNull View itemView, ListCharAdapter mAdapter,OnItemClickListener listener) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            this.mAdapter = mAdapter;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        int position= getAdapterPosition();
                        if(position!= RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}

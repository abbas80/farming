package com.example.farming;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class past_npk_adapter extends RecyclerView.Adapter<past_npk_adapter.npk_viewholder> {
    List<past_npk_model> past_npk_models;

    public past_npk_adapter(List<past_npk_model> past_npk_models) {
        this.past_npk_models = past_npk_models;
    }

    @NonNull
    @Override
    public npk_viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.npk_ratio_itemlayout,viewGroup,false);
        return new npk_viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull npk_viewholder npk_viewholder, int i) {
        past_npk_model npk=past_npk_models.get(i);
        npk_viewholder.past_n.setText(npk.getPast_n());
        npk_viewholder.past_p.setText(npk.getPast_p());
        npk_viewholder.past_k.setText(npk.getPast_k());
        npk_viewholder.sno.setText(npk.getSno()+":");
        npk_viewholder.date.setText(npk.getDate());

    }

    @Override
    public int getItemCount() {
        return past_npk_models.size();
    }

    public  class npk_viewholder extends RecyclerView.ViewHolder
    {
        public TextView past_n,past_p,past_k,sno,date;
        public npk_viewholder(@NonNull View itemView) {
            super(itemView);
            past_n=itemView.findViewById(R.id.past_n);
            past_p=itemView.findViewById(R.id.past_p);
            past_k=itemView.findViewById(R.id.past_k);
            sno=itemView.findViewById(R.id.sno);
            date=itemView.findViewById(R.id.date_tx);
        }
    }
}

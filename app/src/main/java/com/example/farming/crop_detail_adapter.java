package com.example.farming;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class crop_detail_adapter extends RecyclerView.Adapter {
    List<crop_detail_model> crop_detail_models;

    public crop_detail_adapter(List<crop_detail_model> crop_detail_models) {
        this.crop_detail_models = crop_detail_models;
    }

    @Override
    public int getItemViewType(int position) {

        switch (crop_detail_models.get(position).getType())
        {
            case 0:
                return crop_detail_model.ze;
            case 1:
                return crop_detail_model.on;
            default:
                return -1;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i)
        {
            case crop_detail_model.ze:
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.crop_suggest_itemview, viewGroup, false);
                return new iewHolder(view);

            case crop_detail_model.on:
                View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.crop_suggest_itemview_no, viewGroup, false);
                return new alertiewHolder(v);

            default: return null;
        }
    
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (crop_detail_models.get(i).getType()) {
            case 1:
                ((alertiewHolder)viewHolder).setDetail("Very Low N:P:K Content.");
                break;
            case 0:
                crop_detail_model c = crop_detail_models.get(i);

                ((iewHolder)viewHolder).crop.setImageResource(c.getIcon());
                ((iewHolder)viewHolder).crop_name.setText(c.getCrop_name());
                ((iewHolder)viewHolder).n1.setText(c.getN_value());
                ((iewHolder)viewHolder).p1.setText(c.getP_value());
                ((iewHolder)viewHolder).k1.setText(c.getK_value());
                boolean isexp = c.isIsexpandable();
                ((iewHolder)viewHolder).exp.setVisibility(isexp ? View.VISIBLE : View.GONE);
                ((iewHolder)viewHolder).drop_down.setVisibility(!isexp ? View.VISIBLE : View.GONE);
                break;


        }

    }

    @Override
    public int getItemCount() {
        return crop_detail_models.size();
    }
    public class alertiewHolder extends RecyclerView.ViewHolder
    {
        public ConstraintLayout c;
        public TextView t1,t2;
        public alertiewHolder(@NonNull View itemView) {
            super(itemView);
            c=(ConstraintLayout)itemView.findViewById(R.id.cons_red);
            t1=(TextView)itemView.findViewById(R.id.alert_text);
            t2=(TextView)itemView.findViewById(R.id.low_disp);
        }
        public void setDetail(String s)
        {
            t2.setText(s);
        }
    }

    public class iewHolder extends RecyclerView.ViewHolder
    {
        private CircleImageView crop;
        private TextView n1,crop_name,drop_down;
        private TextView p1;
        private TextView k1;
        private ConstraintLayout full,exp;
        public iewHolder(@NonNull View itemView) {
            super(itemView);
            crop=itemView.findViewById(R.id.crop_image);
            crop_name=itemView.findViewById(R.id.crop_name);
            n1=itemView.findViewById(R.id.past_n);
            p1=itemView.findViewById(R.id.past_p);
            k1=itemView.findViewById(R.id.past_k);
            drop_down=itemView.findViewById(R.id.drop_down);
            full=itemView.findViewById(R.id.cons);
            exp=itemView.findViewById(R.id.expandable_recyclerview);
            full.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    crop_detail_model c=crop_detail_models.get(getAdapterPosition());
                    c.setIsexpandable(!c.isIsexpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
            crop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    crop_detail_model c=crop_detail_models.get(getAdapterPosition());
                    c.setIsexpandable(!c.isIsexpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}

    /* public crop_detail_adapter(List<crop_detail_model> crop_detail_models) {
        this.crop_detail_models = crop_detail_models;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i)
        {
            case crop_detail_model.ze:
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.crop_suggest_itemview, viewGroup, false);
                return new viewHolder(view);

            case crop_detail_model.on:
                View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.crop_suggest_itemview_no, viewGroup, false);
                return new viewHolder(v);

             default: return null;
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (crop_detail_models.get(position).getType())
        {
            case 0:
                return crop_detail_model.ze;
            case 1:
                return crop_detail_model.on;
                default:
                    return -1;
        }
        //return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int i) {
    switch (crop_detail_models.get(i).getType()) {
        case 1:
            (viewHolder1)viewHolder.
        break;
        case 0:
            crop_detail_model c = crop_detail_models.get(i);

            viewHolder.crop.setImageResource(c.getIcon());
            viewHolder.crop_name.setText(c.getCrop_name());
            viewHolder.n1.setText(c.getN_value());
            viewHolder.p1.setText(c.getP_value());
            viewHolder.k1.setText(c.getK_value());
            boolean isexp = c.isIsexpandable();
            viewHolder.exp.setVisibility(isexp ? View.VISIBLE : View.GONE);
            viewHolder.drop_down.setVisibility(!isexp ? View.VISIBLE : View.GONE);
            break;


    }
    }

    @Override
    public int getItemCount() {
        return crop_detail_models.size();
    }

    public class viewHolder1 extends RecyclerView.ViewHolder
    {
        public ConstraintLayout c;
        public TextView t1,t2;
        public viewHolder1(@NonNull View itemView) {
            super(itemView);
            c=(ConstraintLayout)itemView.findViewById(R.id.cons_red);
            t1=(TextView)itemView.findViewById(R.id.alert_text);
            t2=(TextView)itemView.findViewById(R.id.low_disp);
        }
        public void setDetail(String s)
        {
            t2.setText(s);
        }
    }
    public class viewHolder extends RecyclerView.ViewHolder
{
    private CircleImageView crop;
    private TextView n1,crop_name,drop_down;
    private TextView p1;
    private TextView k1;
    private ConstraintLayout full,exp;
    public viewHolder(@NonNull View itemView) {
        super(itemView);
        crop=itemView.findViewById(R.id.crop_image);
        crop_name=itemView.findViewById(R.id.crop_name);
        n1=itemView.findViewById(R.id.past_n);
        p1=itemView.findViewById(R.id.past_p);
        k1=itemView.findViewById(R.id.past_k);
        drop_down=itemView.findViewById(R.id.drop_down);
        full=itemView.findViewById(R.id.cons);
        exp=itemView.findViewById(R.id.expandable_recyclerview);
    full.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
             crop_detail_model c=crop_detail_models.get(getAdapterPosition());
             c.setIsexpandable(!c.isIsexpandable());
            notifyItemChanged(getAdapterPosition());
        }
    });
        crop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crop_detail_model c=crop_detail_models.get(getAdapterPosition());
                c.setIsexpandable(!c.isIsexpandable());
                notifyItemChanged(getAdapterPosition());
            }
        });
    }
}
}*/

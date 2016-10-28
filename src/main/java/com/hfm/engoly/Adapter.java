package com.hfm.engoly;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hosein on 7/20/2016.
 */
public class Adapter extends RecyclerView.Adapter {

    ArrayList<Speech> speeches;
    Context context;
    LayoutInflater inflater;
    public Adapter(Context context, int item_id, Chat chat) {
        super();
        this.speeches =chat.getSpeeches();
        this.context=context;
        this.inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }





    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.chat_item,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder vholder, int position) {
        Speech Speech = speeches.get(position);
        Holder holder=(Holder)vholder;
        holder.text.setText(speeches.get(position).getText());
        //holder.prof_img.setImageDrawable();
    }



    @Override
    public int getItemCount() {
        return speeches.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        ImageView prof_img;
        TextView text;

        public Holder(View itemView) {
            super(itemView);
            prof_img= (ImageView) itemView.findViewById(R.id.profile_image);
            text= (TextView) itemView.findViewById(R.id.chat_text);

        }
    }



}

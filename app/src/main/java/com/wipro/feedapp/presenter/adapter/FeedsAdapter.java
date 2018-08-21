package com.wipro.feedapp.presenter.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;
import com.wipro.feedapp.R;
import com.wipro.feedapp.presenter.RecyclerItemClickListener;
import com.wipro.feedapp.model.FeedsList;

public class FeedsAdapter extends RecyclerView.Adapter<FeedsAdapter.FeedsViewHolder> {

    private FeedsList dataList;
    private RecyclerItemClickListener recyclerItemClickListener;

    public FeedsAdapter(FeedsList dataList , RecyclerItemClickListener recyclerItemClickListener) {
        this.dataList = dataList;
        this.recyclerItemClickListener = recyclerItemClickListener;
    }


    @Override
    public FeedsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_view_row, parent, false);
        return new FeedsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FeedsViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        if(dataList.getRows().get(position)!=null){
            if(dataList.getRows().get(position).getTitle()!=null)
                holder.txt_feeds_title.setText(dataList.getRows().get(position).getTitle().trim());
            if(dataList.getRows().get(position).getDescription()!=null)
                holder.txt_feeds_brief.setText(dataList.getRows().get(position).getDescription().trim());
            if(dataList.getRows().get(position).getImageHref()!=null){
                Picasso.get().load(dataList.getRows().get(position).getImageHref().toString()).into(holder.imgView);

            }


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerItemClickListener.onItemClick(dataList.getRows().get(position));
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return dataList.getRows().size();
    }

    class FeedsViewHolder extends RecyclerView.ViewHolder {

        TextView txt_feeds_brief, txt_feeds_title;
        ImageView imgView;

        FeedsViewHolder(View itemView) {
            super(itemView);
            txt_feeds_title =  itemView.findViewById(R.id.txt_feeds_title);
            txt_feeds_brief =  itemView.findViewById(R.id.txt_feeds_brief);
            imgView =  itemView.findViewById(R.id.img_feed);

        }
    }
}
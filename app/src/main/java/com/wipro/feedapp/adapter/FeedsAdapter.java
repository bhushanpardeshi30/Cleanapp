package com.wipro.feedapp.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.wipro.feedapp.R;
import com.wipro.feedapp.main_activity.RecyclerItemClickListener;
import com.wipro.feedapp.model.FeedsList;
import com.wipro.feedapp.model.Row;

import java.util.ArrayList;

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
        holder.txtNoticeTitle.setText(dataList.getRows().get(position).getTitle());
        holder.txtNoticeBrief.setText(dataList.getRows().get(position).getDescription());
        //holder.txtNoticeFilePath.setText(dataList.get(position).getImageHref());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerItemClickListener.onItemClick(dataList.getRows().get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.getRows().size();
    }

    class FeedsViewHolder extends RecyclerView.ViewHolder {

        TextView txtNoticeTitle, txtNoticeBrief, txtNoticeFilePath;

        FeedsViewHolder(View itemView) {
            super(itemView);
            txtNoticeTitle =  itemView.findViewById(R.id.txt_notice_title);
            txtNoticeBrief =  itemView.findViewById(R.id.txt_notice_brief);
            //txtNoticeFilePath =  itemView.findViewById(R.id.txt_notice_file_path);

        }
    }
}
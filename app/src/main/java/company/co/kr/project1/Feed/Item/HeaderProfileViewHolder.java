package company.co.kr.project1.Feed.Item;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import company.co.kr.project1.Feed.HeaderMessage.HeaderProfileAdapter;
import company.co.kr.project1.R;


public class HeaderProfileViewHolder extends RecyclerView.ViewHolder {
    private RecyclerView header_profile_recyclerView;

    public HeaderProfileViewHolder(Context mContext, View headerProfileView, List<Integer> header_user_list) {
        super(headerProfileView);
        header_profile_recyclerView = (RecyclerView) headerProfileView.findViewById(R.id.header_recyclerView);

        HeaderProfileAdapter headerAdapter = new HeaderProfileAdapter(mContext, header_user_list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        header_profile_recyclerView.setLayoutManager(layoutManager);
        header_profile_recyclerView.setAdapter(headerAdapter);
    }
}

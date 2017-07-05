package company.co.kr.project1.Feed.Header;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import company.co.kr.project1.R;

/**
 * Created by Dongjin on 2017. 7. 5..
 */

public class HeaderProfileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<String> user_list = new ArrayList<>();

    public HeaderProfileAdapter(List<String> user_list) {
        this.user_list = user_list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header_feed, parent, false);
        HeaderItemViewHolder headerItemViewHolder = new HeaderItemViewHolder(view);

        return headerItemViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HeaderItemViewHolder headerItemViewHolder = (HeaderItemViewHolder) holder;
        headerItemViewHolder.bind();
    }

    @Override
    public int getItemCount() {
        return user_list.size();
    }
}


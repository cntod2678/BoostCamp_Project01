package company.co.kr.project1.Feed.Header;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import company.co.kr.project1.CircleTransform;
import company.co.kr.project1.R;

/**
 * Created by Dongjin on 2017. 7. 5..
 */

public class HeaderProfileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    List<Integer> user_list = new ArrayList<>();

    public HeaderProfileAdapter(Context context, List<Integer> user_list) {
        mContext = context;
        this.user_list = user_list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header_profile_feed, parent, false);
        HeaderItemViewHolder headerItemViewHolder = new HeaderItemViewHolder(view);

        return headerItemViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HeaderItemViewHolder headerItemViewHolder = (HeaderItemViewHolder) holder;
        Picasso.with(mContext)
                .load(user_list.get(position))
                .resize(200, 200)
                .centerCrop()
                .transform(new CircleTransform())
                .into(headerItemViewHolder.header_profile_imgButton);
    }

    @Override
    public int getItemCount() {
        return user_list.size();
    }
}


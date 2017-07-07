package company.co.kr.project1.Feed;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import company.co.kr.project1.Feed.Header.HeaderProfileAdapter;
import company.co.kr.project1.Feed.Item.HeaderMakeViewHolder;
import company.co.kr.project1.Feed.Item.HeaderProfileViewHolder;
import company.co.kr.project1.Feed.Item.ItemViewHolder;
import company.co.kr.project1.R;

public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 1;
    private static final int TYPE_HEADER_PROFILE = 2;
    private static final int TYPE_HEADER_MAKE = 3;

    Context mContext;

    List<FeedItem> feedItemList = new ArrayList<>();
    List<Integer> header_user_list = new ArrayList<>();


    public FeedAdapter(Context context, List<FeedItem> feedItemList) {
        this.feedItemList = feedItemList;
        mContext = context;

        header_user_list.add(R.drawable.ronaldo);
        header_user_list.add(R.drawable.messi);
        header_user_list.add(R.drawable.dybala);
        header_user_list.add(R.drawable.pogba);
        header_user_list.add(R.drawable.joohyun);
        header_user_list.add(R.drawable.jiwon);
        header_user_list.add(R.drawable.morata);
        header_user_list.add(R.drawable.hummels);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEADER_PROFILE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_feed_profile, parent, false);
            HeaderProfileViewHolder headerProfileViewHolder = new HeaderProfileViewHolder(mContext, view, header_user_list);

            return headerProfileViewHolder;
        }
        else if(viewType == TYPE_HEADER_MAKE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_feed_make, parent, false);
            HeaderMakeViewHolder headerMakeViewHolder = new HeaderMakeViewHolder(view);

            return headerMakeViewHolder;
        }
        else if(viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed_recyclerview, parent, false);
            ItemViewHolder vi = new ItemViewHolder(mContext, view);

            return vi;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == TYPE_HEADER_PROFILE) {
            // Header ViewHolder
            HeaderProfileViewHolder headerProfileViewHolder = (HeaderProfileViewHolder) holder;
        }
        else if(getItemViewType(position) == TYPE_HEADER_MAKE) {
            HeaderMakeViewHolder headerMakeViewHolder = (HeaderMakeViewHolder) holder;
            headerMakeViewHolder.bind();
        }
        else {
            // ItemViewHolder
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.bind(feedItemList.get(position-2));
        }
    }

    /* Return viewType for a given position (Header or Item) */
    @Override
    public int getItemViewType(int position) {
        if (getTypePosition(position) == TYPE_HEADER_PROFILE)
            return TYPE_HEADER_PROFILE;
        else if (getTypePosition(position) == TYPE_HEADER_MAKE)
            return TYPE_HEADER_MAKE;
        return TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        // Contain The Header of RecyclerView + 2
        return feedItemList.size() + 2;
    }

    private int getTypePosition(int position) {
        if(position == 0)
            return TYPE_HEADER_PROFILE;
        else if(position == 1)
            return TYPE_HEADER_MAKE;
        else
            return TYPE_ITEM;
    }
}

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
import company.co.kr.project1.R;

public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 1;
    private static final int TYPE_HEADER = 2;

    Context mContext;

    List<FeedItem> feedItemList = new ArrayList<>();
    List<String> header_list = new ArrayList<>();


    public FeedAdapter(Context context, List<FeedItem> feedItemList) {
        this.feedItemList = feedItemList;
        mContext = context;

        header_list.add("a");
        header_list.add("b");
        header_list.add("c");
        header_list.add("c");
        header_list.add("c");
        header_list.add("c");
        header_list.add("c");
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_feed, parent, false);
            HeaderViewHolder vh = new HeaderViewHolder(view);

            return vh;
        }
        else if(viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed_recyclerview, parent, false);
            ItemViewHolder vi = new ItemViewHolder(view);

            return vi;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(isPositionHeader(position)) {
            // Header ViewHolder
            HeaderViewHolder hvh = (HeaderViewHolder) holder;
        }
        else {
            // Item ViewHolder
            ItemViewHolder ivh = (ItemViewHolder) holder;
            ivh.bind(feedItemList.get(position-1));
        }
    }

    /* Returns viewType for a given position (Header or Item) */
    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position)) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        // Contain The Header of RecyclerView + 1
        return feedItemList.size() + 1;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView header_recyclerView;

        public HeaderViewHolder(View headerView) {
            super(headerView);
            header_recyclerView = (RecyclerView) headerView.findViewById(R.id.header_recyclerView);

            HeaderProfileAdapter headerAdapter = new HeaderProfileAdapter(header_list);

            LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
            header_recyclerView.setLayoutManager(layoutManager);
            header_recyclerView.setAdapter(headerAdapter);
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView cardView_item_profile_imgView;
        private TextView cardView_item_userId_txtView;

        private TextView cardView_item_title_txtView;
        private ImageView cardView_item_imgView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            cardView_item_profile_imgView = (ImageView) itemView.findViewById(R.id.cardView_item_profile_imgView);
            cardView_item_userId_txtView = (TextView) itemView.findViewById(R.id.cardView_item_userId_txtView);
            cardView_item_title_txtView = (TextView) itemView.findViewById(R.id.cardView_item_title_txtView);
            cardView_item_imgView = (ImageView) itemView.findViewById(R.id.cardView_item_imgView);

        }

        public void bind(FeedItem feedItem) {
            cardView_item_profile_imgView.setImageResource(feedItem.getProfileImg());
            cardView_item_userId_txtView.setText(feedItem.getUser_id());
            cardView_item_title_txtView.setText(feedItem.getTitle());
            cardView_item_imgView.setImageResource(feedItem.getImgSrc());
        }
    }
}

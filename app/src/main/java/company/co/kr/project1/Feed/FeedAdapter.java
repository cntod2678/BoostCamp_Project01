package company.co.kr.project1.Feed;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import company.co.kr.project1.R;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ItemViewHolder> {

    List<FeedItem> feedItemList = new ArrayList<>();

    public FeedAdapter(List<FeedItem> feedItemList) {
        this.feedItemList = feedItemList;
    }

    @Override
    public FeedAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed_recyclerview_list, parent, false);
        ItemViewHolder vh = new ItemViewHolder(view);

        return (vh);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.bind(feedItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return feedItemList.size();
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

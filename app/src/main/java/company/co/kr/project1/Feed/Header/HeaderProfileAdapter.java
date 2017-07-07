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

    private static final int TYPE_ITEM = 1;
    private static final int TYPE_HEADER = 2;

    public HeaderProfileAdapter(Context context, List<Integer> user_list) {
        mContext = context;
        this.user_list = user_list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_profile_header, parent, false);
            HeaderMessageHeaderViewHolder headerMessageHeaderViewHolder = new HeaderMessageHeaderViewHolder(view);

            return headerMessageHeaderViewHolder;
        }
        else if(viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header_profile_feed, parent, false);
            HeaderItemViewHolder headerItemViewHolder = new HeaderItemViewHolder(view);

            return headerItemViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == TYPE_HEADER) {
            HeaderMessageHeaderViewHolder headerMessageHeaderViewHolder = (HeaderMessageHeaderViewHolder) holder;

        } else {
            HeaderItemViewHolder headerItemViewHolder = (HeaderItemViewHolder) holder;
            Picasso.with(mContext)
                    .load(user_list.get(position-1))
                    .resize(152, 152)
                    .centerCrop()
                    .transform(new CircleTransform())
                    .into(headerItemViewHolder.header_profile_imgButton);
        }
    }

    /* Return viewType for a given position (Header or Item) */
    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;
        return TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return user_list.size()+1;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }
}


package company.co.kr.project1.Feed.HeaderMessage;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import company.co.kr.project1.R;

/**
 * Created by Dongjin on 2017. 7. 5..
 */

public class HeaderMessageItemViewHolder extends RecyclerView.ViewHolder {
    protected ImageButton header_profile_imgButton;

    public HeaderMessageItemViewHolder(View headerItemView) {
        super(headerItemView);
        header_profile_imgButton = (ImageButton) headerItemView.findViewById(R.id.header_profile_imgButton);
    }
}
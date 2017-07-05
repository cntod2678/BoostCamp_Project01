package company.co.kr.project1.Feed.Header;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import company.co.kr.project1.R;

/**
 * Created by Dongjin on 2017. 7. 5..
 */

public class HeaderItemViewHolder extends RecyclerView.ViewHolder {
    private ImageButton header_profile_imgButton;

    public HeaderItemViewHolder(View headerItemView) {
        super(headerItemView);
        header_profile_imgButton = (ImageButton) headerItemView.findViewById(R.id.header_profile_imgButton);
    }

    public void bind() {
        header_profile_imgButton.setImageResource(R.drawable.cdj);
    }
}
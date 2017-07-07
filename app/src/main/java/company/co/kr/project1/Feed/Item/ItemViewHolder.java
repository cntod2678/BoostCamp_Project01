package company.co.kr.project1.Feed.Item;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import company.co.kr.project1.Feed.FeedItem;
import company.co.kr.project1.R;

/**
 * Created by Dongjin on 2017. 7. 7..
 */

public class ItemViewHolder extends RecyclerView.ViewHolder {
    Context mContext;

    private ImageView cardView_item_profile_imgView;
    private TextView cardView_item_userId_txtView;

    private TextView cardView_item_title_txtView;
    private ImageView cardView_item_imgView;

    private TextView cardView_item_likeCnt;
    private TextView cardView_item_commentCnt;

    private Button cardView_item_like_button;
    private Button cardView_item_comment_button;
    private Button cardView_item_share_button;

    public ItemViewHolder(final Context mContext, View itemView) {
        super(itemView);
        this.mContext = mContext;

        cardView_item_profile_imgView = (ImageView) itemView.findViewById(R.id.cardView_item_profile_imgView);
        cardView_item_userId_txtView = (TextView) itemView.findViewById(R.id.cardView_item_userId_txtView);

        cardView_item_title_txtView = (TextView) itemView.findViewById(R.id.cardView_item_title_txtView);
        cardView_item_imgView = (ImageView) itemView.findViewById(R.id.cardView_item_imgView);

        cardView_item_likeCnt = (TextView) itemView.findViewById(R.id.cardView_item_likeCnt);
        cardView_item_commentCnt = (TextView) itemView.findViewById(R.id.cardView_item_commentCnt);

        cardView_item_like_button = (Button) itemView.findViewById(R.id.cardView_item_like_button);
        cardView_item_comment_button = (Button) itemView.findViewById(R.id.cardView_item_comment_button);
        cardView_item_share_button = (Button) itemView.findViewById(R.id.cardView_item_share_button);
    }

    public void bind(FeedItem feedItem) {
        cardView_item_profile_imgView.setImageResource(feedItem.getProfileImg());
        cardView_item_userId_txtView.setText(feedItem.getUser_id());

        cardView_item_title_txtView.setText(feedItem.getTitle());
        cardView_item_imgView.setImageResource(feedItem.getImgSrc());

        cardView_item_likeCnt.setText(Integer.toString(feedItem.getLike()) + "개");
        cardView_item_commentCnt.setText(Integer.toString(feedItem.getComment()) + "개");

        cardView_item_like_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "좋아요 클릭", Toast.LENGTH_SHORT).show();
            }
        });

        cardView_item_comment_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "댓글 달기 클릭", Toast.LENGTH_SHORT).show();
            }
        });

        cardView_item_share_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "공유하기 클릭", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

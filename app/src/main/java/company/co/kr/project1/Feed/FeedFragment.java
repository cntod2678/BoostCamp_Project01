package company.co.kr.project1.Feed;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import company.co.kr.project1.R;

public class FeedFragment extends Fragment {

    static RecyclerView feedRecyclerView;
    List<FeedItem> feedItemList = new ArrayList<>();


    //    public FeedItem(String type, String user_id, String title, String content, int imgSrc, int like, int comment) {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        feedItemList.add(new FeedItem("인기방송", "DongJin", "나의 부스트캠프 참여기", "좋았다", R.drawable.cdj ,R.drawable.boostcamp, 10, 102));
        feedItemList.add(new FeedItem(null, "DongJin", "에이핑크 컴백!", "와우~", R.drawable.cdj, R.drawable.apink, 1000, 10002));
        feedItemList.add(new FeedItem("인기방송", "DongJin", "안드로이드 개바하자", "C조 화이팅", R.drawable.cdj, R.drawable.android, 99999, 99999));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_feed, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        feedRecyclerView = (RecyclerView) view.findViewById(R.id.feed_recyclerView);
        FeedAdapter feedAdapter = new FeedAdapter(getContext(), feedItemList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        feedRecyclerView.setLayoutManager(layoutManager);
        feedRecyclerView.setAdapter(feedAdapter);
    }

    public static void moveToTop() {
        feedRecyclerView.smoothScrollToPosition(0);
    }
}

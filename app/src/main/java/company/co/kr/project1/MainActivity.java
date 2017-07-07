package company.co.kr.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import company.co.kr.project1.Feed.FeedFragment;

public class MainActivity extends AppCompatActivity {

    private TabLayout mainTabLayout;
    private ViewPager mainViewPager;
    private MainPagerAdapter mainPagerAdapter;
    private Toolbar mainToolbar;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setEvent();
    }

    private void initView() {
        mainToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        mainViewPager = (ViewPager) findViewById(R.id.main_viewPager);
        mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        mainViewPager.setAdapter(mainPagerAdapter);

        mainTabLayout = (TabLayout) findViewById(R.id.main_tabLayout);
        mainTabLayout.setupWithViewPager(mainViewPager);
        setTabs();

        fab = (FloatingActionButton) findViewById(R.id.main_floatingActionButton);
    }

    private void setEvent() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "글쓰기 버튼", Toast.LENGTH_SHORT).show();
            }
        });

        mainTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0) {
                    FeedFragment.moveToTop();
                }
            }
        });
    }

    private void setTabs() {
        mainTabLayout.getTabAt(0).setIcon(R.drawable.feed_selector);
        mainTabLayout.getTabAt(1).setIcon(R.drawable.friends_selector);
        mainTabLayout.getTabAt(2).setIcon(R.drawable.notification_selector);
        mainTabLayout.getTabAt(3).setIcon(R.drawable.menu_selector);
    }

    public void onCameraButtonClicked(View view) {
        Toast.makeText(getApplicationContext(), "카메라 버튼 클릭입니다.", Toast.LENGTH_SHORT).show();
    }

    public void onMessageButtonClicked(View view) {
        Toast.makeText(getApplicationContext(), "메세지 버튼 클릭입니다.", Toast.LENGTH_SHORT).show();
    }

}

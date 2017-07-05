package company.co.kr.project1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;

import company.co.kr.project1.Feed.FeedFragment;
import company.co.kr.project1.Friends.FriendsFragment;
import company.co.kr.project1.Menu.MenuFragment;
import company.co.kr.project1.Notification.NotificationFragment;

/**
 * Created by Dongjin on 2017. 7. 4..
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if(position == 0) {
            fragment = new FeedFragment();
        }
        else if(position == 1) {
            fragment = new FriendsFragment();
        }
        else if(position == 2) {
            fragment = new NotificationFragment();
        }
        else {
            fragment = new MenuFragment();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}

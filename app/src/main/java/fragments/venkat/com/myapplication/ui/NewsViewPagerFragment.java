package fragments.venkat.com.myapplication.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fragments.venkat.com.myapplication.R;


/**
 * Created by venkatgonuguntala on 8/11/16.
 */

public class NewsViewPagerFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viewpager, container, false);


        final PoliticsFragment politicsFragment = new PoliticsFragment();
        /*FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();*/
        final HealthFragment healthFragment = new HealthFragment();
        final WorldFragment unitedStatesFragment = new WorldFragment();
        final BusinessFragment businessFragment = new BusinessFragment();


        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                switch (position) {
                    case 0:
                        return politicsFragment;
                    case 1:
                        return businessFragment;
                    case 2:
                        return unitedStatesFragment;
                    case 3:
                        return healthFragment;
                }
                return null;
            }

            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return getString(R.string.title_section1).toUpperCase();
                    case 1:
                        return getString(R.string.title_section2).toUpperCase();
                    case 2:
                        return getString(R.string.title_section3).toUpperCase();
                    case 3:
                        return  getString(R.string.title_section4).toUpperCase();
                }
                return null;
            }

        });

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }

}

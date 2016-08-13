package fragments.venkat.com.myapplication;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import fragments.venkat.com.myapplication.model.Result;
import fragments.venkat.com.myapplication.ui.DetailFragment;
import fragments.venkat.com.myapplication.ui.NewsViewPagerFragment;
import fragments.venkat.com.myapplication.ui.PoliticsFragment;

public class MainActivity extends AppCompatActivity implements PoliticsFragment.onHeadLinesSelectedInterface {

    public static final String VIEW_PAGER_LIST_FRAGMENT = "list_fragment";
    public static final String DETAIL_FRAGMENT = "detail_fragment" ;
    /*@Override
    public void onBackPressed() {
        super.onBackPressed();
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean isTablet = getResources().getBoolean(R.bool.is_tablet);


        NewsViewPagerFragment savedFragment = (NewsViewPagerFragment) getSupportFragmentManager().findFragmentByTag(VIEW_PAGER_LIST_FRAGMENT);
        if ( savedFragment == null) {
            NewsViewPagerFragment viewPagerFragment = new NewsViewPagerFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.placeHolder, viewPagerFragment, VIEW_PAGER_LIST_FRAGMENT);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onHeadLinesItemSelected(int index, List<Result> resultList) {
        //Toast.makeText(this, index+"", Toast.LENGTH_LONG).show();
        DetailFragment detailFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(DetailFragment.TITLE, resultList.get(index).getTitle());
        bundle.putString(DetailFragment.DATE_PUBLISHED, resultList.get(index).getPublishedDate());
        detailFragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeHolder, detailFragment, DETAIL_FRAGMENT);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }



}

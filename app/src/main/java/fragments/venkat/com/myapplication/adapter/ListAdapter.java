package fragments.venkat.com.myapplication.adapter;

import android.support.v4.app.ListFragment;

import java.util.List;

import fragments.venkat.com.myapplication.R;
import fragments.venkat.com.myapplication.model.Result;
import fragments.venkat.com.myapplication.ui.PoliticsFragment;

/**
 * Created by venkatgonuguntala on 8/12/16.
 */

public class ListAdapter extends HeadLinesListAdapter {
    private final PoliticsFragment.onHeadLinesSelectedInterface mListener;

    public ListAdapter(PoliticsFragment.onHeadLinesSelectedInterface listener) {
        mListener = listener;
    }

    @Override
    protected int getLayout() {
        return R.layout.news_list_item;
    }

    @Override
    protected void onHeadLinesItemSelected(int index, List<Result> resultList) {
        mListener.onHeadLinesItemSelected(index, resultList);
    }
}

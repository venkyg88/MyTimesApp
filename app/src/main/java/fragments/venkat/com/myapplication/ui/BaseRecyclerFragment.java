package fragments.venkat.com.myapplication.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fragments.venkat.com.myapplication.R;
import fragments.venkat.com.myapplication.adapter.HeadLinesListAdapter;
import fragments.venkat.com.myapplication.adapter.ListAdapter;
import fragments.venkat.com.myapplication.api.NewYorkTimesApi;
import fragments.venkat.com.myapplication.controller.Access;

/**
 * Created by venkatgonuguntala on 8/11/16.
 */

public abstract class BaseRecyclerFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
    private final static String TAG = BaseRecyclerFragment.class.getSimpleName();

    protected NewYorkTimesApi mNewYorkTimesApi;
    protected HeadLinesListAdapter mHeadLinesListAdapter;
    protected SwipeRefreshLayout mSwipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        PoliticsFragment.onHeadLinesSelectedInterface listener = (PoliticsFragment.onHeadLinesSelectedInterface) getActivity();
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        mNewYorkTimesApi = Access.getInstance().getNewYorkTimesAPi();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        mHeadLinesListAdapter = new ListAdapter(listener);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        getHeadlinesFromApi();

        recyclerView.setAdapter(mHeadLinesListAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        return view;
    }

    void onItemsLoadComplete() {
        // Update the adapter and notify data set changed
        // ...

        // Stop refresh animation
        mSwipeRefreshLayout.setRefreshing(false);
    }

    public abstract void getHeadlinesFromApi();

}

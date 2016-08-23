package fragments.venkat.com.myapplication.ui;

import android.util.Log;

import java.util.List;

import fragments.venkat.com.myapplication.model.Politics;
import fragments.venkat.com.myapplication.model.Result;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static fragments.venkat.com.myapplication.util.Constant.apiKey;

/**
 * Created by venkatgonuguntala on 8/11/16.
 */

public class PoliticsFragment extends BaseRecyclerFragment {
    private final static String TAG = PoliticsFragment.class.getSimpleName();


    @Override
    public void getHeadlinesFromApi() {

        mNewYorkTimesApi.getPoliticsCategory(apiKey, new Callback<Politics>() {
            @Override
            public void success(Politics politics, Response response) {
                List<Result> resultList = politics.getResults();

                mHeadLinesListAdapter.setResultsList(resultList);
                mHeadLinesListAdapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(TAG, error+"Retrofit Failure");
            }
        });

        onItemsLoadComplete();
    }

    @Override
    public void onRefresh() {
        getHeadlinesFromApi();
    }



    public interface onHeadLinesSelectedInterface {
        void onHeadLinesItemSelected(int index, List<Result> resultList);
    }
}

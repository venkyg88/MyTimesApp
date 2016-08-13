package fragments.venkat.com.myapplication.ui;


import android.util.Log;
import java.util.List;
import fragments.venkat.com.myapplication.model.Business;
import fragments.venkat.com.myapplication.model.Result;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static fragments.venkat.com.myapplication.util.Constant.apiKey;

/**
 * Created by venkatgonuguntala on 8/11/16.
 */

public class BusinessFragment extends BaseRecyclerFragment {
    private final static String TAG = PoliticsFragment.class.getSimpleName();


    public void getHeadlinesFromApi() {

        mNewYorkTimesApi.getBusinessCategory(apiKey, new Callback<Business>() {
            @Override
            public void success(Business business, Response response) {
                List<Result> resultList = business.getResults();

                mHeadLinesListAdapter.setResultsList(resultList);
                mHeadLinesListAdapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e(TAG, error+"Retrofit Failure");
            }
        });
    }

    @Override
    public void onRefresh() {
        getHeadlinesFromApi();
    }
}

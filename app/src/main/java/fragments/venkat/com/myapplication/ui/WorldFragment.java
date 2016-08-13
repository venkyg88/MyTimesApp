package fragments.venkat.com.myapplication.ui;

import android.util.Log;

import java.util.List;

import fragments.venkat.com.myapplication.model.Result;
import fragments.venkat.com.myapplication.model.UnitedStates;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static fragments.venkat.com.myapplication.util.Constant.apiKey;

/**
 * Created by venkatgonuguntala on 8/11/16.
 */

public class WorldFragment extends BaseRecyclerFragment {
    public static final String TAG = UnitedStates.class.getSimpleName();


    public void getHeadlinesFromApi() {

        mNewYorkTimesApi.getUnitedStatesCategory(apiKey, new Callback<UnitedStates>() {
            @Override
            public void success(UnitedStates health, Response response) {
                List<Result> resultList = health.getResults();

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

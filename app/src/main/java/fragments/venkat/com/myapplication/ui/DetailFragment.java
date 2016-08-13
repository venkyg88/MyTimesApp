package fragments.venkat.com.myapplication.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fragments.venkat.com.myapplication.R;
import fragments.venkat.com.myapplication.model.Politics;
import fragments.venkat.com.myapplication.model.Result;

/**
 * Created by venkatgonuguntala on 8/12/16.
 */

public class DetailFragment extends Fragment {
    public static final String TAG = DetailFragment.class.getSimpleName();

    public static final String INDEX = "index";
    public static final String TITLE = "title";
    public static final String DATE_PUBLISHED = "date_published";

    private String mTitle;
    private String mDate;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        TextView titleTextView = (TextView) view.findViewById(R.id.detailTitle);
        TextView dateTextView = (TextView) view.findViewById(R.id.detailDate);
        Bundle bundle = getArguments();
        mTitle = bundle.getString(TITLE);
        mDate = bundle.getString(DATE_PUBLISHED);
        titleTextView.setText(mTitle);
        dateTextView.setText(mDate);
        return view;
    }

}

package fragments.venkat.com.myapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fragments.venkat.com.myapplication.R;
import fragments.venkat.com.myapplication.model.Politics;
import fragments.venkat.com.myapplication.model.Result;
import fragments.venkat.com.myapplication.ui.DetailFragment;

/**
 * Created by venkatgonuguntala on 8/11/16.
 */

public abstract class HeadLinesListAdapter extends RecyclerView.Adapter {

    private List<Result> mResult;

    public void setResultsList(List<Result> results) {
        mResult = results;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayout(), parent, false);
        return new PoliticsListViewHolder(view);
    }

    protected abstract int getLayout();

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((PoliticsListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        if (mResult != null) {
            return mResult.size();
        }
        return 0;
    }

    private class PoliticsListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private int mIndex;
        public PoliticsListViewHolder(View itemView) {
            super(itemView);
            mTitleTextView = (TextView) itemView.findViewById(R.id.itemTitle);
            mDateTextView = (TextView) itemView.findViewById(R.id.itemDatePublished);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position){
            mIndex = position;
            mTitleTextView.setText(mResult.get(position).getTitle());
            mDateTextView.setText(mResult.get(position).getPublishedDate());
        }

        @Override
        public void onClick(View v) {
            onHeadLinesItemSelected(mIndex, mResult);

        }
    }

    protected abstract void onHeadLinesItemSelected(int index, List<Result> result);
}

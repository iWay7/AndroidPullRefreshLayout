package site.iway.androidpullrefreshlayout;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import site.iway.androidhelpers.PullRefreshLayout;
import site.iway.androidhelpers.PullRefreshLayout.OnRefreshListener;
import site.iway.javahelpers.StringHelper;

public class MainActivity extends Activity {

    private Handler mHandler = new Handler();

    private PullRefreshLayout mPullRefreshLayout;
    private ListView mPullRefreshListView;
    private List<String> mListData;
    private ArrayAdapter<String> mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPullRefreshLayout = (PullRefreshLayout) findViewById(R.id.pullRefreshLayout);
        mPullRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(PullRefreshLayout pullRefreshLayout) {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mListData.clear();
                        for (int i = 0; i < 25; i++)
                            mListData.add(StringHelper.random(16));
                        mListAdapter.notifyDataSetChanged();
                        mPullRefreshLayout.setRefreshing(false);
                    }
                }, 3000);
            }
        });
        mPullRefreshListView = (ListView) findViewById(R.id.pullRefreshListView);
        mListData = new ArrayList<>();
        for (int i = 0; i < 25; i++)
            mListData.add(StringHelper.random(16));
        mListAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mListData);
        mPullRefreshListView.setAdapter(mListAdapter);
    }

}

package com.zhiyicx.zycx.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.adapter.ZiXunListAdapter;
import com.zhiyicx.zycx.activity.ZiXUnContentActivity;
import com.zhiyicx.zycx.sociax.listener.OnTouchListListener;
import com.zhiyicx.zycx.sociax.unit.Anim;
import com.zhiyicx.zycx.widget.LoadListView;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/1/14.
 */
public class ZiXunListFragment extends BaseListFragment {

    final private static String TAG = "ZiXunListFragment";
    private ZiXunListAdapter mAdapter = null;
    private LoadListView mListView = null;
    private int mType = 0;

    public static ZiXunListFragment newInstanse(int type)
    {
        ZiXunListFragment f= new ZiXunListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        f.setArguments(bundle);
        return f;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public OnTouchListListener getListView() {
        return mListView;
    }

    @Override
    public void doRefreshHeader() {
        if(mAdapter != null)
            mAdapter.doRefreshHeader();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(mCustView == null)
            mCustView = inflater.inflate(R.layout.zixun_list, container, false);
        Bundle bundle = getArguments();
        mType = bundle.getInt("type");
        mListView = (LoadListView) mCustView.findViewById(R.id.zixun_list);
        mListView.setOnItemListener(new LoadListView.OnItemListener() {
            @Override
            public void onClick(View view, int position, long id) {
                Log.d(TAG, "get ZiXunlist item click position : " + position);
                JSONObject jsonObject = mAdapter.getItem(position - 1);
                try {
                    int _id = jsonObject.getInt("id");
                    int uid = jsonObject.getInt("uid");
                    String title = jsonObject.getString("title");
                    Intent intent = new Intent(mContext, ZiXUnContentActivity.class);
                    intent.putExtra("id", _id);
                    intent.putExtra("uid", uid);
                    intent.putExtra("title", title);
                    //intent.putExtra("cid", mType);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);
                    Anim.in(mContext);
                    }catch (Exception e)
                    {
                        e.printStackTrace();
                    }
            }
        });
        ArrayList<JSONObject> data = new ArrayList<JSONObject>();
        mAdapter = new ZiXunListAdapter(this, data, mType);
        mListView.setAdapter(mAdapter, System.currentTimeMillis(), mContext);
        loadData(false);
        return mCustView;
    }

    @Override
    public void loadData(boolean isLoadNew) {
        if(mType == 0)
            mAdapter.loadHomeInitData();
        else
            mAdapter.loadInitData();
        mListView.setSelectionFromTop(0, 20);
    }
}

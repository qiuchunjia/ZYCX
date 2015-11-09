package com.zhiyicx.zycx.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.adapter.ListFragmentAdapter;
import com.zhiyicx.zycx.config.MyConfig;
import com.zhiyicx.zycx.activity.SearchActivity;
import com.zhiyicx.zycx.net.JsonDataListener;
import com.zhiyicx.zycx.net.NetComTools;
import com.zhiyicx.zycx.sociax.component.LoadingView;
import com.zhiyicx.zycx.sociax.unit.Anim;
import com.zhiyicx.zycx.util.Utils;
import com.zhiyicx.zycx.widget.PagerSlidingTabStrip;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ZiXunFragment extends Fragment {

    final private static String TAG = "ZiXunFragment";

    private ViewPager mPager;
    private PagerSlidingTabStrip mTabs;
    private LinearLayout mProgress = null;
    private Context mContext = null;
    private ArrayList<Fragment> mFragmentList = null;
    private LoadingView mLoadingView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zixunfragment, null);
        //mProgress = (LinearLayout)view.findViewById(R.id.prog_layout);
        mLoadingView = (LoadingView) view.findViewById(LoadingView.ID);
        mPager = (ViewPager) view.findViewById(R.id.vPager);
        mTabs = (PagerSlidingTabStrip) view.findViewById(R.id.sliding_tabs);
        view.findViewById(R.id.btn_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SearchActivity.class);
                intent.putExtra("type", 2);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
                Anim.in((Activity) mContext);
            }
        });
        mLoadingView.show(mPager);
        mLoadingView.show(mTabs);
        initTabsData();
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
    }

    private void initTabsData() {
        String url = MyConfig.ZIXUN_LIST_URL + Utils.getTokenString(mContext) + "&limit=1&cid=1";
        NetComTools.getInstance(mContext).getNetJson(url, new JsonDataListener() {
            @Override
            public void OnReceive(JSONObject jsonObject) {
                //Log.d(TAG, "ZiXun list tables:" + jsonObject.toString());
                try {
                    int code = jsonObject.getInt("code");
                    if (code == 0 || code == 10100) {
                        JSONObject data = (JSONObject) jsonObject.get("data");
                        final JSONArray fenleiArray = data.getJSONArray("fenlei");
                        String titles[] = new String[fenleiArray.length() + 2];
                        mFragmentList = new ArrayList<Fragment>();
                        titles[0] = "全部";
                        BaseListFragment baseListFragment = ZiXunListFragment.newInstanse(0);
                        baseListFragment.setFinishLoadListener(new BaseListFragment.FinishLoadListener() {
                            @Override
                            public void OnFinish() {
                                mLoadingView.hide(mPager);
                                mLoadingView.hide(mTabs);
                            }
                        });
                        mFragmentList.add(baseListFragment);
                        try {
                            for (int i = 0; i < fenleiArray.length(); i++) {
                                JSONObject jsonObject1 = (JSONObject) fenleiArray.get(i);
                                String title = jsonObject1.get("title").toString();
                                int id = jsonObject1.getInt("fenlei_id");
                                titles[i + 1] = title;
                                mFragmentList.add(ZiXunListFragment.newInstanse(id));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        titles[fenleiArray.length() + 1] = "收藏";
                        mFragmentList.add(ZiXunListFragment.newInstanse(-1));
                        ListFragmentAdapter adapter = new ListFragmentAdapter(
                                ZiXunFragment.this.getChildFragmentManager(), mFragmentList, titles);
                        mPager.setAdapter(adapter);
                        mTabs.setOnPageChangeListener(new MyOnPageChangeListener());
                        mTabs.setViewPager(mPager);
                        setTabsValue();
                        //mPager.setCurrentItem(0, false);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void OnError(String error) {
                Log.d(TAG, "Get ZiXun tables error, " + error);
            }
        });
    }

    private void setTabsValue() {
        // 设置Tab是自动填充满屏幕的
        mTabs.setShouldExpand(true);
        // 设置Tab的分割线是透明的
        mTabs.setDividerColor(Color.TRANSPARENT);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        // 设置Tab底部线的高度
        mTabs.setUnderlineHeight((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 1, dm));
        // 设置Tab Indicator的高度
        mTabs.setIndicatorHeight((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 4, dm));
        // 设置Tab标题文字的大小
        mTabs.setTextSize((int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 16, dm));
        // 设置Tab Indicator的颜色
        mTabs.setIndicatorColor(Color.parseColor("#45c01a"));
        // 设置选中Tab文字的颜色 (这是我自定义的一个方法)
        mTabs.setSelectedTextColor(Color.parseColor("#45c01a"));
        // 取消点击Tab时的背景色
        mTabs.setTabBackground(0);
    }


    public class MyOnPageChangeListener implements OnPageChangeListener {

        public void onPageScrollStateChanged(int arg0) {
        }

        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        public void onPageSelected(int arg0) {
            if (mFragmentList != null && !mFragmentList.isEmpty()) {
                BaseListFragment fragment = (BaseListFragment) mFragmentList.get(arg0);
                fragment.doRefreshHeader();
            }
        }
    }


}

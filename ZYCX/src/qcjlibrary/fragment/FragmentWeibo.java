package qcjlibrary.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import qcjlibrary.activity.SearchNewActivity.OnSearchTouchListerer;
import qcjlibrary.config.Config;

import com.umeng.socialize.utils.Log;
import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.adapter.SearchWeiboListAdapter;
import com.zhiyicx.zycx.fragment.BaseListFragment;
import com.zhiyicx.zycx.sociax.android.Thinksns;
import com.zhiyicx.zycx.sociax.listener.OnTouchListListener;
import com.zhiyicx.zycx.sociax.modle.ListData;
import com.zhiyicx.zycx.sociax.modle.SociaxItem;
import com.zhiyicx.zycx.widget.WeiboList;

public class FragmentWeibo extends BaseListFragment {
	private SearchWeiboListAdapter mWeiboAdapter;
	private WeiboList mWeibolist;
	private String key = null;
	private boolean isLoad = false;
	private Thinksns mApp = new Thinksns();

	@Override
	public OnTouchListListener getListView() {
		return mWeibolist;
	}

	@Override
	public void doRefreshHeader() {
		if (mWeiboAdapter != null)
			mWeiboAdapter.doRefreshHeader();
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mCustView = inflater.inflate(R.layout.web_list_layout, container, false);
		mWeibolist = (WeiboList) mCustView.findViewById(R.id.weiboList_home);
		ListData<SociaxItem> data = new ListData<SociaxItem>();
		mWeiboAdapter = new SearchWeiboListAdapter(this, data, key);
		mWeibolist.setAdapter(mWeiboAdapter, System.currentTimeMillis(), mContext);
		mWeibolist.setVisibility(View.INVISIBLE);
		return mCustView;
	}

	@Override
	public void onStart() {
		super.onStart();

	}

	@Override
	public void onResume() {
		super.onResume();
		if (!isLoad)
			loadData(false);
	}

	@Override
	public void loadData(boolean isLoadNew) {

		if(mApp.searchAct == null){
			return;
		}
		mApp.searchAct.setOnSearchListener(new OnSearchTouchListerer() {

			@Override
			public void onSearchTouch(String key, int searchType) {
				// TODO 自动生成的方法存根
				Log.d("Cathy", "weibo:" + key + " searchType:" + searchType);
				if (searchType == Config.TYPE_WEIBO) {
					Log.d("Cathy", "weibo:" + key);
					mWeiboAdapter.loadSearchData(key);
					mWeibolist.setSelectionFromTop(0, 20);
					isLoad = true;
				}
			}
		});
	}

	public void doSearch(String key) {
		if (TextUtils.isEmpty(key))
			return;
		this.key = key;
		if (mContext != null) {
			loadData(false);
		}
	}

}

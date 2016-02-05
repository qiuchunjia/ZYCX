package qcjlibrary.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import qcjlibrary.activity.SearchNewActivity.OnSearchTouchListerer;
import qcjlibrary.config.Config;
import qcjlibrary.util.L;

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
	private boolean isCreate = false;

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
		mWeiboAdapter.loadSearchData("");
		return mCustView;
	}

	@Override
	public void onStart() {
		super.onStart();

	}

	@Override
	public void onResume() {
		super.onResume();
		/*if (!isLoad)
			loadData(false);*/
		loadData(false);
	}

	@Override
	public void loadData(boolean isLoadNew) {
		
		Thinksns.searchAct.setOnSearchListener(new OnSearchTouchListerer() {
			
			@Override
			public void onSearchTouch_Weibo(String key) {
				// TODO 自动生成的方法存根
				setKey(key);
				mWeiboAdapter.loadSearchData(key);
				mWeibolist.setSelectionFromTop(0, 20);
				isLoad = true;
			}
			
			@Override
			public void onSearchTouch_Request(String key) {
			}
			
			@Override
			public void onSearchTouch_Qclass(String key) {
			}
			
			@Override
			public void onSearchTouch_Info(String key) {
			}
			
			@Override
			public void onSearchTouch_Food(String key) {
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

	private void setKey(String key){
    	this.key = key;
    }
	
	 //仅当可见时才加载内容，防止fragment在不可见时加载内容，消耗资源
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
    	// TODO 自动生成的方法存根
    	super.setUserVisibleHint(isVisibleToUser);
    	
    	if(!isCreate){
    		return;
    	}
    	if(isVisibleToUser){
//    		loadData(false);
    	}
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	// TODO 自动生成的方法存根
    	super.onCreate(savedInstanceState);
    	isCreate = true;
    }
}

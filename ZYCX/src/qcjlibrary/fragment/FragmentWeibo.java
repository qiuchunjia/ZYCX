package qcjlibrary.fragment;
import java.util.ArrayList;

import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.sociax.modle.SociaxItem;
import com.zhiyicx.zycx.widget.WeiboList;

import android.view.View;
import qcjlibrary.activity.SearchNewActivity.OnSearchTouchListerer;
import qcjlibrary.config.Config;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.listview.base.CommonListView;

public class FragmentWeibo extends BaseFragment {

	private WeiboList weiboList_search;
	private SociaxItem mItem;
	private ArrayList<SociaxItem> mItemList;

	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void initIntentData() {
		// TODO 自动生成的方法存根

	}

	@Override
	public int getLayoutId() {
		// TODO 自动生成的方法存根
		return R.layout.fragment_search_web;
	}

	@Override
	public void initView() {
		weiboList_search = (WeiboList) findViewById(R.id.weiboList_search);
	}

	@Override
	public void initListener() {
		// TODO 自动生成的方法存根

	}

	@Override
	public void initData() {
		mItemList = new ArrayList<SociaxItem>();
		
		mApp.searchAct.setOnSearchListener(new OnSearchTouchListerer() {

			@Override
			public void onSearchTouch(String key, int searchType) {
				// TODO 自动生成的方法存根
				if (searchType == Config.TYPE_WEIBO) {

				}
			}
		});
	}

	
}

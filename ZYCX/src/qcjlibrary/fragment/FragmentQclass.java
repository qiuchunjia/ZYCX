package qcjlibrary.fragment;

import com.umeng.socialize.utils.Log;
import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.sociax.android.Thinksns;

import android.view.View;
import qcjlibrary.activity.SearchNewActivity.OnSearchTouchListerer;
import qcjlibrary.config.Config;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.listview.base.CommonListView;

public class FragmentQclass extends BaseFragment {

	private CommonListView mCommonListView;

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
		return R.layout.fragment_search;
	}

	@Override
	public void initView() {
		mCommonListView = (CommonListView) findViewById(R.id.mCommonListView);
	}

	@Override
	public void initListener() {
		// TODO 自动生成的方法存根

	}

	@Override
	public void initData() {
		mApp.searchAct.setOnSearchListener(new OnSearchTouchListerer() {
			
			@Override
			public void onSearchTouch(String key, int searchType) {
				if(searchType == Config.TYPE_QCLASS){
					
				}
				
			}
		});
	}

}

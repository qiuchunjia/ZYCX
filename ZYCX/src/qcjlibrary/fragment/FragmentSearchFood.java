package qcjlibrary.fragment;

import com.zhiyicx.zycx.R;

import android.view.View;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.listview.base.CommonListView;

public class FragmentSearchFood extends BaseFragment{

	/** 搜索的种类 **/
	private int state = 0;
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
		// TODO 自动生成的方法存根
		
	}

}

package qcjlibrary.fragment;

import qcjlibrary.adapter.PraiseAdapter;
import qcjlibrary.adapter.base.OnRequestLinstner;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.listview.base.CommonListView;
import qcjlibrary.util.DefaultLayoutUtil;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午3:13:46 类描述：这个类是实现
 *
 */

public class FragmentPraise extends BaseFragment {

	private CommonListView mCommonListView;
	private PraiseAdapter mAdapter;
	private LinearLayout ll_commonlist_parent;

	@Override
	public void initIntentData() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLayoutId() {
		return R.layout.listview_common_layout;
	}

	@Override
	public void initView() {
		mCommonListView = (CommonListView) findViewById(R.id.mCommonListView);
		ll_commonlist_parent = (LinearLayout) findViewById(R.id.ll_commonlist_parent);
		mCommonListView.setDividerHeight(5);
		mAdapter = new PraiseAdapter(this, null);
		mCommonListView.setAdapter(mAdapter);
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub
		mAdapter.setOnRequestLinstner(new OnRequestLinstner() {
			
			@Override
			public void onSuccess(View view) {
				DefaultLayoutUtil.hideDefault(ll_commonlist_parent, view);
			}
			
			@Override
			public void onFailed(View view) {
				DefaultLayoutUtil.showDefault(ll_commonlist_parent, view);
				TextView tv_reload = (TextView) view.findViewById(R.id.tv_reload);
				tv_reload.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						mAdapter.doRefreshNew();
					}
				});
			}
		});
	}

	@Override
	public void onClick(View v) {

	}

}

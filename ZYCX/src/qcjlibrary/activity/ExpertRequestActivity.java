package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.adapter.ExpertRequestAdapter;
import qcjlibrary.adapter.base.OnRequestLinstner;
import qcjlibrary.listview.base.CommonListView;
import qcjlibrary.util.DefaultLayoutUtil;
import qcjlibrary.util.DisplayUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午5:33:01 类描述：这个类是实现
 */

public class ExpertRequestActivity extends BaseActivity {
	private CommonListView mCommonListView;
	private ExpertRequestAdapter mAdapter;
	private LinearLayout ll_commonlist_parent;

	@Override
	public void onClick(View v) {

	}

	@Override
	public String setCenterTitle() {
		return "专家提问";
	}

	@Override
	public void initIntent() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.listview_common_layout;
	}

	@Override
	public void initView() {
		mCommonListView = (CommonListView) findViewById(R.id.mCommonListView);
		ll_commonlist_parent = (LinearLayout) findViewById(R.id.ll_commonlist_parent);
		mCommonListView.setDividerHeight(DisplayUtils.dp2px(mApp, 10));
		mAdapter = new ExpertRequestAdapter(this, null);
		mCommonListView.setAdapter(mAdapter);
	}

	@Override
	public Object onResponceSuccess(String str, Class class1) {
		Object object = super.onResponceSuccess(str, class1);
		// 用于更新同意后的adapter
		if (judgeTheMsg(object)) {
			mAdapter.doRefreshHeader();
		}
		return object;
	}

	@Override
	public void initData() {

	}

	@Override
	public void initListener() {
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

}

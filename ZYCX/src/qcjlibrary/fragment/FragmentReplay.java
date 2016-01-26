package qcjlibrary.fragment;

import qcjlibrary.activity.RequestDetailResponceActivity;
import qcjlibrary.adapter.ReplayAdapter;
import qcjlibrary.adapter.base.OnRequestLinstner;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.listview.base.CommonListView;
import qcjlibrary.model.ModelNotifyCommment;
import qcjlibrary.model.ModelRequestAnswerComom;
import qcjlibrary.util.DefaultLayoutUtil;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午3:13:46 类描述：这个类是实现
 *
 */

public class FragmentReplay extends BaseFragment {

	private CommonListView mCommonListView;
	private ReplayAdapter mAdapter;
	
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
		mAdapter = new ReplayAdapter(this, null);
		mCommonListView.setAdapter(mAdapter);

		mCommonListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				ModelNotifyCommment commment = (ModelNotifyCommment) parent
						.getItemAtPosition(position);
				if (!TextUtils.isEmpty(commment.getOriginal_answer_id())) {
					ModelRequestAnswerComom common = new ModelRequestAnswerComom();
					common.setAnswer_id(commment.getOriginal_answer_id());
					common.setComment_id(commment.getComment_id());
					common.setShoudGone(true);
					mCommonListView.stepToNextActivity(common,
							RequestDetailResponceActivity.class);
				}
			}
		});

	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initListener() {
		// TODO 监听是否请求数据成功
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
	
	@Override
	public View onRequestFailed() {
		// TODO 自动生成的方法存根
		return super.onRequestFailed();
	}
	
	@Override
	public View onRequestSuccess() {
		// TODO 自动生成的方法存根
		return super.onRequestSuccess();
	}

}

package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.activity.base.Title;
import qcjlibrary.adapter.ExpertRequestAdapter;
import qcjlibrary.adapter.base.OnRequestLinstner;
import qcjlibrary.listview.base.CommonListView;
import qcjlibrary.model.ModelRequestAsk;
import qcjlibrary.model.ModelRequestItem;
import qcjlibrary.model.ModelRequestMyAsk;
import qcjlibrary.util.DefaultLayoutUtil;
import qcjlibrary.util.DisplayUtils;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhiyicx.zycx.LoginActivity;
import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午5:33:01 类描述：这个类是实现
 */

public class ExpertRequestActivity extends BaseActivity {
	private CommonListView mCommonListView;
	private ExpertRequestAdapter mAdapter;
	private LinearLayout ll_commonlist_parent;
	private boolean fromIndex = false;
	private Title mTitle;
	private ModelRequestAsk mAsk;

	@Override
	public void onClick(View v) {

	}

	@Override
	public String setCenterTitle() {
		return "专家问答";
	}

	@Override
	public void initIntent() {
		Intent mIntent = getIntent();
		if (mIntent != null) {
			fromIndex = mIntent.getBooleanExtra("fromIndex", false);
			Log.d("Cathy", "fromIndex"+fromIndex);
		}
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
		mTitle = getTitleClass();
		if (fromIndex) {
			titleSetRightImage(R.drawable.chuangjianjingli);
			mAsk = new ModelRequestAsk();
			mAsk.setIs_expert("1");
		}
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

		mCommonListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				mCommonListView.stepToNextActivity(parent, view, position, RequestDetailExpertActivity.class);
			}
		});

		mTitle.iv_title_right1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (isLogin()) {
					mAsk.setIs_expert("1");
					// 获取病历信息，完善后才能提专家问答
					mApp.startActivity_qcj(ExpertRequestActivity.this, RequestSendTopicActivity.class,
							sendDataToBundle(mAsk, null));
				} else {
					mApp.startActivity_qcj(ExpertRequestActivity.this, LoginActivity.class, null);
				}
			}
		});
	}

}

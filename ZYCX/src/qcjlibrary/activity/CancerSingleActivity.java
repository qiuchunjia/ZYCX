package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.activity.base.Title;
import qcjlibrary.adapter.CancerTopicAdapter;
import qcjlibrary.adapter.base.BAdapter;
import qcjlibrary.listview.base.CommonListView;
import qcjlibrary.model.ModelExperience;
import qcjlibrary.model.ModelExperienceDetail;
import qcjlibrary.model.ModelExperienceDetailInfor;
import qcjlibrary.model.ModelExperienceDetailItem1;
import qcjlibrary.model.ModelExperienceSend;
import qcjlibrary.util.DisplayUtils;
import qcjlibrary.util.ToastUtils;
import qcjlibrary.widget.RoundImageView;
import qcjlibrary.widget.popupview.PopSingleCancer;
import android.app.ActionBar.LayoutParams;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhiyicx.zycx.LoginActivity;
import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午4:35:07 类描述：这个类是实现
 *
 */

public class CancerSingleActivity extends BaseActivity {
	private CommonListView mCommonListView;
	private BAdapter mAdapter;

	private RoundImageView iv_cancer_icon;
	private TextView tv_cancer_name;
	private TextView tv_cancer_content;
	private ImageView iv_bottom_arrow;
	private ModelExperience mExperienceData; // activity传过来的id
	ModelExperienceDetail mDetail; // 获取头部的信息
	/** 网络异常时的缺省图**/
	private View defaultView;
	private boolean isFirst = false;
	/** 父布局**/
	private LinearLayout ll_cancersingle_parent;
	private RelativeLayout rl_cancersing_head;

	@Override
	public String setCenterTitle() {
		return "肺癌";
	}

	@Override
	public void initIntent() {
		mExperienceData = (ModelExperience) getDataFromIntent(getIntent(), null);
		String titleName = mExperienceData.getWeiba_name();
		if (titleName.length() > 4) {
			titleName = titleName.substring(0, 4) + "...";
			titleSetCenterTitle(titleName);
		} else {
			titleSetCenterTitle(mExperienceData.getWeiba_name());
		}
	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_cancer_single;
	}

	@Override
	public void initView() {
		titleSetRightImage(R.drawable.chuangjianjingli);
		iv_cancer_icon = (RoundImageView) findViewById(R.id.iv_cancer_icon);
		tv_cancer_name = (TextView) findViewById(R.id.tv_cancer_name);
		tv_cancer_content = (TextView) findViewById(R.id.tv_cancer_content);
		iv_bottom_arrow = (ImageView) findViewById(R.id.iv_bottom_arrow);
		mCommonListView = (CommonListView) findViewById(R.id.mCommonListView);
		ll_cancersingle_parent = (LinearLayout) findViewById(R.id.ll_cancersingle_parent);
		rl_cancersing_head = (RelativeLayout) findViewById(R.id.rl_cancersing_head);
		mCommonListView.setDividerHeight(DisplayUtils.dp2px(getApplicationContext(), 1));
		mCommonListView.setSelector(R.drawable.listview_item_selector);
		mAdapter = new CancerTopicAdapter(this, mExperienceData);
		mCommonListView.setAdapter(mAdapter);
		mCommonListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				if (mDetail != null) {
					if (isLogin()) {
						ModelExperienceDetailItem1 detailItem = (ModelExperienceDetailItem1) parent
								.getItemAtPosition(position);
						detailItem.setWeiba_id(mDetail.getInfo().getWeiba_id());
						mCommonListView.stepToNextActivity(detailItem, ExperienceCycleActivity.class);
					} else {
						mApp.startActivity_qcj(CancerSingleActivity.this, LoginActivity.class, null);
					}
				}
			}
		});

	}

	@Override
	public void initData() {
		Title title = getTitleClass();
		title.iv_title_right1.setOnClickListener(this);
		sendRequest(mApp.getExperienceImpl().detail(mExperienceData), ModelExperienceDetail.class, REQUEST_GET);
	}

	@Override
	public Object onResponceSuccess(String str, Class class1) {
		Object object = super.onResponceSuccess(str, class1);
		if (object instanceof ModelExperienceDetail) {
			mDetail = (ModelExperienceDetail) object;
			addDataToHead(mDetail.getInfo());
		}
		return object;

	}

	/**
	 * @param info
	 */
	private void addDataToHead(ModelExperienceDetailInfor info) {
		if (info != null) {
			mApp.displayImage(info.getLogo(), iv_cancer_icon);
			tv_cancer_name.setText(info.getWeiba_name());
			tv_cancer_content.setText(info.getIntro());
		}
	}

	@Override
	public void initListener() {
		iv_bottom_arrow.setOnClickListener(this);
		rl_cancersing_head.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_title_right1:
			if (isLogin()) {
				if (mDetail != null) {
					ModelExperienceSend send = new ModelExperienceSend();
					send.setWeiba_id(mDetail.getInfo().getWeiba_id());
					send.setTags(mDetail.getInfo().getTags());
					mApp.startActivity_qcj(this, ExperienceSendActivity.class, sendDataToBundle(send, null));
				} else {
					ToastUtils.showToast("正在获取数据");
				}
			} else {
				mApp.startActivity_qcj(this, LoginActivity.class, null);
			}
			break;

		case R.id.rl_cancersing_head:
			if (mDetail != null) {
				PopSingleCancer popSingleCancer = new PopSingleCancer(this, mDetail.getInfo(), this);
				popSingleCancer.showPop(mTitlell, -1, 0, 0);
			}
			break;
		}

	}
	
	@Override
	public View onRequestFailed() {
		// TODO 自动生成的方法存根
		defaultView = super.onRequestFailed();
		TextView tv_reload = (TextView) defaultView.findViewById(R.id.tv_reload);
		tv_reload.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sendRequest(mApp.getExperienceImpl().detail(mExperienceData), ModelExperienceDetail.class, REQUEST_GET);
			}
		});
		mCommonListView.setVisibility(View.GONE);
		rl_cancersing_head.setVisibility(View.GONE);
		if(!isFirst){
			isFirst = true;
			ll_cancersingle_parent.addView(defaultView); 
		} else{
			defaultView.setVisibility(View.VISIBLE);
		}
		return defaultView;
	}
	
	@Override
	public View onRequestSuccess() {
		// TODO 自动生成的方法存根
		mCommonListView.setVisibility(View.VISIBLE);
		rl_cancersing_head.setVisibility(View.VISIBLE);
		return defaultView;
	}
}

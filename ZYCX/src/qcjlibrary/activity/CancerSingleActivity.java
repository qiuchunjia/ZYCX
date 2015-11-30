package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.activity.base.Title;
import qcjlibrary.adapter.CancerTopicAdapter;
import qcjlibrary.adapter.base.BAdapter;
import qcjlibrary.listview.base.CommonListView;
import qcjlibrary.model.base.Model;
import qcjlibrary.util.DisplayUtils;
import qcjlibrary.widget.popupview.PopSingleCancer;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午4:35:07 类描述：这个类是实现
 *
 */

public class CancerSingleActivity extends BaseActivity {
	private CommonListView mCommonListView;
	private BAdapter mAdapter;

	private ImageView iv_cancer_icon;
	private TextView tv_cancer_name;
	private TextView tv_cancer_content;
	private ImageView iv_bottom_arrow;

	@Override
	public String setCenterTitle() {
		return "肺癌";
	}

	@Override
	public void initIntent() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_cancer_single;
	}

	@Override
	public void initView() {
		titleSetRightImage(R.drawable.chuangjianjingli);
		iv_cancer_icon = (ImageView) findViewById(R.id.iv_cancer_icon);
		tv_cancer_name = (TextView) findViewById(R.id.tv_cancer_name);
		tv_cancer_content = (TextView) findViewById(R.id.tv_cancer_content);
		iv_bottom_arrow = (ImageView) findViewById(R.id.iv_bottom_arrow);
		mCommonListView = (CommonListView) findViewById(R.id.mCommonListView);
		mCommonListView.setDividerHeight(DisplayUtils.dp2px(
				getApplicationContext(), 1));
		mAdapter = new CancerTopicAdapter(this, null);
		mCommonListView.setAdapter(mAdapter);
		mCommonListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				mCommonListView.stepToNextActivity(parent, view, position,
						ExperienceCycleActivity.class);
			}
		});

	}

	@Override
	public void initData() {
		Title title = getTitleClass();
		title.iv_title_right1.setOnClickListener(this);
	}

	@Override
	public void initListener() {
		iv_bottom_arrow.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_title_right1:
			mApp.startActivity_qcj(this, ExperienceSendActivity.class,
					sendDataToBundle(new Model(), null));
			break;

		case R.id.iv_bottom_arrow:
			PopSingleCancer popSingleCancer = new PopSingleCancer(this, null,
					this);
			popSingleCancer.showPop(mTitlell, -1, 0, 0);
			break;
		}

	}
}

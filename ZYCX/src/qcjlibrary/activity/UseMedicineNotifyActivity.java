package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.activity.base.Title;
import qcjlibrary.adapter.UseMedicineNotifyAdapter;
import qcjlibrary.adapter.base.BAdapter;
import qcjlibrary.listview.base.CommonListView;
import qcjlibrary.util.DisplayUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午5:33:01 类描述：这个类是实现
 *
 */

public class UseMedicineNotifyActivity extends BaseActivity {
	private CommonListView mCommonListView;
	private BAdapter mAdapter;

	@Override
	public void onClick(View v) {

	}

	@Override
	public String setCenterTitle() {
		return "用药提醒";
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
		titleSetRightImage(R.drawable.tianjia);
		mCommonListView = (CommonListView) findViewById(R.id.mCommonListView);
		mCommonListView.setDividerHeight(DisplayUtils.dp2px(this, 10));
		mAdapter = new UseMedicineNotifyAdapter(this, null);
		mCommonListView.setAdapter(mAdapter);
		mCommonListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				mCommonListView.stepToNextActivity(parent, view, position,
						MedicineEditNotifyActivity.class);

			}
		});
	}

	@Override
	public void initData() {
		Title title = getTitleClass();
		title.iv_title_right1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mApp.startActivity_qcj(UseMedicineNotifyActivity.this,
						MedicineEditNotifyActivity.class, null);
			}
		});
	}

	@Override
	public void initListener() {

	}

}

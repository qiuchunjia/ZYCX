package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.adapter.ExperienceCycleAdapter;
import qcjlibrary.adapter.MeChooseAddressAdapter;
import qcjlibrary.adapter.base.BAdapter;
import qcjlibrary.listview.base.CommonListView;
import qcjlibrary.model.ModelMeAddress;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午5:33:01 类描述：这个类是实现
 *
 */

public class MeChooseCityActivity extends BaseActivity {
	private CommonListView mCommonListView;
	private BAdapter mAdapter;
	private ModelMeAddress mAddress;

	@Override
	public String setCenterTitle() {
		return "城市";
	}

	@Override
	public void initIntent() {
		mAddress = (ModelMeAddress) getDataFromIntent(getIntent(), null);
	}

	@Override
	public int getLayoutId() {
		return R.layout.listview_common_layout;
	}

	@Override
	public void initView() {
		mCommonListView = (CommonListView) findViewById(R.id.mCommonListView);
		mCommonListView.setDividerHeight(0);
		mAdapter = new MeChooseAddressAdapter(this, mAddress);
		mCommonListView.setAdapter(mAdapter);
		mCommonListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				ModelMeAddress address = (ModelMeAddress) parent
						.getItemAtPosition(position);
				address.setWholeAddress(mAddress.getWholeAddress()
						+ address.getTitle() + " ");
				address.setWholeId(mAddress.getWholeId() + address.getArea_id()
						+ ",");
				mCommonListView.stepToNextActivity(address,
						MeChooseTowerActivity.class);
				MeChooseCityActivity.this.finish();
			}
		});
	}

	@Override
	public void initData() {
	}

	@Override
	public void initListener() {

	}

	@Override
	public void onClick(View v) {
	}

}

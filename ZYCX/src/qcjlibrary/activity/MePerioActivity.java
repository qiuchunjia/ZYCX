package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.adapter.MePerioAdapter;
<<<<<<< HEAD
import qcjlibrary.adapter.base.BAdapter;
=======
>>>>>>> 4bf5ea73991a31620f795e33af940c8d90a95782
import qcjlibrary.listview.base.CommonListView;
import android.view.View;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午5:33:01 类描述：这个类是实现
 *
 */

public class MePerioActivity extends BaseActivity {
	private CommonListView mCommonListView;
<<<<<<< HEAD
	private BAdapter mAdapter;
=======
	private MePerioAdapter mAdapter;
>>>>>>> 4bf5ea73991a31620f795e33af940c8d90a95782

	@Override
	public void onClick(View v) {

	}

	@Override
	public String setCenterTitle() {
<<<<<<< HEAD
		return "我的期刊";
=======
		return "专家提问";
>>>>>>> 4bf5ea73991a31620f795e33af940c8d90a95782
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
		mCommonListView.setDividerHeight(20);
		mAdapter = new MePerioAdapter(this, null);
		mCommonListView.setAdapter(mAdapter);
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub

	}

}

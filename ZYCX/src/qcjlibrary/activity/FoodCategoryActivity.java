package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.adapter.FoodCategoryAdapter;
import qcjlibrary.listview.base.CommonListView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午5:33:01 类描述：这个类是实现
 *
 */

public class FoodCategoryActivity extends BaseActivity {
	private CommonListView mCommonListView;
	private FoodCategoryAdapter mAdapter;

	@Override
	public void onClick(View v) {

	}

	@Override
	public String setCenterTitle() {
		return "谷类";
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
		mCommonListView.setDividerHeight(0);
		mAdapter = new FoodCategoryAdapter(this, null);
		mCommonListView.setAdapter(mAdapter);
		mCommonListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				mCommonListView.stepToNextActivity(parent, view, position,
						FoodCategorySingleDetail.class);
			}
		});
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stubF

	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub

	}

}

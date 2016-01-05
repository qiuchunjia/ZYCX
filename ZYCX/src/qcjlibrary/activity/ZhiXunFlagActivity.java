package qcjlibrary.activity;

import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.activity.ZiXUnContentActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.adapter.ZhiXunFlagAdapter;
import qcjlibrary.adapter.ZhiXunFlagAdapter.ZixunFlagResult;
import qcjlibrary.adapter.base.BAdapter;
import qcjlibrary.listview.base.CommonListView;
import qcjlibrary.model.ModelZiXunDetail;

/**
 * author：qiuchunjia time：下午5:33:01 类描述：这个类是实现
 *
 */

public class ZhiXunFlagActivity extends BaseActivity implements ZixunFlagResult {
	private CommonListView mCommonListView;
	private BAdapter mAdapter;
	private TextView tv_flag_value;
	private ModelZiXunDetail mDetail;

	@Override
	public void onClick(View v) {

	}

	@Override
	public String setCenterTitle() {
		return "咨询标签";
	}

	@Override
	public void initIntent() {
		mDetail = (ModelZiXunDetail) getDataFromIntent(getIntent(), null);
	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_zhixun_flag;
	}

	@Override
	public void initView() {
		tv_flag_value = (TextView) findViewById(R.id.tv_flag_value);
		mCommonListView = (CommonListView) findViewById(R.id.mCommonListView);
		mAdapter = new ZhiXunFlagAdapter(this, mDetail, this);
		mCommonListView.setAdapter(mAdapter);
		mCommonListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				mCommonListView.stepToNextActivity(parent, view, position, ZiXUnContentActivity.class);
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
	public void onreturnResult(Object object) {
		tv_flag_value.setText("\"" + object.toString() + "\"");

	}

}

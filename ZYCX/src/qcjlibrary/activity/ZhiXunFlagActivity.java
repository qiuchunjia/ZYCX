package qcjlibrary.activity;

import com.umeng.socialize.utils.Log;
import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.activity.ZiXUnContentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.activity.base.Title;
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
	private Title mTitle;

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
		mTitle = getTitleClass();
	}

	@Override
	public void initListener() {
		
		mTitle.tv_title_left.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

	@Override
	public void onreturnResult(Object object) {
		tv_flag_value.setText("\"" + object.toString() + "\"");

	}
	
	@Override
	public void onBackPressed() {
		// TODO 自动生成的方法存根
		super.onBackPressed();
		finish();
	}

}

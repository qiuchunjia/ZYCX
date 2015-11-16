package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import android.view.View;
import android.widget.TextView;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午4:25:49 类描述：这个类是实现
 *
 */

public class MsgNotifyDetailActivity extends BaseActivity {
	private TextView tv_system_notify;
	private TextView tv_date;
	private TextView tv_title;
	private TextView tv_content;

	@Override
	public String setCenterTitle() {
		return "通知详情";
	}

	@Override
	public void initIntent() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_notify_detail;
	}

	@Override
	public void initView() {
		tv_system_notify = (TextView) findViewById(R.id.tv_system_notify);
		tv_date = (TextView) findViewById(R.id.tv_date);
		tv_title = (TextView) findViewById(R.id.tv_title);
		tv_content = (TextView) findViewById(R.id.tv_content);

	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}

package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.activity.base.Title;
import android.view.View;
import android.widget.Button;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午4:31:08 类描述：这个类是实现
 *
 */

public class RequestSendTopicCommitedActivity extends BaseActivity {
	private Button btn_requests;

	@Override
	public String setCenterTitle() {
		return "提示";
	}

	@Override
	public void initIntent() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_request_send_topic_commited;
	}

	@Override
	public void initView() {
		titleSetRightTitle("关闭");
		btn_requests = (Button) findViewById(R.id.btn_requests);

	}

	@Override
	public void initData() {
		Title title = getTitleClass();
		title.tv_title_right.setOnClickListener(this);

	}

	@Override
	public void initListener() {
		btn_requests.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_requests:

			break;
		case R.id.tv_title_right:
			onBackPressed();
			break;
		}

	}
}

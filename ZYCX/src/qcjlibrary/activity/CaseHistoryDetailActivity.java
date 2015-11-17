package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import android.view.View;
import android.widget.TextView;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：上午9:41:59 类描述：这个类是实现
 *
 */

public class CaseHistoryDetailActivity extends BaseActivity {

	private TextView tv_date;
	private TextView tv_title;
	private TextView tv_content;

	@Override
	public String setCenterTitle() {
		return "记录详情";
	}

	@Override
	public void initIntent() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_case_histroy_detail;
	}

	@Override
	public void initView() {
		tv_date = (TextView) findViewById(R.id.tv_date);
		tv_title = (TextView) findViewById(R.id.tv_title);
		tv_content = (TextView) findViewById(R.id.tv_content);

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

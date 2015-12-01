package qcjlibrary.activity;

import com.zhiyicx.zycx.R;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.activity.base.Title;
import qcjlibrary.model.base.Model;

/**
 * author：qiuchunjia time：下午4:31:08 类描述：这个类是实现
 *
 */

public class RequestSendTopicActivity extends BaseActivity {
	private EditText et_title;
	private EditText et_content;
	private TextView tv_num;
	private RelativeLayout rl_choose;
	private ImageView iv_choose_camera;
	private EditText et_edit;
	private TextView tv_send;

	@Override
	public String setCenterTitle() {
		return "发表问题";
	}

	@Override
	public void initIntent() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_request_send_topic;
	}

	@Override
	public void initView() {
		titleSetRightTitle("下一步");
		et_title = (EditText) findViewById(R.id.et_title);
		et_content = (EditText) findViewById(R.id.et_content);
		tv_num = (TextView) findViewById(R.id.tv_num);
		rl_choose = (RelativeLayout) findViewById(R.id.rl_choose);
		iv_choose_camera = (ImageView) findViewById(R.id.iv_choose_camera);
		et_edit = (EditText) findViewById(R.id.et_edit);
		tv_send = (TextView) findViewById(R.id.tv_send);

	}

	@Override
	public void initData() {
		Title title = getTitleClass();
		title.tv_title_right.setOnClickListener(this);

	}

	@Override
	public void initListener() {

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_title_right:
			mApp.startActivity_qcj(this, RequestChooseCancerActivity.class,
					sendDataToBundle(new Model(), null));
			break;

		default:
			break;
		}

	}
}

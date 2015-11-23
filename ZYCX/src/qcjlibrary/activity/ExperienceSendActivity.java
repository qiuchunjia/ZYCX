package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午2:34:26 类描述：这个类是实现
 *
 */

public class ExperienceSendActivity extends BaseActivity {

	private EditText et_title;
	private EditText et_choosedate;
	private EditText et_content;
	private RelativeLayout rl_choose;
	private ImageView iv_choose_photo;
	private ImageView iv_choose_camera;

	@Override
	public void onClick(View v) {

	}

	@Override
	public String setCenterTitle() {
		return "发布经历";
	}

	@Override
	public void initIntent() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_send_experience;
	}

	@Override
	public void initView() {
		titleSetRightTitle("发布");
		et_title = (EditText) findViewById(R.id.et_title);
		et_choosedate = (EditText) findViewById(R.id.et_choosedate);
		et_content = (EditText) findViewById(R.id.et_content);
		rl_choose = (RelativeLayout) findViewById(R.id.rl_choose);
		iv_choose_photo = (ImageView) findViewById(R.id.iv_choose_photo);
		iv_choose_camera = (ImageView) findViewById(R.id.iv_choose_camera);

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

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
	private ImageView iv_choose_camera;
	private EditText et_edit;
	private TextView tv_send;

	private TextView tv_cure; // 治疗类
	private TextView tv_protect;// 护理类
	private TextView tv_good;// 康复类

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
		iv_choose_camera = (ImageView) findViewById(R.id.iv_choose_camera);
		et_edit = (EditText) findViewById(R.id.et_edit);
		tv_send = (TextView) findViewById(R.id.tv_send);
		tv_cure = (TextView) findViewById(R.id.tv_cure);
		tv_protect = (TextView) findViewById(R.id.tv_protect);
		tv_good = (TextView) findViewById(R.id.tv_good);
	}

	@Override
	public void initData() {
		Title title = getTitleClass();
		title.tv_title_right.setOnClickListener(this);

	}

	@Override
	public void initListener() {
		tv_cure.setOnClickListener(this);
		tv_protect.setOnClickListener(this);
		tv_good.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		resetTextColorAndBg();
		switch (v.getId()) {
		case R.id.tv_title_right:
			mApp.startActivity_qcj(this, RequestChooseCancerActivity.class,
					sendDataToBundle(new Model(), null));
			break;

		case R.id.tv_cure:
			setTextColorAndBg(tv_cure);
			break;
		case R.id.tv_protect:
			setTextColorAndBg(tv_protect);
			break;
		case R.id.tv_good:
			setTextColorAndBg(tv_good);
			break;

		}

	}

	private void resetTextColorAndBg() {
		tv_cure.setBackgroundColor(getResources().getColor(
				R.color.main_white_pure_color));
		tv_protect.setBackgroundColor(getResources().getColor(
				R.color.main_white_pure_color));
		tv_good.setBackgroundColor(getResources().getColor(
				R.color.main_white_pure_color));
		tv_cure.setTextColor(getResources().getColor(R.color.text_gray));
		tv_protect.setTextColor(getResources().getColor(R.color.text_gray));
		tv_good.setTextColor(getResources().getColor(R.color.text_gray));
	}

	/**
	 * 设置textview背景和颜色
	 * 
	 * @param tv_cure2
	 */
	private void setTextColorAndBg(TextView textview) {
		textview.setBackgroundResource(R.drawable.view_border_green_pure_0);
		textview.setTextColor(getResources().getColor(R.color.text_green));
	}
}

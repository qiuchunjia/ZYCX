package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.activity.base.Title;
import qcjlibrary.model.base.Model;
import qcjlibrary.widget.RoundImageView;
import qcjlibrary.widget.popupview.PopExpertAdvice;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午4:31:08 类描述：这个类是实现
 *
 */

public class RequestDetailActivity extends BaseActivity {
	private TextView tv_title;
	private TextView tv_content;
	private TextView tv_flag_value;
	private TextView tv_flag_value2;
	private RoundImageView riv_icon;
	private TextView tv_username;
	private TextView tv_date;
	private RelativeLayout rl_expert;
	private TextView tv_expertcontent;
	private TextView tv_other;
	private RoundImageView riv_other_icon;
	private TextView tv_other_username;
	private TextView tv_other_content;
	private TextView tv_other_date;
	private TextView tv_other_num;
	private ImageView iv_medat;
	private TextView tv_agree;
	private LinearLayout ll_relate;
	private LinearLayout ll_answer;

	@Override
	public String setCenterTitle() {
		return "问题详情";
	}

	@Override
	public void initIntent() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_request_detail;
	}

	@Override
	public void initView() {
		titleSetRightImage(R.drawable.fenxiang);
		tv_title = (TextView) findViewById(R.id.tv_title);
		tv_content = (TextView) findViewById(R.id.tv_content);
		tv_flag_value = (TextView) findViewById(R.id.tv_flag_value);
		tv_flag_value2 = (TextView) findViewById(R.id.tv_flag_value2);
		riv_icon = (RoundImageView) findViewById(R.id.riv_icon);
		tv_username = (TextView) findViewById(R.id.tv_username);
		tv_date = (TextView) findViewById(R.id.tv_date);
		rl_expert = (RelativeLayout) findViewById(R.id.rl_expert);
		tv_expertcontent = (TextView) findViewById(R.id.tv_expertcontent);
		tv_other = (TextView) findViewById(R.id.tv_other);
		riv_other_icon = (RoundImageView) findViewById(R.id.riv_other_icon);
		tv_other_username = (TextView) findViewById(R.id.tv_other_username);
		tv_other_content = (TextView) findViewById(R.id.tv_other_content);
		tv_other_date = (TextView) findViewById(R.id.tv_other_date);
		tv_other_num = (TextView) findViewById(R.id.tv_other_num);
		iv_medat = (ImageView) findViewById(R.id.iv_medat);
		tv_agree = (TextView) findViewById(R.id.tv_agree);
		ll_relate = (LinearLayout) findViewById(R.id.ll_relate);
		ll_answer = (LinearLayout) findViewById(R.id.ll_answer);
	}

	@Override
	public void initData() {
		Title title = getTitleClass();
		title.iv_title_right1.setOnClickListener(this);
	}

	@Override
	public void initListener() {
		ll_answer.setOnClickListener(this);
		tv_flag_value2.setOnClickListener(this);
		tv_expertcontent.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ll_answer:
			mApp.startActivity_qcj(this, RequestDetailResponceActivity.class,
					sendDataToBundle(new Model(), null));
			break;

		case R.id.tv_flag_value2:
			mApp.startActivity_qcj(this, RequestFlagActivity.class,
					sendDataToBundle(new Model(), null));
			break;
		case R.id.iv_title_right1:
//			mApp.startActivity_qcj(this, RequestDetailResponceActivity.class,
//					sendDataToBundle(new Model(), null));
			break;
		case R.id.tv_expertcontent:
			PopExpertAdvice advice = new PopExpertAdvice(this, null, this);
			advice.showPop(tv_expertcontent, Gravity.RIGHT, 0, 0);
			break;
		}

	}
}

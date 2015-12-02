package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.activity.base.Title;
import qcjlibrary.widget.RoundImageView;
import qcjlibrary.widget.popupview.PopDealAnwer;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午4:31:08 类描述：这个类是实现
 *
 */

public class RequestDetailResponceActivity extends BaseActivity {
	private RoundImageView riv_other_icon;
	private TextView tv_other_username;
	private TextView tv_other_date;
	private TextView tv_other_content;
	private LinearLayout ll_replay;

	@Override
	public String setCenterTitle() {
		return "呵呵哒的解答";
	}

	@Override
	public void initIntent() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_request_detail_responce;
	}

	@Override
	public void initView() {
		titleSetRightImage(R.drawable.more3);
		riv_other_icon = (RoundImageView) findViewById(R.id.riv_other_icon);
		tv_other_username = (TextView) findViewById(R.id.tv_other_username);
		tv_other_date = (TextView) findViewById(R.id.tv_other_date);
		tv_other_content = (TextView) findViewById(R.id.tv_other_content);
		ll_replay = (LinearLayout) findViewById(R.id.ll_replay);
	}

	@Override
	public void initData() {
		Title title = getTitleClass();
		title.iv_title_right1.setOnClickListener(this);
		title.iv_title_right1.setOnClickListener(this);

	}

	@Override
	public void initListener() {

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_title_right1:
			PopDealAnwer popDealAnwer = new PopDealAnwer(this, null, this);
			popDealAnwer.showPop(ll_replay, Gravity.BOTTOM, 0, 0);

			break;

		default:
			break;
		}

	}
}

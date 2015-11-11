package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.img.RoundImageView;
import qcjlibrary.model.base.Model;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午5:41:04 类描述：这个类是实现
 *
 */

public class MeCenterActivity extends BaseActivity {
	private RelativeLayout rl_user;
	private RoundImageView riv_user_icon;
	private RelativeLayout rl_mycase;
	private ImageView iv_question;
	private RelativeLayout rl_app;
	private RelativeLayout rl_cycle;
	private RelativeLayout rl_periodical;
	private Button btn_quit;

	@Override
	public String setCenterTitle() {

		return "个人中心";
	}

	@Override
	public void initIntent() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_me_center;
	}

	@Override
	public void initView() {
		rl_user = (RelativeLayout) findViewById(R.id.rl_user);
		riv_user_icon = (RoundImageView) findViewById(R.id.riv_user_icon);
		rl_mycase = (RelativeLayout) findViewById(R.id.rl_mycase);
		iv_question = (ImageView) findViewById(R.id.iv_question);
		rl_app = (RelativeLayout) findViewById(R.id.rl_app);
		rl_cycle = (RelativeLayout) findViewById(R.id.rl_cycle);
		rl_periodical = (RelativeLayout) findViewById(R.id.rl_periodical);
		btn_quit = (Button) findViewById(R.id.btn_quit);

	}

	@Override
	public void initData() {
	}

	@Override
	public void initListener() {
		rl_user.setOnClickListener(this);
		rl_mycase.setOnClickListener(this);
		iv_question.setOnClickListener(this);
		rl_app.setOnClickListener(this);
		rl_cycle.setOnClickListener(this);
		rl_periodical.setOnClickListener(this);
		btn_quit.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.rl_user:
			// TODO
			mApp.startActivity_qcj(this, MeCenterBasicActivity.class,
					sendDataToBundle(new Model(), null));
			break;

		case R.id.rl_mycase:

			break;
		case R.id.iv_question:

			break;
		case R.id.rl_app:
			mApp.startActivity_qcj(this, MeAplicationActivity.class,
					sendDataToBundle(new Model(), null));
			break;
		case R.id.rl_cycle:

			break;
		case R.id.rl_periodical:

			break;
		case R.id.btn_quit:

			break;
		}

	}

}

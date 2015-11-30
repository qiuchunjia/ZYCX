package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.img.RoundImageView;
import qcjlibrary.model.base.Model;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午5:41:04 类描述：
 * 
 * 
 * 这个类是实现个人中心基本资料设置
 *
 */

public class MeCenterBasicActivity extends BaseActivity {
	private RelativeLayout rl_user;
	private RoundImageView riv_user_icon;
	private RelativeLayout rl_mycase;
	private TextView tv_mycase_value;
	private RelativeLayout rl_nick;
	private TextView tv_nick_value;
	private RelativeLayout rl_gender;
	private TextView tv_gender_value;
	private RelativeLayout rl_birth;
	private TextView tv_birth_value;
	private RelativeLayout rl_address;
	private TextView tv_address_value;
	private RelativeLayout rl_cancer_category;
	private TextView tv_category_value;

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
		return R.layout.activity_me_centerbasic;
	}

	@Override
	public void initView() {
		rl_user = (RelativeLayout) findViewById(R.id.rl_user);
		riv_user_icon = (RoundImageView) findViewById(R.id.riv_user_icon);
		rl_mycase = (RelativeLayout) findViewById(R.id.rl_mycase);
		tv_mycase_value = (TextView) findViewById(R.id.tv_mycase_value);
		rl_nick = (RelativeLayout) findViewById(R.id.rl_nick);
		tv_nick_value = (TextView) findViewById(R.id.tv_nick_value);
		rl_gender = (RelativeLayout) findViewById(R.id.rl_gender);
		tv_gender_value = (TextView) findViewById(R.id.tv_gender_value);
		rl_birth = (RelativeLayout) findViewById(R.id.rl_birth);
		tv_birth_value = (TextView) findViewById(R.id.tv_birth_value);
		rl_address = (RelativeLayout) findViewById(R.id.rl_address);
		tv_address_value = (TextView) findViewById(R.id.tv_address_value);
		rl_cancer_category = (RelativeLayout) findViewById(R.id.rl_cancer_category);
		tv_category_value = (TextView) findViewById(R.id.tv_category_value);

	}

	@Override
	public void initData() {
	}

	@Override
	public void initListener() {
		rl_user.setOnClickListener(this);
		rl_mycase.setOnClickListener(this);
		rl_nick.setOnClickListener(this);
		rl_gender.setOnClickListener(this);
		rl_birth.setOnClickListener(this);
		rl_address.setOnClickListener(this);
		rl_cancer_category.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.rl_user:
			// TODO

			break;

		case R.id.rl_mycase:
			mApp.startActivity_qcj(
					this,
					SettingOneLineEditActivity.class,
					sendDataToBundle(SettingOneLineEditActivity.DECLARATION,
							null));
			break;
		case R.id.rl_nick:
			mApp.startActivity_qcj(this, SettingOneLineEditActivity.class,
					sendDataToBundle(SettingOneLineEditActivity.NICK, null));
			break;
		case R.id.rl_gender:
			mApp.startActivity_qcj(this, SettingOneLineEditActivity.class,
					sendDataToBundle(SettingOneLineEditActivity.GENDER, null));
			break;
		case R.id.rl_birth:
			mApp.startActivity_qcj(this, SettingOneLineEditActivity.class,
					sendDataToBundle(SettingOneLineEditActivity.BIRTHDAY, null));
			break;
		case R.id.rl_address:
			mApp.startActivity_qcj(this, SettingOneLineEditActivity.class,
					sendDataToBundle(SettingOneLineEditActivity.LOCATION, null));
			break;
		case R.id.rl_cancer_category:
			mApp.startActivity_qcj(
					this,
					SettingOneLineEditActivity.class,
					sendDataToBundle(SettingOneLineEditActivity.CANCERCATEGORY,
							null));
			break;
		}

	}

}

package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.model.base.Model;
import android.view.View;
import android.widget.TextView;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：上午10:55:26 类描述：这个类是实现
 *
 */

public class PatientMeActivity extends BaseActivity {
	private TextView tv_edit;
	private TextView tv_username;
	private TextView tv_gender;
	private TextView tv_age;
	private TextView tv_nation;
	private TextView tv_marry;
	private TextView tv_job;
	private TextView tv_education;
	private TextView tv_pretect;
	private TextView tv_hometown;
	private TextView tv_address;
	private TextView tv_height;
	private TextView tv_weight;
	private TextView tv_edit2;
	private TextView tv_user_histroy;
	private TextView tv_allegry;
	private TextView tv_useraddress;
	private TextView tv_food_habit;
	private TextView tv_smoke;
	private TextView tv_first;

	@Override
	public String setCenterTitle() {
		return "患者信息";
	}

	@Override
	public void initIntent() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_patient_me;
	}

	@Override
	public void initView() {
		tv_edit = (TextView) findViewById(R.id.tv_edit);
		tv_username = (TextView) findViewById(R.id.tv_username);
		tv_gender = (TextView) findViewById(R.id.tv_gender);
		tv_age = (TextView) findViewById(R.id.tv_age);
		tv_nation = (TextView) findViewById(R.id.tv_nation);
		tv_marry = (TextView) findViewById(R.id.tv_marry);
		tv_job = (TextView) findViewById(R.id.tv_job);
		tv_education = (TextView) findViewById(R.id.tv_education);
		tv_pretect = (TextView) findViewById(R.id.tv_pretect);
		tv_hometown = (TextView) findViewById(R.id.tv_hometown);
		tv_address = (TextView) findViewById(R.id.tv_address);
		tv_height = (TextView) findViewById(R.id.tv_height);
		tv_weight = (TextView) findViewById(R.id.tv_weight);
		tv_edit2 = (TextView) findViewById(R.id.tv_edit2);
		tv_user_histroy = (TextView) findViewById(R.id.tv_user_histroy);
		tv_allegry = (TextView) findViewById(R.id.tv_allegry);
		tv_useraddress = (TextView) findViewById(R.id.tv_useraddress);
		tv_food_habit = (TextView) findViewById(R.id.tv_food_habit);
		tv_smoke = (TextView) findViewById(R.id.tv_smoke);
		tv_first = (TextView) findViewById(R.id.tv_first);
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initListener() {
		tv_edit.setOnClickListener(this);
		tv_edit2.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_edit:
			mApp.startActivity_qcj(this, PatientInforActivity.class,
					sendDataToBundle(new Model(), null));
			break;

		case R.id.tv_edit2:
			mApp.startActivity_qcj(this, PatientHistoryActivity.class,
					sendDataToBundle(new Model(), null));
			break;

		}

	}

}

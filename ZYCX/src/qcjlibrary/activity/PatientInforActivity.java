package qcjlibrary.activity;

import com.zhiyicx.zycx.R;

import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import qcjlibrary.activity.base.BaseActivity;

/**
 * author：qiuchunjia time：上午10:55:26 类描述：这个类是实现
 *
 */

public class PatientInforActivity extends BaseActivity {
	private EditText et_name;
	private RelativeLayout rl_gender;
	private TextView tv_gender_name;
	private EditText et_age;
	private RelativeLayout rl_marry;
	private TextView tv_marry_name;
	private RelativeLayout rl_nation;
	private TextView tv_nation_name;
	private EditText et_job;
	private RelativeLayout rl_education;
	private TextView tv_education_name;
	private RelativeLayout rl_insurance;
	private TextView tv_insurance_name;
	private RelativeLayout rl_hometown;
	private TextView tv_hometown_name;
	private RelativeLayout rl_address;
	private TextView tv_address_name;
	private EditText et_heights;
	private EditText et_weights;

	@Override
	public String setCenterTitle() {
		return "患者信息";
	}

	@Override
	public void initIntent() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_patient_infor;
	}

	@Override
	public void initView() {
		titleSetRightTitle("保存");
		et_name = (EditText) findViewById(R.id.et_name);
		rl_gender = (RelativeLayout) findViewById(R.id.rl_gender);
		et_name = (EditText) findViewById(R.id.et_name);
		tv_gender_name = (TextView) findViewById(R.id.tv_gender_name);
		et_age = (EditText) findViewById(R.id.et_age);
		rl_marry = (RelativeLayout) findViewById(R.id.rl_marry);
		tv_marry_name = (TextView) findViewById(R.id.tv_marry_name);
		rl_nation = (RelativeLayout) findViewById(R.id.rl_nation);
		tv_nation_name = (TextView) findViewById(R.id.tv_nation_name);
		et_job = (EditText) findViewById(R.id.et_job);
		rl_education = (RelativeLayout) findViewById(R.id.rl_education);
		tv_education_name = (TextView) findViewById(R.id.tv_education_name);
		rl_insurance = (RelativeLayout) findViewById(R.id.rl_insurance);
		tv_insurance_name = (TextView) findViewById(R.id.tv_insurance_name);
		rl_hometown = (RelativeLayout) findViewById(R.id.rl_hometown);
		tv_hometown_name = (TextView) findViewById(R.id.tv_hometown_name);
		rl_address = (RelativeLayout) findViewById(R.id.rl_address);
		tv_address_name = (TextView) findViewById(R.id.tv_address_name);
		et_heights = (EditText) findViewById(R.id.et_heights);
		et_weights = (EditText) findViewById(R.id.et_weights);
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}

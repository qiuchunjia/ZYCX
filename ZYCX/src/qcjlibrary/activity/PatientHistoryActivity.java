package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：上午10:55:26 类描述：这个类是实现
 *
 */

public class PatientHistoryActivity extends BaseActivity {
	private EditText et_name;
	private EditText et_allergy_name;
	private EditText et_single_name;
	private RelativeLayout rl_eat;
	private TextView tv_eat_name;
	private RelativeLayout rl_smoke;
	private TextView tv_smoke_name;
	private EditText et_smoke_year;
	private EditText et_smoke_gen;
	private RelativeLayout rl_stop_smoke;
	private TextView tv_stop_smoke_name;
	private RelativeLayout rl_stop_smoke_time;
	private TextView tv_stop_smoke_time_name;

	private RelativeLayout rl_drink;
	private TextView tv_drink_name;
	private EditText et_drink_year;
	private EditText et_drink_much;
	private RelativeLayout rl_stop_drink;
	private TextView tv_stop_drink_name;
	private EditText et_first;
	private RelativeLayout rl_last_time;
	private TextView tv_last_time_name;
	private EditText et_stop_yuejins;
	private RelativeLayout rl_children;
	private TextView tv_children_name;
	private EditText et_family_historys;

	@Override
	public String setCenterTitle() {
		return "既往史";
	}

	@Override
	public void initIntent() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_patient_history;
	}

	@Override
	public void initView() {
		titleSetRightTitle("保存");
		et_name = (EditText) findViewById(R.id.et_name);
		et_allergy_name = (EditText) findViewById(R.id.et_allergy_name);
		et_single_name = (EditText) findViewById(R.id.et_single_name);
		rl_eat = (RelativeLayout) findViewById(R.id.rl_eat);
		tv_eat_name = (TextView) findViewById(R.id.tv_eat_name);
		rl_smoke = (RelativeLayout) findViewById(R.id.rl_smoke);
		tv_smoke_name = (TextView) findViewById(R.id.tv_smoke_name);
		et_smoke_year = (EditText) findViewById(R.id.et_smoke_year);
		et_smoke_gen = (EditText) findViewById(R.id.et_smoke_gen);
		rl_stop_smoke = (RelativeLayout) findViewById(R.id.rl_stop_smoke);
		tv_stop_smoke_name = (TextView) findViewById(R.id.tv_stop_smoke_name);
		rl_stop_smoke_time = (RelativeLayout) findViewById(R.id.rl_stop_smoke_time);
		tv_stop_smoke_time_name = (TextView) findViewById(R.id.tv_stop_smoke_time_name);

		rl_drink = (RelativeLayout) findViewById(R.id.rl_drink);
		tv_drink_name = (TextView) findViewById(R.id.tv_drink_name);
		et_drink_year = (EditText) findViewById(R.id.et_drink_year);
		et_drink_much = (EditText) findViewById(R.id.et_drink_much);
		rl_stop_drink = (RelativeLayout) findViewById(R.id.rl_stop_drink);
		tv_stop_drink_name = (TextView) findViewById(R.id.tv_stop_drink_name);
		et_first = (EditText) findViewById(R.id.et_first);
		rl_last_time = (RelativeLayout) findViewById(R.id.rl_last_time);
		tv_last_time_name = (TextView) findViewById(R.id.tv_last_time_name);
		et_stop_yuejins = (EditText) findViewById(R.id.et_stop_yuejins);
		rl_children = (RelativeLayout) findViewById(R.id.rl_children);
		tv_children_name = (TextView) findViewById(R.id.tv_children_name);
		et_family_historys = (EditText) findViewById(R.id.et_family_historys);
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

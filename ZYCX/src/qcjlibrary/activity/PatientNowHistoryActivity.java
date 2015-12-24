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

public class PatientNowHistoryActivity extends BaseActivity {
	private RelativeLayout rl_check_time;
	private TextView tv_check_time_name;
	private RelativeLayout rl_check_time1;
	private TextView tv_check_end_time_name;
	private EditText et_name;
	private RelativeLayout rl_check_way;
	private TextView tv_check_way_name;
	private RelativeLayout rl_check_add;
	private RelativeLayout rl_lab_check_time;

	private TextView tv_lab_check_time_project;
	private RelativeLayout rl_lab_check_time1;
	private TextView tv_lab_check_end_time_name;
	private EditText et_lab_checkname;
	private RelativeLayout rl_lab_check_add;
	private RelativeLayout rl_vedio_check_time;
	private TextView tv_vedio_check_time_project;
	private RelativeLayout rl_vedio_check_time1;
	private TextView tv_vedio_check_end_time_name;
	private EditText et_vedio_checkname;
	private RelativeLayout rl_vedio_check_add;

	@Override
	public String setCenterTitle() {
		return "现病史";
	}

	@Override
	public void initIntent() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_patient_now_history;
	}

	@Override
	public void initView() {
		rl_check_time = (RelativeLayout) findViewById(R.id.rl_check_time);
		tv_check_time_name = (TextView) findViewById(R.id.tv_check_time_name);
		rl_check_time1 = (RelativeLayout) findViewById(R.id.rl_check_time1);
		tv_check_end_time_name = (TextView) findViewById(R.id.tv_check_end_time_name);
		et_name = (EditText) findViewById(R.id.et_name);
		rl_check_way = (RelativeLayout) findViewById(R.id.rl_check_way);
		tv_check_way_name = (TextView) findViewById(R.id.tv_check_way_name);
		rl_check_add = (RelativeLayout) findViewById(R.id.rl_check_add);
		rl_lab_check_time = (RelativeLayout) findViewById(R.id.rl_lab_check_time);
		tv_lab_check_time_project = (TextView) findViewById(R.id.tv_lab_check_time_project);
		rl_lab_check_time1 = (RelativeLayout) findViewById(R.id.rl_lab_check_time1);
		tv_lab_check_end_time_name = (TextView) findViewById(R.id.tv_lab_check_end_time_name);
		et_lab_checkname = (EditText) findViewById(R.id.et_lab_checkname);
		rl_lab_check_add = (RelativeLayout) findViewById(R.id.rl_lab_check_add);
		rl_lab_check_add = (RelativeLayout) findViewById(R.id.rl_lab_check_add);
		rl_vedio_check_time = (RelativeLayout) findViewById(R.id.rl_vedio_check_time);
		tv_vedio_check_time_project = (TextView) findViewById(R.id.tv_vedio_check_time_project);
		rl_vedio_check_time1 = (RelativeLayout) findViewById(R.id.rl_vedio_check_time1);
		tv_vedio_check_end_time_name = (TextView) findViewById(R.id.tv_vedio_check_end_time_name);
		et_vedio_checkname = (EditText) findViewById(R.id.et_vedio_checkname);
		rl_vedio_check_add = (RelativeLayout) findViewById(R.id.rl_vedio_check_add);
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

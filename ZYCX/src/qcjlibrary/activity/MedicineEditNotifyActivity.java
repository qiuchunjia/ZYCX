package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：
 * 
 * 上午11:53:03 类描述：这个类是实现
 *
 */

public class MedicineEditNotifyActivity extends BaseActivity {

	private EditText et_user;
	private EditText et_medicine_name;
	private TextView tv_once;
	private TextView tv_eat_med_repeat;
	private TextView tv_eat_med_repeatday;
	private ImageView iv_eat_med_edit;
	private TextView tv_eat_time;
	private ImageView iv_eat_time_edit;
	private TextView tv_eat_med_start;
	private TextView tv_eat_med_startday;
	private ImageView iv_eat_med_edit2;
	private TextView tv_start_time;
	private ImageView iv_start_time_edit;
	private ImageView iv_notify_open;

	@Override
	public String setCenterTitle() {
		return "编辑提醒";
	}

	@Override
	public void initIntent() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_medicine_edit_notify;
	}

	@Override
	public void initView() {
		titleSetRightTitle("确认");
		et_medicine_name = (EditText) findViewById(R.id.et_medicine_name);
		tv_once = (TextView) findViewById(R.id.tv_once);
		tv_eat_med_repeat = (TextView) findViewById(R.id.tv_eat_med_repeat);
		tv_eat_med_repeatday = (TextView) findViewById(R.id.tv_eat_med_repeatday);
		iv_eat_med_edit = (ImageView) findViewById(R.id.iv_eat_med_edit);
		tv_eat_time = (TextView) findViewById(R.id.tv_eat_time);
		iv_eat_time_edit = (ImageView) findViewById(R.id.iv_eat_time_edit);
		tv_eat_med_start = (TextView) findViewById(R.id.tv_eat_med_start);
		tv_eat_med_startday = (TextView) findViewById(R.id.tv_eat_med_startday);
		iv_eat_med_edit2 = (ImageView) findViewById(R.id.iv_eat_med_edit2);
		tv_start_time = (TextView) findViewById(R.id.tv_start_time);
		iv_start_time_edit = (ImageView) findViewById(R.id.iv_start_time_edit);
		iv_notify_open = (ImageView) findViewById(R.id.iv_notify_open);

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

	}

}

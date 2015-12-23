package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.config.Config;
import qcjlibrary.model.ModelPop;
import qcjlibrary.widget.popupview.PopAlertDaily;
import qcjlibrary.widget.popupview.PopAlertStartTime;
import qcjlibrary.widget.popupview.PopDatePicker;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
	private RelativeLayout rl_alert_repaet_daily;
	private RelativeLayout rl_alert_repeat_time;
	private RelativeLayout rl_alert_starttime;
	
	private String userName;
	private String medicineName;

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
		tv_start_time = (TextView) findViewById(R.id.tv_start_time);
		iv_start_time_edit = (ImageView) findViewById(R.id.iv_start_time_edit);
		iv_notify_open = (ImageView) findViewById(R.id.iv_notify_open);
		rl_alert_repaet_daily = (RelativeLayout) findViewById(R.id.rl_alert_repaet_daily);
		rl_alert_repeat_time = (RelativeLayout) findViewById(R.id.rl_alert_repeat_time);
		rl_alert_starttime = (RelativeLayout) findViewById(R.id.rl_alert_starttime);
	}

	@Override
	public void initData() {
		
	}

	@Override
	public void initListener() {
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.rl_alert_repaet_daily:
			//弹出日期提醒频率框
			PopAlertDaily alertDaily = new PopAlertDaily(this, null, this);
			alertDaily.showPop(rl_alert_repaet_daily, Gravity.BOTTOM, 0, 0);
			break;
		case R.id.rl_alert_repeat_time:
			//弹出时间提醒频率框
			
			break;
		case R.id.rl_alert_starttime:
			//弹出开始时间选择框
			PopAlertStartTime datePicker = new PopAlertStartTime(this, null, this);
			datePicker.showPop(rl_alert_starttime, Gravity.BOTTOM, 0, 0);
			break;
		case R.id.iv_notify_open:
			//打开或关闭提醒
			
			break;
		default:
			break;
		}
	}

	@Override
	public Object onPopResult(Object object) {
		String type = ((ModelPop)object).getType();
		String data = ((ModelPop)object).getDataStr();
		if(type.equals(Config.TYPE_DAILY)){
			tv_once.setText(data+"一次");
			tv_eat_med_repeatday.setText(data);
		} else if(type.equals(Config.TYPE_TIME)){
			tv_eat_time.setText(data);
		} else if(type.equals(Config.TYPE_DATE)){
			tv_start_time.setText(data);
		}
		return super.onPopResult(object);
	}
}

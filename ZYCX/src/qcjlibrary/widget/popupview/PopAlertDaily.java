package qcjlibrary.widget.popupview;

import java.util.ArrayList;
import java.util.List;

import com.zhiyicx.zycx.R;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import qcjlibrary.config.Config;
import qcjlibrary.model.ModelPop;
import qcjlibrary.widget.popupview.base.PopView;

public class PopAlertDaily extends PopView {
	
	/**
	 * author：tanxiaomin 
	 * time：上午11:30:44 
	 * 类描述：日期提醒弹出框
	 */

	private TextView tv_alert_everyday;
	private TextView tv_alert_two;
	private TextView tv_alert_three;
	private TextView tv_alert_four;
	private TextView tv_alert_five;
	private TextView tv_alert_sex;
	private TextView tv_alert_seven;
	private Button btn_alert_check;
	/** 选中选项的位置**/
	private int index;
	private List<TextView> textList;
	
	public PopAlertDaily(Activity activity, Object object, 
			PopResultListener resultListener) {
		super(activity, object, resultListener);
	}

	@Override
	public int getLayoutId() {
		return R.layout.pop_alert_daily;
	}

	@Override
	public void initPopView() {
		tv_alert_everyday = (TextView) findViewbyId(R.id.tv_alert_everyday);
		tv_alert_two = (TextView) findViewbyId(R.id.tv_alert_two);
		tv_alert_three = (TextView) findViewbyId(R.id.tv_alert_three);
		tv_alert_four = (TextView) findViewbyId(R.id.tv_alert_four);
		tv_alert_five = (TextView) findViewbyId(R.id.tv_alert_five);
		tv_alert_sex = (TextView) findViewbyId(R.id.tv_alert_sex);
		tv_alert_seven = (TextView) findViewbyId(R.id.tv_alert_seven);
		btn_alert_check = (Button) findViewbyId(R.id.btn_alert_check);
	}

	@Override
	public void initPopData(Object object) {
		textList = new ArrayList<TextView>();
		textList.add(tv_alert_everyday);
		textList.add(tv_alert_two);
		textList.add(tv_alert_three);
		textList.add(tv_alert_four);
		textList.add(tv_alert_five);
		textList.add(tv_alert_sex);
		textList.add(tv_alert_seven);
	}

	@Override
	public void setPopLisenter(final PopResultListener listener) {
		
		//监听不同选项
		//每天
		tv_alert_everyday.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				index = 0;
			}
		});
		//每2天
		tv_alert_two.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				index = 1;
			}
		});
		//每3天
		tv_alert_three.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				index = 2;
			}
		});
		//每4天
		tv_alert_four.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				index = 3;
			}
		});
		//每5天
		tv_alert_five.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				index = 4;
			}
		});
		//每6天
		tv_alert_sex.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				index = 5;
			}
		});
		//每7天
		tv_alert_seven.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				index = 6;
			}
		});
		//监听确认按钮
		btn_alert_check.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				/** 选中的提醒频率**/
				int period =index + 1;
				ModelPop dailyData = new ModelPop();
				dailyData.setType(Config.TYPE_DAILY);
				dailyData.setDataInter(period);
				listener.onPopResult(dailyData);
				mPopWindow.dismiss();
			}
			
		});
	}
	
}

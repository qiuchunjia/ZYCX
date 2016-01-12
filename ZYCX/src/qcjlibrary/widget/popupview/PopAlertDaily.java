package qcjlibrary.widget.popupview;

import java.util.ArrayList;
import java.util.List;

import com.zhiyicx.zycx.R;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

	private LinearLayout ll_alert_everyday;
	private LinearLayout ll_alert_two;
	private LinearLayout ll_alert_three;
	private LinearLayout ll_alert_four;
	private LinearLayout ll_alert_five;
	private LinearLayout ll_alert_sex;
	private LinearLayout ll_alert_seven;
	private ImageView iv_alert_everyday;
	private ImageView iv_alert_two;
	private ImageView iv_alert_three;
	private ImageView iv_alert_four;
	private ImageView iv_alert_five;
	private ImageView iv_alert_sex;
	private ImageView iv_alert_seven;
	private Button btn_alert_check;
	/** 选中选项的位置**/
	private int index;
	private List<ImageView> imgList;
	
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
		ll_alert_everyday = (LinearLayout) findViewbyId(R.id.ll_alert_everyday);
		ll_alert_two = (LinearLayout) findViewbyId(R.id.ll_alert_two);
		ll_alert_three = (LinearLayout) findViewbyId(R.id.ll_alert_three);
		ll_alert_four = (LinearLayout) findViewbyId(R.id.ll_alert_four);
		ll_alert_five = (LinearLayout) findViewbyId(R.id.ll_alert_five);
		ll_alert_sex = (LinearLayout) findViewbyId(R.id.ll_alert_sex);
		ll_alert_seven = (LinearLayout) findViewbyId(R.id.ll_alert_seven);
		iv_alert_everyday = (ImageView) findViewbyId(R.id.iv_alert_everyday);
		iv_alert_two = (ImageView) findViewbyId(R.id.iv_alert_two);
		iv_alert_three = (ImageView) findViewbyId(R.id.iv_alert_three);
		iv_alert_four = (ImageView) findViewbyId(R.id.iv_alert_four);
		iv_alert_five = (ImageView) findViewbyId(R.id.iv_alert_five);
		iv_alert_sex = (ImageView) findViewbyId(R.id.iv_alert_sex);
		iv_alert_seven = (ImageView) findViewbyId(R.id.iv_alert_seven);
		btn_alert_check = (Button) findViewbyId(R.id.btn_alert_check);
	}

	@Override
	public void initPopData(Object object) {
		imgList = new ArrayList<ImageView>();
		imgList.add(iv_alert_everyday);
		imgList.add(iv_alert_two);
		imgList.add(iv_alert_three);
		imgList.add(iv_alert_four);
		imgList.add(iv_alert_five);
		imgList.add(iv_alert_sex);
		imgList.add(iv_alert_seven);
	}

	@Override
	public void setPopLisenter(final PopResultListener listener) {
		
		//监听不同选项
		//每天
		ll_alert_everyday.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				index = 0;
				setDrawableLeft(index);
			}
		});
		//每2天
		ll_alert_two.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				index = 1;
				setDrawableLeft(index);
			}
		});
		//每3天
		ll_alert_three.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				index = 2;
				setDrawableLeft(index);
			}
		});
		//每4天
		ll_alert_four.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				index = 3;
				setDrawableLeft(index);
			}
		});
		//每5天
		ll_alert_five.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				index = 4;
				setDrawableLeft(index);
			}
		});
		//每6天
		ll_alert_sex.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				index = 5;
				setDrawableLeft(index);
			}
		});
		//每7天
		ll_alert_seven.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				index = 6;
				setDrawableLeft(index);
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
	
	private void setDrawableLeft(int index){
		for (int i = 0; i < imgList.size(); i++) {
			if(i == index){
				imgList.get(i).setImageResource(R.drawable.xuanzhong);
			} else{
				imgList.get(i).setImageResource(R.drawable.weixuanzhong);
			}
		}
	}
}

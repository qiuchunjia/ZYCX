package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.activity.base.Title;
import qcjlibrary.adapter.UseMedicineNotifyAdapter;
import qcjlibrary.adapter.base.BAdapter;
import qcjlibrary.api.api.AlarmImpl;
import qcjlibrary.broadcast.AlarmBroadCastReciever;
import qcjlibrary.config.Config;
import qcjlibrary.listview.base.CommonListView;
import qcjlibrary.model.ModelAlertData;
import qcjlibrary.model.ModelAlertList;
import qcjlibrary.model.base.Model;
import qcjlibrary.util.DisplayUtils;
import qcjlibrary.util.L;
import qcjlibrary.util.SharedPreferencesUtil;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.umeng.socialize.utils.Log;
import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.sociax.android.Thinksns;
import com.zhiyicx.zycx.util.PreferenceUtil;

/**
 * author：tan time：下午5:7:01 类描述：用药提醒，闹钟界面
 */

public class UseMedicineNotifyActivity extends BaseActivity {
	private CommonListView mCommonListView;
	private BAdapter mAdapter;

	private List<Model> mAlertList;
	// 闹钟管理类
	private AlarmManager mManager;

	@Override
	public void onClick(View v) {

	}

	@Override
	public String setCenterTitle() {
		return "用药提醒";
	}

	@Override
	public void initIntent() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.listview_common_layout;
	}

	@Override
	public void initView() {
		titleSetRightImage(R.drawable.tianjia);
		mCommonListView = (CommonListView) findViewById(R.id.mCommonListView);
		mCommonListView.setDividerHeight(DisplayUtils.dp2px(this, 10));

	}

	@Override
	public void initData() {
		Title title = getTitleClass();
		title.iv_title_right1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mApp.startActivity_qcj(UseMedicineNotifyActivity.this, 
						MedicineEditNotifyActivity.class, null);
			}
		});
		mAdapter = new UseMedicineNotifyAdapter(this, null);
		mCommonListView.setAdapter(mAdapter);
	}

	@Override
	public void initListener() {
		mCommonListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				mCommonListView.stepToNextActivity(parent, view, position, 
						MedicineEditNotifyActivity.class);

			}
		});
	}
	
	@Override
	public Object onResponceSuccess(String str, Class class1) {
		// TODO 自动生成的方法存根
		Object object =  super.onResponceSuccess(str, class1);
		if(object instanceof ModelAlertList){
			ModelAlertList mListData = (ModelAlertList) object;
			if(mAlertList != null){
				mAlertList.clear();
				if(mListData.getList() != null){
					mAlertList.addAll(mListData.getList());
					mAdapter = new UseMedicineNotifyAdapter(this, mAlertList);
					mCommonListView.setAdapter(mAdapter);
					if(mAlertList.size() > 0){
						setAlarm();
					}
				}
			}
		}
		return object;
	}

	// 设置闹钟
	private void setAlarm() {
		Intent mIntent = new Intent(this, AlarmBroadCastReciever.class);
		mIntent.setAction("alarm.alert.short");
		// 循环为每个闹钟设置广播
		if (mAlertList.size() > 0) {
			for (int i = 0; i < mAlertList.size(); i++) {
				ModelAlertData mData = (ModelAlertData) mAlertList.get(i);
				if (mData.getIs_remind() == 0) {
					String timeList = mData.getMed_time();
					String startTime = mData.getStime();
					String repeatDaily = mData.getPeriod();
					int period = Integer.parseInt(repeatDaily);
					// 根据重复天数计算出间隔的毫秒数
					long intervalMillis = setIntervalMillis(period);
					String[] timeArr = timeList.split(",");
					// 为每一个时间设置广播
					for (int j = 0; j < timeArr.length; j++) {
						/** 区分不同闹钟的ID**/
						int id = 0;
						id = (Integer) SharedPreferencesUtil.getData(
								this, "alerm id:"+id, id);
						if (timeArr[j] != null) {
							long currentMillis = System.currentTimeMillis();
							if(getYearMonDay(startTime) < currentMillis){
								startTime = getYearMonDay(currentMillis);
							}
							//Log.d("Cathy", "开始年月日转换long:"+ getYearMonDay(startTime) +
									//"当前时间："+ currentMillis + "转换后："+ startTime);
							long triggerAtMillis = changeStr2Long(startTime + " " + timeArr[j] + ":00");
							Log.d("Cathy", "开始时间："+ startTime + " " + timeArr[j] + ":00" + " 换算前："+ triggerAtMillis);
							//如果开始时间已经早于当前时间，则将当前时间设为开始时间
							if(currentMillis > triggerAtMillis){
								triggerAtMillis = triggerAtMillis + intervalMillis;
								//Log.d("Cathy", "下次提醒时间： "+changeLong2Str(triggerAtMillis));
							}
							/**
							 * 三种获取PendingIntent对象的方法 getActivity(Context, int,
							 * Intent, int) 启动一个activity getBroadcast(Context,
							 * int, Intent, int) 发送一个广播 getService(Context, int,
							 * Intent, int) 开启一个服务
							 */
							PendingIntent mPendingIntent = PendingIntent.getBroadcast(this, id, mIntent, 0);
							mManager = (AlarmManager) getSystemService(ALARM_SERVICE);
							mManager.setRepeating(AlarmManager.RTC_WAKEUP, triggerAtMillis, intervalMillis,
									mPendingIntent);
							id++;
							SharedPreferencesUtil.saveData(this, "alerm id:"+id, id);
						}
					}
				} else {
					L.d("Cathy", "cancel alert");
					PendingIntent mPendingIntent = PendingIntent.getBroadcast(this, 0, mIntent, 0);
					mManager = (AlarmManager) getSystemService(ALARM_SERVICE);
					mManager.cancel(mPendingIntent);
				}
			}
		}
	}

	/**
	 * @param int
	 *            daily 间隔天数
	 * @return long 将天数转换为毫秒数
	 */
	private long setIntervalMillis(int daily) {
		return daily * 24 * 60 * 60 * 1000;
	}

	/**
	 * 将时间字符串转换为long
	 */
	@SuppressLint("SimpleDateFormat")
	private long changeStr2Long(String time) {
		SimpleDateFormat mFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss",Locale.CHINA);
		Date mDate;
		try {
			mDate = mFormat.parse(time);
			return mDate.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
			Log.d("Cathy", e.toString());
		}
		return 0;
	}
	
	private String changeLong2Str(long time){
		SimpleDateFormat mFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss", Locale.CHINA);
		Date date = new Date(time);
		return mFormat.format(date);
	}
	
	private long getYearMonDay(String time){
		SimpleDateFormat mFormat = new SimpleDateFormat(
				"yyyy-MM-dd", Locale.CHINA);
		Date mDate;
		try {
			mDate = mFormat.parse(time);
			return mDate.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
			Log.d("Cathy", e.toString());
		}
		return 0;
	}

	private String getYearMonDay(long time){
		SimpleDateFormat mFormat = new SimpleDateFormat(
				"yyyy-MM-dd", Locale.CHINA);
		Date date = new Date(time);
		return mFormat.format(date);
	}
}

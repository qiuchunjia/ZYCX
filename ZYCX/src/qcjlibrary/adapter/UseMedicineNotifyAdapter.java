package qcjlibrary.adapter;

import java.util.List;

import qcjlibrary.activity.UseMedicineNotifyActivity;
import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.adapter.base.BAdapter;
import qcjlibrary.adapter.base.ViewHolder;
import qcjlibrary.api.api.AlarmImpl;
import qcjlibrary.api.api.ZhiXunImpl;
import qcjlibrary.broadcast.AlarmBroadCastReciever;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.model.ModelAlertData;
import qcjlibrary.model.ModelMsg;
import qcjlibrary.model.ModelZiXun;
import qcjlibrary.model.ModelZiXunDetail;
import qcjlibrary.model.base.Model;
import qcjlibrary.response.DataAnalyze;
import qcjlibrary.util.DateUtil;
import qcjlibrary.util.SharedPreferencesUtil;
import qcjlibrary.util.ToastUtils;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.utils.L;
import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.sociax.android.Thinksns;

/**
 * author：qiuchunjia time：下午5:06:10
 * 
 * 类描述：这个类是实现专家提问列表
 *
 */

public class UseMedicineNotifyAdapter extends BAdapter {

	private AlarmManager mManager;

	public UseMedicineNotifyAdapter(BaseActivity activity, List<Model> list) {
		super(activity, list);
	}

	public UseMedicineNotifyAdapter(BaseFragment fragment, List<Model> list) {
		super(fragment, list);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.item_use_medicine, null);
			initView(convertView, holder);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		bindDataToView(holder, position);
		return convertView;
	}

	private void bindDataToView(ViewHolder holder, int position) {
		if (holder != null) {
			ModelAlertData mData = (ModelAlertData) mList.get(position);
			holder.tv_user_name.setText(mData.getUser());
			holder.tv_medicine_name.setText(mData.getMedicine());
			if (mData.getPeriod().equals("1")) {
				holder.tv_user_time.setText("每天" + mData.getMed_num() + "次");
			} else {
				holder.tv_user_time.setText("每" + mData.getPeriod() + "天" + mData.getMed_num() + "次");
			}
			setAlarm(position);
		}
	}

	/**
	 * 初始化布局
	 * 
	 * @param convertView
	 * @param holder
	 */
	private void initView(View convertView, ViewHolder holder) {
		if (convertView != null && holder != null) {
			holder.iv_medicine_notify = (ImageView) convertView.findViewById(R.id.iv_medicine_notify);
			holder.tv_user_name = (TextView) convertView.findViewById(R.id.tv_user_name);
			holder.tv_medicine_name = (TextView) convertView.findViewById(R.id.tv_medicine_name);
			holder.tv_user_time = (TextView) convertView.findViewById(R.id.tv_user_time);

		}
	}

	@Override
	public void refreshNew() {
		requstMessage(null, REFRESH_NEW);
	}

	@Override
	public void refreshHeader(Model item, int count) {
		// sendRequest(null, null, 1, 1);
	}

	@Override
	public void refreshFooter(Model item, int count) {
	}

	@Override
	public int getTheCacheType() {
		return 0;
	}

	@Override
	public Object getReallyList(Object object, Class type2) {
		if (object instanceof List<?>) {
			@SuppressWarnings("unchecked")
			List<ModelAlertData> mList = (List<ModelAlertData>) object;
			return mList;
		}
		return null;
	}

	/**
	 * 闹钟列表
	 * 
	 * @param data
	 * @param type
	 */
	private void requstMessage(ModelAlertData data, int type) {
		AlarmImpl impl = new AlarmImpl();
		sendRequest(impl.index(), ModelAlertData.class, 0, type);
	}

	@Override
	public Object onResponceSuccess(String str, Class class1) {
			return DataAnalyze.parseData(str, class1);
	}
	
	//删除闹钟，外部调用
	public void delete(ModelAlertData mData){
		AlarmImpl impl = new AlarmImpl();
		sendRequest(impl.delete(mData), ModelMsg.class, REQUEST_POST, REFRESH_NEW);
	}

	// 设置闹钟
	private void setAlarm(int position) {
		Context context = Thinksns.getContext();
		Intent mIntent = new Intent(context, AlarmBroadCastReciever.class);
		mIntent.setAction("alarm.alert.short");
		// 循环为每个闹钟设置广播
		ModelAlertData mData = (ModelAlertData) mList.get(position);
		mManager = (AlarmManager) context.getSystemService(context.ALARM_SERVICE);
		if (mData.getIs_remind() == 0) {
			String timeList = mData.getMed_time();
			String startTime = mData.getStime();
			String repeatDaily = mData.getPeriod();
			int period = Integer.parseInt(repeatDaily);
			// 根据重复天数计算出间隔的毫秒数
			long intervalMillis = DateUtil.setIntervalMillis(period);
			if(timeList == null){
				return;
			}
			String[] timeArr = timeList.split(",");
			// 为每一个时间设置广播
			for (int j = 0; j < timeArr.length; j++) {
				/** 区分不同闹钟的ID **/
				int id = 0;
				id = (Integer) SharedPreferencesUtil.getData(Thinksns.getContext(), 
						mData.getId() + ":" + id, id);
				if (timeArr[j] != null) {
					long currentMillis = System.currentTimeMillis();
					if (DateUtil.getYearMonDay(startTime) < currentMillis) {
						startTime = DateUtil.getYearMonDay(currentMillis);
					}
					// Log.d("Cathy", "开始年月日转换long:"+ getYearMonDay(startTime) +
					// "当前时间："+ currentMillis + "转换后："+ startTime);
					long triggerAtMillis = DateUtil.changeStr2Long(startTime + " " + timeArr[j] + ":00");
					Log.d("Cathy", "开始时间：" + startTime + " " + timeArr[j] + ":00" + " 换算前：" + triggerAtMillis);
					// 如果开始时间已经早于当前时间，则将当前时间设为开始时间
					if (currentMillis > triggerAtMillis) {
						triggerAtMillis = triggerAtMillis + intervalMillis;
						// Log.d("Cathy", "下次提醒时间：
						// "+changeLong2Str(triggerAtMillis));
					}
					/**
					 * 三种获取PendingIntent对象的方法 getActivity(Context, int, Intent,
					 * int) 启动一个activity getBroadcast(Context, int, Intent, int)
					 * 发送一个广播 getService(Context, int, Intent, int) 开启一个服务
					 */
					PendingIntent mPendingIntent = PendingIntent.getBroadcast(context, id, mIntent, 0);
					mManager.setRepeating(AlarmManager.RTC_WAKEUP, triggerAtMillis, intervalMillis, mPendingIntent);
					id++;
					SharedPreferencesUtil.saveData(context, mData.getId() + ":" + id, id);
				}
			}
		} else {
			L.d("Cathy", "cancel alert");
			PendingIntent mPendingIntent = PendingIntent.getBroadcast(context, 0, mIntent, 0);
			mManager.cancel(mPendingIntent);
		}
	}

}

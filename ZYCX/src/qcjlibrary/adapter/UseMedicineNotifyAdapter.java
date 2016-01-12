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
		//requstMessage(null, REFRESH_NEW);
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
		return null;
	}

}

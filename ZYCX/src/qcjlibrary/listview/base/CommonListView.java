package qcjlibrary.listview.base;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.model.base.Model;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;

/**
 * author：qiuchunjia time：下午3:19:03 类描述：这个类是实现
 *
 */

public class CommonListView extends BaseListView {

	public CommonListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public CommonListView(Context context) {
		super(context);
	}

	public void stepToNextActivity(AdapterView<?> parent, View view,
			int position, Class<? extends Activity> activityClass) {
		Model model = (Model) parent.getItemAtPosition(position);
<<<<<<< HEAD
		if (mActivity instanceof BaseActivity) {
			BaseActivity activity = ((BaseActivity) mActivity);
=======
		if (mContext instanceof BaseActivity) {
			BaseActivity activity = ((BaseActivity) mContext);
>>>>>>> 4bf5ea73991a31620f795e33af940c8d90a95782
			Bundle data = activity.sendDataToBundle(model, null);
			mApp.startActivity_qcj(activity, activityClass, data);
		}
	}
<<<<<<< HEAD

	public void stepToNextActivity(Model sendData,
			Class<? extends Activity> activityClass) {
		if (mActivity instanceof BaseActivity) {
			BaseActivity activity = ((BaseActivity) mActivity);
			Bundle data = activity.sendDataToBundle(sendData, null);
			mApp.startActivity_qcj(activity, activityClass, data);
		}
	}
=======
>>>>>>> 4bf5ea73991a31620f795e33af940c8d90a95782
}

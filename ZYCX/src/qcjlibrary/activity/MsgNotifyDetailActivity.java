package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
<<<<<<< HEAD
import qcjlibrary.model.ModelNotifyNotice;
=======
>>>>>>> 4bf5ea73991a31620f795e33af940c8d90a95782
import android.view.View;
import android.widget.TextView;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午4:25:49 类描述：这个类是实现
 *
 */

public class MsgNotifyDetailActivity extends BaseActivity {
	private TextView tv_system_notify;
	private TextView tv_date;
<<<<<<< HEAD
	private TextView tv_notify_title;
	private TextView tv_content;
	private ModelNotifyNotice mNotice;
=======
	private TextView tv_title;
	private TextView tv_content;
>>>>>>> 4bf5ea73991a31620f795e33af940c8d90a95782

	@Override
	public String setCenterTitle() {
		return "通知详情";
	}

	@Override
	public void initIntent() {
<<<<<<< HEAD
		mNotice = (ModelNotifyNotice) getDataFromIntent(getIntent(), null);
=======

>>>>>>> 4bf5ea73991a31620f795e33af940c8d90a95782
	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_notify_detail;
	}

	@Override
	public void initView() {
		tv_system_notify = (TextView) findViewById(R.id.tv_system_notify);
		tv_date = (TextView) findViewById(R.id.tv_date);
<<<<<<< HEAD
		tv_notify_title = (TextView) findViewById(R.id.tv_notify_title);
=======
		tv_title = (TextView) findViewById(R.id.tv_title);
>>>>>>> 4bf5ea73991a31620f795e33af940c8d90a95782
		tv_content = (TextView) findViewById(R.id.tv_content);

	}

	@Override
	public void initData() {
<<<<<<< HEAD
		if (mNotice != null) {
			if (mNotice.getType().equals("answer")) {
				tv_system_notify.setText("问答通知");
				tv_notify_title.setText(mNotice.getQuestion_content());
			} else if (mNotice.getType().equals("weiba")) {
				tv_system_notify.setText("经历小组通知");
				tv_notify_title.setText(mNotice.getContent());
			} else if (mNotice.getType().equals("notice")) {
				tv_system_notify.setText("系统通知");
				tv_notify_title.setText(mNotice.getContent());
			}
			tv_date.setText(mNotice.getTime());
		}
=======
		// TODO Auto-generated method stub
>>>>>>> 4bf5ea73991a31620f795e33af940c8d90a95782

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

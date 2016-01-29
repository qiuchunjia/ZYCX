package qcjlibrary.activity;

import com.umeng.socialize.utils.Log;
import com.zhiyicx.zycx.R;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.activity.base.Title;
import qcjlibrary.fragment.FragmentNotify;
import qcjlibrary.fragment.FragmentPraise;
import qcjlibrary.fragment.FragmentReplay;
import qcjlibrary.model.ModelMsg;
import qcjlibrary.model.ModelNotifyNotice;
import qcjlibrary.model.ModelNotiyState;

/**
 * author：qiuchunjia time：下午3:05:41 类描述：这个类是实现
 *
 */

public class MsgNotifyPraiseActivity extends BaseActivity {

	private TextView tv_msg;
	private TextView tv_praise;
	private TextView tv_notify;

	private FragmentNotify mNotifyFg;
	private FragmentPraise mPraiseFg;
	private FragmentReplay mReplayFg;
	private ImageView iv_msg_praise;
	
	private RelativeLayout rl_msg_praise;
	
	private String status;

	private Title mTitle;

	@Override
	public String setCenterTitle() {
		return "消息";
	}

	@Override
	public void initIntent() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_msg_notify_praise;
	}

	@Override
	public void initView() {
		tv_msg = (TextView) findViewById(R.id.tv_msg);
		tv_praise = (TextView) findViewById(R.id.tv_praise);
		tv_notify = (TextView) findViewById(R.id.tv_notify);
		iv_msg_praise = (ImageView) findViewById(R.id.iv_msg_praise);
		rl_msg_praise = (RelativeLayout) findViewById(R.id.rl_msg_praise);
	}

	@Override
	public void initData() {
		if (mReplayFg == null) {
			mReplayFg = new FragmentReplay();
		}
		replaceFragment(R.id.rl_content, mReplayFg);
		tv_msg.setBackgroundResource(R.drawable.view_border_green_left_solid_3);
		tv_msg.setTextColor(getResources().getColor(R.color.text_white));
		mTitle = getTitleClass();
		mTitle.tv_title_right.setText("清空");
		mTitle.tv_title_right.setVisibility(View.GONE);
		mTitle.tv_title_right.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				sendRequest(mApp.getNotifyImpl().delAll(), ModelMsg.class, REQUEST_GET);
			}
		});
	}

	@Override
	public Object onResponceSuccess(String str, Class class1) {
		Object object = super.onResponceSuccess(str, class1);
		if (judgeTheMsg(object)) {
			if (mNotifyFg != null) {
				mNotifyFg.DeleteAllMessage();
			}
		}
		if(object instanceof ModelNotiyState){
			ModelNotiyState state = (ModelNotiyState) object;
			status = state.getStatus();
			if(status != null && status.equals("1")){
				iv_msg_praise.setVisibility(View.VISIBLE);
			} else{
				iv_msg_praise.setVisibility(View.GONE);
			} 
		}
		return object;
	}

	@Override
	public void initListener() {
		tv_msg.setOnClickListener(this);
		tv_praise.setOnClickListener(this);
		tv_notify.setOnClickListener(this);
		rl_msg_praise.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		mTitle.tv_title_right.setVisibility(View.GONE);
		switch (v.getId()) {
		case R.id.tv_msg:
			resetTextBg();
			tv_msg.setBackgroundResource(R.drawable.view_border_green_left_solid_3);
			tv_msg.setTextColor(getResources().getColor(R.color.text_white));
			if (mReplayFg == null) {
				mReplayFg = new FragmentReplay();
			}
			replaceFragment(R.id.rl_content, mReplayFg);
			break;

		case R.id.tv_praise:
			resetTextBg();
			tv_praise.setBackgroundResource(R.drawable.view_border_green_solid_0);
			tv_praise.setTextColor(getResources().getColor(R.color.text_white));
			if (mPraiseFg == null) {
				mPraiseFg = new FragmentPraise();
			}
			replaceFragment(R.id.rl_content, mPraiseFg);

			break;
		case R.id.rl_msg_praise:
			resetTextBg();
			rl_msg_praise.setBackgroundResource(R.drawable.view_border_green_right_solid_3);
			tv_notify.setTextColor(getResources().getColor(R.color.text_white));
			if (mNotifyFg == null) {
				mNotifyFg = new FragmentNotify();
			}
			replaceFragment(R.id.rl_content, mNotifyFg);
			mTitle.tv_title_right.setVisibility(View.VISIBLE);
			break;
		}

	}

	/**
	 * 重置textview的背景
	 */
	private void resetTextBg() {
		tv_msg.setTextColor(getResources().getColor(R.color.text_more_gray));
		tv_praise.setTextColor(getResources().getColor(R.color.text_more_gray));
		tv_notify.setTextColor(getResources().getColor(R.color.text_more_gray));
		tv_msg.setBackgroundResource(R.drawable.view_border_green_left3);
		tv_praise.setBackgroundResource(R.drawable.view_border_only_top_bottom_green);
		rl_msg_praise.setBackgroundResource(R.drawable.view_border_green_right_3);
	}
	
	@Override
	protected void onResume() {
		// TODO 自动生成的方法存根
		super.onResume();
		/**
		 * 获取是否有未读消息
		 * */
		sendRequest(mApp.getNotifyImpl().isRead(), ModelNotiyState.class, REQUEST_GET);
	}

}

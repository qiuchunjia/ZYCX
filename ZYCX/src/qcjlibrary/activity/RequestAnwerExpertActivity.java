package qcjlibrary.activity;

import com.zhiyicx.zycx.LoginActivity;
import com.zhiyicx.zycx.R;

import android.view.View;
import android.view.View.OnClickListener;
import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.activity.base.Title;
import qcjlibrary.model.ModelRequestAsk;

public class RequestAnwerExpertActivity extends BaseActivity{

	private ModelRequestAsk mAsk;
	private Title mTitle;
	
	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public String setCenterTitle() {
		// TODO 自动生成的方法存根
		return "专家提问";
	}

	@Override
	public void initIntent() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public int getLayoutId() {
		// TODO 自动生成的方法存根
		return R.layout.listview_common_layout;
	}

	@Override
	public void initView() {
		// TODO 自动生成的方法存根
		titleSetRightImage(R.drawable.chuangjianjingli);
		mTitle = getTitleClass();
	}

	@Override
	public void initData() {
		// TODO 自动生成的方法存根
		mAsk = new ModelRequestAsk();
		mAsk.setIs_expert("1");
	}

	@Override
	public void initListener() {
		// TODO 发表专家问答
		mTitle.iv_title_right1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (isLogin()) {
					mAsk.setIs_expert("1");
					//获取病历信息，完善后才能提专家问答
					mApp.startActivity_qcj(RequestAnwerExpertActivity.this, 
							RequestSendTopicActivity.class, sendDataToBundle(mAsk, null));
				} else {
					mApp.startActivity_qcj(RequestAnwerExpertActivity.this, LoginActivity.class, null);
				}
			}
		});
	}

}

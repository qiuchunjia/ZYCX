package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.activity.base.Title;
import qcjlibrary.api.api;
import qcjlibrary.model.ModelRequestAsk;
import qcjlibrary.model.base.Model;
import qcjlibrary.util.ToastUtils;
import android.view.View;
import android.widget.TextView;

import com.zhiyicx.zycx.LoginActivity;
import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午4:31:08 类描述：这个类是实现
 *
 */

public class RequestWayActivity extends BaseActivity {
	private TextView tv_common;
	private TextView tv_zhuanye;
	private ModelRequestAsk mAsk;
	private String medrecord_state;

	@Override
	public String setCenterTitle() {
		return "提问方式";
	}

	@Override
	public void initIntent() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_request_way;
	}

	@Override
	public void initView() {
		titleSetRightTitle("关闭");
		tv_common = (TextView) findViewById(R.id.tv_common);
		tv_zhuanye = (TextView) findViewById(R.id.tv_zhuanye);
		mAsk = new ModelRequestAsk();
	}

	@Override
	public void initData() {
		Title title = getTitleClass();
		title.tv_title_right.setOnClickListener(this);
	}

	@Override
	public void initListener() {
		tv_zhuanye.setOnClickListener(this);
		tv_common.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_title_right:
			onBackPressed();
			break;

		case R.id.tv_common:
			if (isLogin()) {
				mAsk.setIs_expert("0");
				mApp.startActivity_qcj(this, RequestSendTopicActivity.class, sendDataToBundle(mAsk, null));
			} else {
				mApp.startActivity_qcj(this, LoginActivity.class, null);
			}
			break;
		case R.id.tv_zhuanye:
			if (isLogin()) {
				mAsk.setIs_expert("1");
				//获取病历信息，完善后才能提专家问答
				sendRequest(mApp.getRequestImpl().getMedrecordState(), ModelRequestAsk.class, REQUEST_GET);
			} else {
				mApp.startActivity_qcj(this, LoginActivity.class, null);
			}
			break;
		}

	}
	
	@Override
	public View onRequestFailed() {
		// TODO 自动生成的方法存根
		return super.onRequestFailed();
	}
	
	@Override
	public View onRequestSuccess() {
		// TODO 自动生成的方法存根
		return super.onRequestSuccess();
	}
	
	@Override
	public Object onResponceSuccess(String str, Class class1) {
		// TODO 自动生成的方法存根
		Object object =  super.onResponceSuccess(str, class1);
		if(object instanceof ModelRequestAsk){
			medrecord_state = ((ModelRequestAsk)object).getStatus();
			if(medrecord_state.equals("1")){
				mApp.startActivity_qcj(this, RequestSendTopicActivity.class, sendDataToBundle(mAsk, null));
			} else{
				ToastUtils.showLongToast(this, "请先完善病历信息！");
			}
		}
		return object;
	}
}

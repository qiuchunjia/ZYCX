package qcjlibrary.fragment;

import com.zhiyicx.zycx.LoginActivity;
import com.zhiyicx.zycx.R;

import android.view.View;
import android.widget.TextView;
import qcjlibrary.activity.PatientMeActivity;
import qcjlibrary.activity.RequestAnwerCommonActivity;
import qcjlibrary.activity.RequestAnwerExpertActivity;
import qcjlibrary.activity.RequestSendTopicActivity;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.model.ModelRequestAsk;
import qcjlibrary.util.ToastUtils;

public class FragmentRequestAnwerIndex extends BaseFragment{

	private TextView tv_common;
	private TextView tv_zhuanye;
	private ModelRequestAsk mAsk;
	private String medrecord_state;
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_common:
			mApp.startActivity_qcj(getActivity(), RequestAnwerCommonActivity.class, 
						null);
			break;
		case R.id.tv_zhuanye:
			if (isLogin()) {
				//获取病历信息，完善后才能提专家问答
				sendRequest(mApp.getRequestImpl().getMedrecordState(), ModelRequestAsk.class, REQUEST_GET);
			} else {
				mApp.startActivity_qcj(getActivity(), LoginActivity.class, null);
			}
			break;
		}

	}

	@Override
	public void initIntentData() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public int getLayoutId() {
		// TODO 自动生成的方法存根
		return R.layout.activity_request_way;
	}

	@Override
	public void initView() {
		// TODO 自动生成的方法存根
		tv_common = (TextView) findViewById(R.id.tv_common);
		tv_zhuanye = (TextView) findViewById(R.id.tv_zhuanye);
		mAsk = new ModelRequestAsk();
	}

	@Override
	public void initListener() {
		// TODO 自动生成的方法存根
		tv_zhuanye.setOnClickListener(this);
		tv_common.setOnClickListener(this);
	}

	@Override
	public void initData() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public Object onResponceSuccess(String str, Class class1) {
		// TODO 自动生成的方法存根
		Object object =  super.onResponceSuccess(str, class1);
		if(object instanceof ModelRequestAsk){
			medrecord_state = ((ModelRequestAsk)object).getStatus();
			if(medrecord_state.equals("1")){
				mApp.startActivity_qcj(getActivity(), RequestAnwerExpertActivity.class, 
						null);
			} else{
				ToastUtils.showLongToast(getActivity(), "请先完善病历信息！");
				mApp.startActivity_qcj(getActivity(), PatientMeActivity.class, 
						null);
			}
		}
		return object;
	}
}

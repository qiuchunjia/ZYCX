package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.adapter.MeChooseCancerAdapter;
import qcjlibrary.adapter.base.BAdapter;
import qcjlibrary.listview.base.CommonListView;
import qcjlibrary.model.ModelCenterCancer;
import qcjlibrary.model.ModelFoodIdDetail;
import qcjlibrary.model.ModelMsg;
import qcjlibrary.model.ModelUser;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午5:33:01 类描述：这个类是实现
 *
 */

public class MeChooseCancerActivity extends BaseActivity {
	private CommonListView mCommonListView;
	private BAdapter mAdapter;
	/** 网络异常时的缺省图**/
	private View defaultView;
	private boolean isFirst = false;
	private LinearLayout ll_commonlist_parent;

	@Override
	public String setCenterTitle() {
		return "癌种";
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
		mCommonListView = (CommonListView) findViewById(R.id.mCommonListView);
		ll_commonlist_parent = (LinearLayout) findViewById(R.id.ll_commonlist_parent);
		mAdapter = new MeChooseCancerAdapter(this);
		mCommonListView.setAdapter(mAdapter);
		mCommonListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				ModelCenterCancer cancer = (ModelCenterCancer) parent
						.getItemAtPosition(position);
				updateTheUserInfor(cancer);
			}

		});
	}

	/**
	 * 选择癌症
	 * 
	 * @param cancer
	 */
	private void updateTheUserInfor(ModelCenterCancer cancer) {
		if (cancer != null) {
			ModelUser user = new ModelUser();
			user.setCancer(cancer.getCancer_id());
			sendRequest(mApp.getUserImpl().edituserdata(user), ModelMsg.class,
					REQUEST_GET);
		}
	}

	@Override
	public Object onResponceSuccess(String str, Class class1) {
		Object object = super.onResponceSuccess(str, class1);
		if (judgeTheMsg(object)) {
			onBackPressed();
		}
		return object;
	}

	@Override
	public void initData() {
	}

	@Override
	public void initListener() {

	}

	@Override
	public void onClick(View v) {
	}
	
//	@Override
//	public View onRequestFailed() {
//		// TODO 自动生成的方法存根
//		defaultView = super.onRequestFailed();
//		TextView tv_reload = (TextView) defaultView.findViewById(R.id.tv_reload);
//		tv_reload.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				sendRequest(mApp.getUserImpl().edituserdata(user), ModelMsg.class,
//						REQUEST_GET);
//			}
//		});
//		mCommonListView.setVisibility(View.GONE);
//		if(!isFirst){
//			isFirst = true;
//			ll_commonlist_parent.addView(defaultView); 
//		} else{
//			defaultView.setVisibility(View.VISIBLE);
//		}
//		return defaultView;
//	}
//	
//	@Override
//	public View onRequestSuccess() {
//		mCommonListView.setVisibility(View.VISIBLE);
//		return defaultView;
//	}

}

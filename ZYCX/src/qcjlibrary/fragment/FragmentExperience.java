package qcjlibrary.fragment;

import java.util.ArrayList;
import java.util.List;

import com.zhiyicx.zycx.R;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import qcjlibrary.adapter.ExperienceAdapter;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.model.ModelExperience;
import qcjlibrary.model.ModelExperiencePostDetail;
import qcjlibrary.response.DataAnalyze;
import qcjlibrary.util.DefaultLayoutUtil;
import qcjlibrary.util.L;

/**
 * author：qiuchunjia time：下午3:30:35 类描述：这个类是实现
 *
 */

public class FragmentExperience extends BaseFragment {
	private GridView gv_experience;
	private ExperienceAdapter mAdapter;
	private List<ModelExperience> mList;
	
	/** 网络异常时的缺省图**/
	private View defaultView;
	private boolean isFirst = true;
	private LinearLayout ll_fragexp_parent;

	@Override
	public void initIntentData() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.fragment_experience_layout2;
	}

	@Override
	public void initView() {
		gv_experience = (GridView) findViewById(R.id.gv_experience);
		ll_fragexp_parent = (LinearLayout) findViewById(R.id.ll_fragexp_parent);
		mList = new ArrayList<ModelExperience>();
	}

	@Override
	public void initListener() {

	}

	@Override
	public void initData() {
		//sendRequest(mApp.getExperienceImpl().index(), ModelExperience.class, REQUEST_GET);
	}

	@Override
	public Object onResponceSuccess(String str, Class class1) {
		Object object = DataAnalyze.parseData(str, class1);
		if (object instanceof List<?>) {
			mList = (List<ModelExperience>) object;
			mAdapter = new ExperienceAdapter(mActivity, mList);
			gv_experience.setAdapter(mAdapter);
		}
		return object;
	}

	@Override
	public void onResume() {
		super.onResume();
		if (mList != null) {
			sendRequest(mApp.getExperienceImpl().index(), ModelExperience.class, REQUEST_GET);
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public View onRequestFailed() {
		// TODO 自动生成的方法存根
		defaultView =  super.onRequestFailed();
		TextView tv_reload = (TextView) defaultView.findViewById(R.id.tv_reload);
		tv_reload.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sendRequest(mApp.getExperienceImpl().index(), 
						ModelExperience.class, REQUEST_GET);
			}
		});
		
		isFirst = DefaultLayoutUtil.showDefault(ll_fragexp_parent, defaultView, isFirst);
		return defaultView;
	}
	
	@Override
	public View onRequestSuccess() {
		// TODO 自动生成的方法存根
		defaultView = super.onRequestSuccess();
		DefaultLayoutUtil.hideDefault(ll_fragexp_parent, defaultView);
		return defaultView;
	}

}

package qcjlibrary.fragment;

import java.util.ArrayList;
import java.util.List;

import com.zhiyicx.zycx.R;

import android.view.View;
import android.widget.GridView;
import qcjlibrary.adapter.ExperienceAdapter;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.model.ModelExperience;
import qcjlibrary.response.DataAnalyze;

/**
 * author：qiuchunjia time：下午3:30:35 类描述：这个类是实现
 *
 */

public class FragmentExperience extends BaseFragment {
	private GridView gv_experience;
	private ExperienceAdapter mAdapter;
	private List<ModelExperience> mList;

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
		mList = new ArrayList<ModelExperience>();
	}

	@Override
	public void initListener() {

	}

	@Override
	public void initData() {
		sendRequest(mApp.getExperienceImpl().index(), ModelExperience.class, REQUEST_GET);

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
		if (mList != null && mList.size() == 0) {
			sendRequest(mApp.getExperienceImpl().index(), ModelExperience.class, REQUEST_GET);
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}

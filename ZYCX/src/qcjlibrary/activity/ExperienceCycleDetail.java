package qcjlibrary.activity;

import com.zhiyicx.zycx.R;

import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.model.ModelExperiencePostDetailItem;

/**
 * author：qiuchunjia time：下午4:34:47 类描述：这个类是实现
 *
 */

public class ExperienceCycleDetail extends BaseActivity {
	private String mUrl;
	private WebView wv_view;
	private ModelExperiencePostDetailItem mItems;

	@Override
	public String setCenterTitle() {
		return "经历详情";
	}

	@Override
	public void initIntent() {
		mItems = (ModelExperiencePostDetailItem) getDataFromIntent(getIntent(), null);
	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_experience_cycle_detail;
	}

	@Override
	public void initView() {
		wv_view = (WebView) findViewById(R.id.wv_view);

	}

	@Override
	public void initData() {
		if (mItems != null) {
			mUrl = mApp.getHostUrl() + mApp.getExperienceImpl().showPost(mItems).toString();
			Log.i("murl", mUrl);
			wv_view.loadUrl(mUrl);
		}

	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {

	}

}

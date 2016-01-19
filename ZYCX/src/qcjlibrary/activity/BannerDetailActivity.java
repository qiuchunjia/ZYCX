package qcjlibrary.activity;

import com.zhiyicx.zycx.R;

import android.annotation.SuppressLint;
import android.view.View;
import android.webkit.WebView;
import qcjlibrary.activity.base.BaseActivity;

public class BannerDetailActivity extends BaseActivity {
	private WebView view_qikan;
	private String mUrl;

	@Override
	public String setCenterTitle() {
		return "banner详情";
	}

	@Override
	public void initIntent() {
		mUrl = getIntent().getStringExtra("bannerurl");
	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_banner_detail;
	}

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public void initView() {
		view_qikan = (WebView) findViewById(R.id.view_qikan);
		view_qikan.getSettings().setJavaScriptEnabled(true);
	}

	@Override
	public void initData() {
		mUrl = "http://" + mUrl;
		view_qikan.loadUrl(mUrl);
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

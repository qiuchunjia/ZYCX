package com.zhiyicx.zycx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.ProgressBar;
import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.config.Config;
import qcjlibrary.model.ModelPeriodical;
import qcjlibrary.util.L;
import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.sso.UMSsoHandler;
import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.config.MyConfig;
import com.zhiyicx.zycx.net.JsonDataListener;
import com.zhiyicx.zycx.net.NetComTools;
import com.zhiyicx.zycx.util.Utils;

import org.json.JSONObject;

/**
 * Created by Administrator on 2015/1/3.
 */
public class QiKanDetailsActivity extends BaseActivity implements View.OnClickListener {

	final private static String TAG = "QiKanDetailsActivity";
	private final UMSocialService mController = UMServiceFactory.getUMSocialService("com.umeng.share");
	private ProgressBar mProgBar = null;
	private WebView mWebView = null;
	private String mUrl = null;
	private String mTitle;
	private int pid;

	@Override
	public String setCenterTitle() {
		return "期刊详情";
	}

	@Override
	public void initIntent() {
		Bundle bundle = getIntent().getExtras();
		ModelPeriodical mData = (ModelPeriodical) bundle.get(Config.ACTIVITY_TRANSFER_BUNDLE);
		pid = mData.getPid();
	}

	@Override
	public int getLayoutId() {
		return R.layout.qikan_details_layout;
	}

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public void initView() {
		titleSetRightTitle("分享");
		mWebView = (WebView) findViewById(R.id.view_qikan);
		mWebView.getSettings().setJavaScriptEnabled(true);
		mProgBar = (ProgressBar) findViewById(R.id.progressBar);

	}

	@Override
	public void initData() {
		L.d("Cathy", "pid:"+pid);
		loadData(pid);
	}

	@Override
	public void initListener() {
		getTitleClass().tv_title_right.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_title_right:
			if (TextUtils.isEmpty(mUrl))
				return;
			/*
			 * Intent intent = new Intent(Intent.ACTION_SEND);
			 * intent.putExtra(Intent.EXTRA_TEXT, mUrl);
			 * intent.setType("text/plain");
			 * intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			 * startActivity(Intent.createChooser(intent, "分享到"));
			 */
			Utils.shareText(this, mController, "青稞网期刊分享:" + mTitle + " - ", mUrl);
			break;
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		/** 使用SSO授权必须添加如下代码 */
		UMSsoHandler ssoHandler = mController.getConfig().getSsoHandler(requestCode);
		if (ssoHandler != null) {
			ssoHandler.authorizeCallBack(requestCode, resultCode, data);
		}
	}
	
	private void loadData(int id) {
		String url = MyConfig.QIKAN_DETAILS_URL + Utils.getTokenString(this) + "&pid=" + id;
		NetComTools netComTools = NetComTools.getInstance(this);
		netComTools.getNetJson(url, new JsonDataListener() {
			@Override
			public void OnReceive(JSONObject jsonObject) {
				// Log.d(TAG, "Qikan details data:" + jsonObject.toString());
				try {
					int ret = jsonObject.getInt("code");
					if (ret == 0) {
						mUrl = jsonObject.getString("data");
						mWebView.loadUrl(mUrl);
						mProgBar.setVisibility(View.GONE);
						mWebView.setVisibility(View.VISIBLE);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			@Override
			public void OnError(String error) {
				Log.d(TAG, "Get Qikan details error, " + error);
			}
		});
	}
}

package com.zhiyicx.zycx.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings.PluginState;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import qcjlibrary.activity.QclassCmtSendActivity;
import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.activity.base.Title;
import qcjlibrary.config.Config;
import qcjlibrary.model.ModelQclassDetail;
import qcjlibrary.model.ModelShareContent;
import qcjlibrary.util.L;
import qcjlibrary.widget.popupview.PopQclassCmt;
import qcjlibrary.widget.popupview.PopShareContent;

import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.sso.UMSsoHandler;
import com.zhiyicx.zycx.LoginActivity;
import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.config.MyConfig;
import com.zhiyicx.zycx.fragment.ClassCmtFragment;
import com.zhiyicx.zycx.fragment.ClassDetailsFragment;
import com.zhiyicx.zycx.fragment.ClassListFragment;
import com.zhiyicx.zycx.adapter.ListFragmentAdapter;
import com.zhiyicx.zycx.net.JsonDataListener;
import com.zhiyicx.zycx.net.NetComTools;
import com.zhiyicx.zycx.net.StringDataListener;
import com.zhiyicx.zycx.sociax.unit.SociaxUIUtils;
import com.zhiyicx.zycx.util.Utils;
import com.zhiyicx.zycx.widget.PagerSlidingTabStrip;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * 轻课堂详细界面
 * 
 * @author Tan
 * @since 1.4
 */
public class QClassDetailsActivity extends BaseActivity
		implements View.OnClickListener, ClassListFragment.PlayListener, ViewPager.OnPageChangeListener {

	final private static String TAG = "QClassDetailsActivity";
	private final UMSocialService mController = UMServiceFactory.getUMSocialService("com.umeng.share");
	private ViewPager mPager;
	private PagerSlidingTabStrip mTabs;
	// private WebView mWebview = null;
	private ImageView mPreview = null;

	/** 课程列表Fragment **/
	private ClassListFragment mListfgmt = null;
	/** 评论列表Fragment **/
	private ClassCmtFragment mCmtFgmt = null;
	/** 课程详情Fragment **/
	private ClassDetailsFragment mDetailsFgmt = null;
	private JSONObject mClassData = null;
	// private PopupWindow mCmdWindow = null;
	// private EditText mCmtEdit = null;

	private TextView tv_title_right;

	private String mDefVurl = null;
	private String mDefId = null;
	private String mDefVid = null;
	private int mCid;
	private String mTitle = null;
	private String cover;
	private Title title;
	/** 视频播放 **/
	private LinearLayout info_layout;
	private LinearLayout ll_fullscreen;
	private WebView iv_qclass_play;
	private String urlStr;
	private LinearLayout ll_qclass_detail;
	private WebChromeClient chromeClient = null;
	private View myView = null;
	private WebChromeClient.CustomViewCallback myCallBack = null;

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		// ** 使用SSO授权必须添加如下代码 *//*
		UMSsoHandler ssoHandler = mController.getConfig().getSsoHandler(requestCode);
		if (ssoHandler != null) {
			ssoHandler.authorizeCallBack(requestCode, resultCode, data);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_title_right3:
			ModelShareContent content = new ModelShareContent();
			content.setType(Config.SHARE_VIDEO);
			content.setTitle(mTitle);
			content.setUrl(mDefVurl);
			PopShareContent popShareContent = new PopShareContent(this, content, this);
			popShareContent.showPop(iv_qclass_play, Gravity.BOTTOM, 0, 0);
			// Utils.shareVidoe(this, mController, mTitle, mDefVurl);
			break;
		case R.id.tv_title_right:
			// 先判断是否登录
			if (isLogin()) {
				Bundle bundle = new Bundle();
				bundle.putSerializable("mDefId", mDefId);
				mApp.startActivity_qcj(this, QclassCmtSendActivity.class, bundle);
			} else {
				mApp.startActivity_qcj(this, LoginActivity.class, null);
			}
			break;
		case R.id.iv_qclass_play:
			// 跳转播放
//			 String urlStr = mDefVurl + "&course_id=" + mCid + "&id=" + mDefId
//			 + "&uid=" + Utils.getUid(this);
//			 Intent intent = new Intent(this, QClassPlayActivity.class);
//			 intent.putExtra("vurl", urlStr);
//			 startActivity(intent);
			// Uri uri = Uri.parse(urlStr);
			// Intent it = new Intent(Intent.ACTION_VIEW, uri);
			// startActivity(it);
			break;
		}
	}

	/*
	 * private void showCmtWindow() { if (mCmdWindow == null) { View view =
	 * getLayoutInflater().inflate(R.layout.class_cmt_edit, null); mCmtEdit =
	 * (EditText) view.findViewById(R.id.edit_cmt);
	 * view.findViewById(R.id.btn_comment).setOnClickListener(this); //
	 * view.findViewById(R.id.txt_my).setOnClickListener(this); mCmdWindow = new
	 * PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,
	 * ViewGroup.LayoutParams.WRAP_CONTENT); //
	 * mCmdWindow.setAnimationStyle(R.style.popwin_anim_style);
	 * mCmdWindow.setFocusable(true); // mCmdWindow.setOutsideTouchable(true);
	 * mCmdWindow.update(); mCmdWindow.setBackgroundDrawable(new
	 * BitmapDrawable()); } if (mCmdWindow.isShowing()) { mCmdWindow.dismiss();
	 * SociaxUIUtils.hideSoftKeyboard(this, mCmtEdit); } else {
	 * mCmdWindow.showAtLocation(mYoukuPlayerView, Gravity.BOTTOM, 0, 0);
	 * SociaxUIUtils.showSoftKeyborad(this, mCmtEdit); } }
	 */

	@Override
	public void OnPlay(String url, String id, String vid) {
		mDefVurl = url;
		mDefId = id;
		mDefVid = vid;
		// toPlay();
		urlStr = mDefVurl + "&course_id=" + mCid + "&id=" + mDefId + "&uid=" + Utils.getUid(this);
		iv_qclass_play.loadUrl(urlStr + Utils.getTokenString(this));
	}

	@Override
	public void onPageSelected(int i) {
		if (i == 1) {
			mCmtFgmt.loadCmtData(mDefId);
		}
	}

	@Override
	public void onPageScrolled(int i, float v, int i2) {
	}

	@Override
	public void onPageScrollStateChanged(int i) {
	}

	/*
	 * // 记录 private void toPlay() { try { if (mYoukuPlayer != null)
	 * mYoukuPlayer.playVideo(mDefVid); } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * String url = mDefVurl + "&course_id=" + mCid + "&id=" + mDefId + "&uid="
	 * + Utils.getUid(this); NetComTools netComTools =
	 * NetComTools.getInstance(this); netComTools.getNetString(url, new
	 * StringDataListener() {
	 * 
	 * @Override public void OnReceive(String data) {
	 * 
	 * }
	 * 
	 * @Override public void OnError(String error) {
	 * 
	 * } }); }
	 */

	@Override
	public String setCenterTitle() {
		// TODO 自动生成的方法存根
		return "课程";
	}

	@Override
	public void initIntent() {
		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			ModelQclassDetail mDetail = (ModelQclassDetail) bundle.getSerializable(Config.ACTIVITY_TRANSFER_BUNDLE);
			mCid = mDetail.getCourse_id();
			cover = mDetail.getCover();
		}
		if (mCid == -1) {
			finish();
		}
	}

	@Override
	public int getLayoutId() {
		return R.layout.qclass_details_layout;
	}

	@Override
	public void initView() {
		titleSetRightTitle("评论");
		title = getTitleClass();
		title.iv_title_right3.setVisibility(View.VISIBLE);
		title.iv_title_right3.setImageResource(R.drawable.fenxiang);
		mPager = (ViewPager) findViewById(R.id.vPager);
		mTabs = (PagerSlidingTabStrip) findViewById(R.id.sliding_tabs);
		iv_qclass_play = (WebView) findViewById(R.id.iv_qclass_play);
		tv_title_right = (TextView) findViewById(R.id.tv_title_right);
		ll_qclass_detail = (LinearLayout) findViewById(R.id.ll_qclass_detail);
		info_layout = (LinearLayout) findViewById(R.id.info_layout);
		ll_fullscreen = (LinearLayout) findViewById(R.id.ll_fullscreen);
		// 设置WebView
		iv_qclass_play.setPadding(0, 0, 0, 0);
		chromeClient = new MyChromeClient();
		//暂时无法全屏
		iv_qclass_play.setWebChromeClient(new WebChromeClient());
		WebSettings setting = iv_qclass_play.getSettings();
		setting.setPluginState(PluginState.ON);
		setting.setLoadWithOverviewMode(true);//居中
		setting.getUseWideViewPort();
		setting.setJavaScriptEnabled(true);
		setting.setJavaScriptCanOpenWindowsAutomatically(true);
//		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	}

	@Override
	public void initData() {
		if (!TextUtils.isEmpty(cover)) {
			mPreview = (ImageView) findViewById(R.id.img_preview);
			// mApp.displayImage(cover, iv_qclass_play);
			L.d("Cathy", "cover : " + cover);
		}
		loadInfo(mCid);
	}

	@Override
	public void initListener() {
		mTabs.setOnPageChangeListener(this);
		iv_qclass_play.setOnClickListener(this);
		tv_title_right.setOnClickListener(this);
		title.iv_title_right3.setOnClickListener(this);
		iv_qclass_play.setWebViewClient(new WebViewClient() {
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
		});
	}


	/**
	 * 发送评论到服务器
	 * 
	 * @param String
	 *            content 评论内容
	 */
	private void sendCmt(String content) {
		String url = MyConfig.QCLASS_ADDCMT_URL + Utils.getTokenString(this) + "&id=" + mDefId;
		url += "&content=" + Utils.getUTF8String(content);
		NetComTools netComTools = NetComTools.getInstance(this);
		netComTools.getNetJson(url, new JsonDataListener() {
			@Override
			public void OnReceive(JSONObject jsonObject) {
				Log.d(TAG, "send cmt data, " + jsonObject.toString());
				try {
					int code = jsonObject.getInt("code");
					if (code == 0) {
						Utils.showToast(QClassDetailsActivity.this, "评论成功!");
						// mCmtEdit.setText("");
						mCmtFgmt.loadCmtData(mDefId);
					} else {
						String msg = jsonObject.getString("message");
						if (!TextUtils.isEmpty(msg))
							Utils.showToast(QClassDetailsActivity.this, msg);
					}
				} catch (Exception e) {
				}
			}

			@Override
			public void OnError(String error) {
			}
		});
		// mCmdWindow.dismiss();
	}

	private void initViewPager() throws Exception {
		mTitle = mClassData.optString("course_name");
		JSONArray array = mClassData.optJSONArray("list");
		mDefVurl = mClassData.optString("default_vurl");
		mDefId = mClassData.optString("default_id");
		mDefVid = mClassData.optString("default_vid");
		if (TextUtils.isEmpty(mDefVurl)) {
			JSONObject jsonObject = (JSONObject) array.get(0);
			mDefId = jsonObject.getString("id");
			mDefVurl = jsonObject.getString("v_url");
			mDefVid = jsonObject.optString("default_vid");
		}

		// toPlay();
		mListfgmt = ClassListFragment.newInstance(mTitle, array, mDefId);
		mListfgmt.setPlayListener(this);
		mCmtFgmt = ClassCmtFragment.newInstance(mDefId);
		String pohto_url = mClassData.optString("avatar_small");
		String tname = mClassData.optString("uname");
		String tinfo = mClassData.optString("tinfo");
		String cinfo = mClassData.optString("course_info");
		mDetailsFgmt = ClassDetailsFragment.newInstance(mTitle, pohto_url, tname, tinfo, cinfo);
		ArrayList<Fragment> fragments = new ArrayList<Fragment>();
		fragments.add(mListfgmt);
		fragments.add(mCmtFgmt);
		fragments.add(mDetailsFgmt);
		ListFragmentAdapter adapter = new ListFragmentAdapter(getSupportFragmentManager(), fragments,
				new String[] { "章节", "讨论", "详细信息" });
		mPager.setAdapter(adapter);
		mTabs.setViewPager(mPager);
		setTabsValue();
	}

	private void loadInfo(int id) {
		String url = MyConfig.QCLASS_DETAILs_URL + Utils.getTokenString(this) + "&cid=" + id;
		NetComTools netComTools = NetComTools.getInstance(this);
		netComTools.getNetJson(url, new JsonDataListener() {
			@Override
			public void OnReceive(JSONObject jsonObject) {
				Log.d(TAG, "Qclass details data:" + jsonObject.toString());
				try {
					int ret = jsonObject.getInt("code");
					if (ret == 0) {
						mClassData = jsonObject.getJSONObject("data");
						initViewPager();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			@Override
			public void OnError(String error) {
				Log.d(TAG, "Get Qclass details error, " + error);
			}
		});
	}

	private void setTabsValue() {
		mTabs.setShouldExpand(true);
		mTabs.setDividerColor(Color.TRANSPARENT);
		DisplayMetrics dm = getResources().getDisplayMetrics();
		mTabs.setUnderlineHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1, dm));
		mTabs.setIndicatorHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, dm));
		//mTabs.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, dm));
		mTabs.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 17, dm));
		mTabs.setIndicatorColor(Color.parseColor("#ffffff"));
		mTabs.setSelectedTextColor(Color.parseColor("#349342"));
		mTabs.setTabBackground(0);
	}

	@Override
	protected void onResume() {
		// TODO 自动生成的方法存根
		super.onResume();
		if(mCmtFgmt != null){
			mCmtFgmt.loadCmtData(mDefId);
		}
	}

	@Override
	protected void onPause() {
		// TODO 自动生成的方法存根
		super.onPause();
		try {
			iv_qclass_play.getClass().getMethod("onPause").invoke(iv_qclass_play, (Object[]) null);
		} catch (Exception e) {
			L.d("停止播放" + e.toString());
		}
	}

	public class MyChromeClient extends WebChromeClient {

		@Override
		public void onShowCustomView(View view, CustomViewCallback callback) {
			if (myView != null) {
				callback.onCustomViewHidden();
				return;
			}
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
			iv_qclass_play.setVisibility(View.GONE);
			info_layout.setVisibility(View.GONE);
			ll_fullscreen.setVisibility(View.VISIBLE);
			ll_fullscreen.addView(view);
			myView = view;
			myCallBack = callback;
		}

		@Override
		public void onHideCustomView() {
			if (myView == null) {
				return;
			}
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
			ll_fullscreen.setVisibility(View.GONE);
			iv_qclass_play.setVisibility(View.VISIBLE);
			info_layout.setVisibility(View.VISIBLE);
			ll_fullscreen.removeView(myView);
			myView = null;
			myCallBack.onCustomViewHidden();
		}

		@Override
		public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
			// TODO Auto-generated method stub
			Log.d("ZR",
					consoleMessage.message() + " at " + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber());
			return super.onConsoleMessage(consoleMessage);
		}
	}
}

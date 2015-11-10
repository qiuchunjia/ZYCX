package com.zhiyicx.zycx.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.activity.base.Title;
import qcjlibrary.fragment.FragmentIndex;
import qcjlibrary.fragment.FragmentMenu;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.baidu.appx.BDInterstitialAd;
import com.nineoldandroids.view.ViewHelper;
import com.umeng.analytics.MobclickAgent;
import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.fragment.QClassFragment;
import com.zhiyicx.zycx.fragment.QiKanFragment;
import com.zhiyicx.zycx.fragment.QuestionFragment;
import com.zhiyicx.zycx.fragment.WebFragment;
import com.zhiyicx.zycx.fragment.ZiXunFragment;
import com.zhiyicx.zycx.sociax.android.Thinksns;
import com.zhiyicx.zycx.sociax.net.HttpHelper;
import com.zhiyicx.zycx.sociax.unit.Anim;

public class HomeActivity extends BaseActivity {
	private ZiXunFragment mZiXunFgmt; // 咨询fragment qcj
	private QClassFragment mQClassFgmt; // 轻课堂fragment qcj
	private QuestionFragment mQustionFgmt;// 问答fragment qcj
	private QiKanFragment mQiKanFgmt;// 期刊fragment qcj
	private WebFragment mWebFgmt;// 微博fragment 这里主要是用的ts3.0来实现的 qcj

	private FragmentIndex mDefaultFragment; // 新增加的页面
	public static final int index_Default = -1;
	public static final int index_zhixun = 0;
	public static final int index_qclass = 1;
	public static final int index_qustion = 2;
	public static final int index_qikan = 3;
	public static final int index_web = 4;
	private int mCurrentIndex = index_Default; // 当前所处的位置 默认为-1

	private RelativeLayout mZixunLayout, mClassLayout, mQuestionLayout,
			mQikanLayout, mWebLayout;
	private BDInterstitialAd appxInterstitialAdView;
	private String TAG = "HomeActivity";
	private DrawerLayout mDrawer;
	private FragmentMenu mMenu;

	@Override
	public void initSet() {
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);// 竖屏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		mApp = (Thinksns) getApplication();
		mInflater = LayoutInflater.from(getApplicationContext());
		setContentView(R.layout.comom_layout_drawer);
		initParentView();
		// 把内容和title结合
		combineTheLayout();
		initIntent();
		initView();
		initData();
		initListener();
		initEvents();
	}

	private void initEvents() {
		Title title = getTitleClass();
		if (title != null) {
			title.rl_left_1.setVisibility(View.GONE);
			title.rl_left_2.setVisibility(View.VISIBLE);
		}
		titleSlideMenu(mDrawer);
		mDrawer.setDrawerListener(new DrawerListener() {
			@Override
			public void onDrawerStateChanged(int newState) {
			}

			@Override
			public void onDrawerSlide(View drawerView, float slideOffset) {
				View mContent = mDrawer.getChildAt(0);
				View mMenu = drawerView;
				float scale = 1 - slideOffset;
				float rightScale = 0.8f + scale * 0.2f;

				if (drawerView.getTag().equals("LEFT")) {
					float leftScale = 1 - 0.3f * scale;
					ViewHelper.setScaleX(mMenu, leftScale);
					ViewHelper.setScaleY(mMenu, leftScale);
					ViewHelper.setAlpha(mMenu, 0.6f + 0.4f * (1 - scale));
					ViewHelper.setTranslationX(mContent,
							mMenu.getMeasuredWidth() * (1 - scale));
					ViewHelper.setPivotX(mContent, 0);
					ViewHelper.setPivotY(mContent,
							mContent.getMeasuredHeight() / 2);
					mContent.invalidate();
					ViewHelper.setScaleX(mContent, rightScale);
					ViewHelper.setScaleY(mContent, rightScale);
				}

			}

			@Override
			public void onDrawerOpened(View drawerView) {
			}

			@Override
			public void onDrawerClosed(View drawerView) {
			}
		});
	}

	/**
	 * 初始化父布局，这个本来是父类来实现的，但是由于要更改策略，不得不重新
	 */
	private void initParentView() {
		mDrawer = (DrawerLayout) findViewById(R.id.id_drawerLayout);
		mLayout = (RelativeLayout) findViewById(R.id.rl_layout);
		mTitlell = (LinearLayout) mLayout.findViewById(R.id.ll_Title);
		mContentll = (FrameLayout) mLayout.findViewById(R.id.ll_content);
		mBottomll = (LinearLayout) mLayout.findViewById(R.id.ll_bottom);
	}

	@Override
	public String setCenterTitle() {
		return "咨询";
	}

	@Override
	public void initIntent() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_main;
	}

	@Override
	public void initView() {
		mZixunLayout = (RelativeLayout) findViewById(R.id.zixun_layout);
		mClassLayout = (RelativeLayout) findViewById(R.id.class_layout);
		mQikanLayout = (RelativeLayout) findViewById(R.id.qikan_layout);
		mQuestionLayout = (RelativeLayout) findViewById(R.id.question_layout);
		mWebLayout = (RelativeLayout) findViewById(R.id.weibo_layout);
	}

	@Override
	public void initData() {
		HttpHelper.setContext(getApplicationContext());
		setTabSelection(mCurrentIndex);
		// 曹立该添加，百度广告，点击 Tab 时第二项时弹出广告
		initBDAD();
	}

	@Override
	public void initListener() {
		mZixunLayout.setOnClickListener(this);
		mClassLayout.setOnClickListener(this);
		mQikanLayout.setOnClickListener(this);
		mQuestionLayout.setOnClickListener(this);
		mWebLayout.setOnClickListener(this);

	}

	/*
	 * 曹立该添加，初始化百度广告
	 */
	private void initBDAD() {
		// 创建广告视图
		// 发布时请使用正确的ApiKey和广告位ID
		// 此处ApiKey和推广位ID均是测试用的
		// 您在正式提交应用的时候，请确认代码中已经更换为您应用对应的Key和ID
		// 具体获取方法请查阅《百度开发者中心交叉换量产品介绍.pdf》
		appxInterstitialAdView = new BDInterstitialAd(this,
				"T8A7nrKyOEkzFzGqA5zeBABq", "6qI0TX8NSv8Enq74iuNRy0X2");

		// 设置插屏广告行为监听器
		appxInterstitialAdView
				.setAdListener(new BDInterstitialAd.InterstitialAdListener() {

					@Override
					public void onAdvertisementDataDidLoadFailure() {
						Log.e(TAG, "load failure");
					}

					@Override
					public void onAdvertisementDataDidLoadSuccess() {
						Log.e(TAG, "load success");
					}

					@Override
					public void onAdvertisementViewDidClick() {
						Log.e(TAG, "on click");
					}

					@Override
					public void onAdvertisementViewDidHide() {
						Log.e(TAG, "on hide");
					}

					@Override
					public void onAdvertisementViewDidShow() {
						Log.e(TAG, "on show");
					}

					@Override
					public void onAdvertisementViewWillStartNewIntent() {
						Log.e(TAG, "leave");
					}

				});

		// 加载广告
		appxInterstitialAdView.loadAd();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		if (item.getItemId() == R.id.action_settings) {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			final Activity obj = this;
			builder.setMessage("确定要注销此帐户吗?");
			builder.setTitle("提示");
			builder.setPositiveButton("确认",
					new android.content.DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
							Thinksns app = (Thinksns) obj
									.getApplicationContext();
							app.getUserSql().clear();
							// Thinksns.exitApp();
							Intent intent = new Intent(HomeActivity.this,
									GuideActivity.class);
							intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK
									| Intent.FLAG_ACTIVITY_NEW_TASK);
							HomeActivity.this.startActivity(intent);
							Anim.in(HomeActivity.this);
							finish();
						}
					});
			builder.setNegativeButton("取消",
					new android.content.DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
						}
					});
			builder.create().show();
		}
		return true;
	}

	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.zixun_layout:
			setTabSelection(index_zhixun);
			break;
		case R.id.class_layout:
			setTabSelection(index_qclass);
			// 展示插屏广告前先请先检查下广告是否加载完毕
			// if (appxInterstitialAdView.isLoaded()) {
			// appxInterstitialAdView.showAd();
			// } else {
			// Log.i(TAG, "AppX Interstitial Ad is not ready");
			// appxInterstitialAdView.loadAd();
			// }
			// startActivity(new Intent(HomeActivity.this, BDActivity.class));
			break;
		case R.id.question_layout:
			setTabSelection(index_qustion);
			break;
		case R.id.qikan_layout:
			setTabSelection(index_qikan);
			break;
		case R.id.weibo_layout:
			setTabSelection(index_web);
			// Intent intent = new Intent(this, WeiboAppActivity.class);
			// startActivity(intent);
			// Anim.in(activity);
			break;
		}
	}

	private void setTabSelection(int index) {

		// 开启一个Fragment事务
		FragmentTransaction transaction = mFManager.beginTransaction();
		// 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
		hideFragments(transaction);
		switch (index) {
		case index_Default:
			if (mDefaultFragment == null) {
				mDefaultFragment = new FragmentIndex();
				transaction.add(R.id.content, mDefaultFragment);
			} else {
				transaction.show(mDefaultFragment);
			}
			break;
		case index_zhixun:
			if (mZiXunFgmt == null) {
				// 如果MessageFragment为空，则创建一个并添加到界面上
				mZiXunFgmt = new ZiXunFragment();
				transaction.add(R.id.content, mZiXunFgmt);
			} else {
				// 如果MessageFragment不为空，则直接将它显示出来
				transaction.show(mZiXunFgmt);
			}
			// mZixunLayout.setBackgroundResource(R.drawable.foot_pressed);
			break;
		case index_qclass:
			if (mQClassFgmt == null) {
				mQClassFgmt = new QClassFragment();
				transaction.add(R.id.content, mQClassFgmt);
			} else {
				transaction.show(mQClassFgmt);
			}
			// mClassLayout.setBackgroundResource(R.drawable.foot_pressed);
			break;
		case index_qustion:
			if (mQustionFgmt == null) {
				mQustionFgmt = new QuestionFragment();
				transaction.add(R.id.content, mQustionFgmt);
			} else {
				transaction.show(mQustionFgmt);
			}
			// mQuestionLayout.setBackgroundResource(R.drawable.foot_pressed);
			break;
		case index_qikan:
			if (mQiKanFgmt == null) {
				mQiKanFgmt = new QiKanFragment();
				transaction.add(R.id.content, mQiKanFgmt);
			} else {
				transaction.show(mQiKanFgmt);
			}
			// mQikanLayout.setBackgroundResource(R.drawable.foot_pressed);
			break;
		case index_web:
			if (mWebFgmt == null) {
				mWebFgmt = new WebFragment();
				transaction.add(R.id.content, mWebFgmt);
			} else {
				transaction.show(mWebFgmt);
			}
			// mWebLayout.setBackgroundResource(R.drawable.foot_pressed);
			break;
		}
		transaction.commit();
	}

	private void hideFragments(FragmentTransaction transaction) {
		if (mZiXunFgmt != null) {
			transaction.hide(mZiXunFgmt);
		}
		if (mQClassFgmt != null) {
			transaction.hide(mQClassFgmt);
		}
		if (mQustionFgmt != null) {
			transaction.hide(mQustionFgmt);
		}
		if (mQiKanFgmt != null) {
			transaction.hide(mQiKanFgmt);
		}
		if (mWebFgmt != null)
			transaction.hide(mWebFgmt);
	}

	@Override
	protected void onResume() {
		super.onResume();
		MobclickAgent.onResume(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		MobclickAgent.onPause(this);
	}

}

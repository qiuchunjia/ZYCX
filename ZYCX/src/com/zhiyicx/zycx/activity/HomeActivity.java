package com.zhiyicx.zycx.activity;

import com.baidu.appx.BDInterstitialAd;
import com.nineoldandroids.view.ViewHelper;
import com.umeng.analytics.MobclickAgent;
import com.zhiyicx.zycx.LoginActivity;
import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.sociax.android.Thinksns;
import com.zhiyicx.zycx.sociax.net.HttpHelper;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import qcjlibrary.activity.MsgNotifyPraiseActivity;
import qcjlibrary.activity.RequestWayActivity;
import qcjlibrary.activity.SearchNewActivity;
import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.activity.base.Title;
import qcjlibrary.fragment.FragmentCaseIndex;
import qcjlibrary.fragment.FragmentExperience;
import qcjlibrary.fragment.FragmentIndex;
import qcjlibrary.fragment.FragmentMenu;
import qcjlibrary.fragment.FragmentQclassIndex;
import qcjlibrary.fragment.FragmentRequestAnwer;
import qcjlibrary.fragment.FragmentRequestAnwerIndex;
import qcjlibrary.fragment.FragmentZhixun;
import qcjlibrary.model.ModelNotiyState;
import qcjlibrary.model.ModelSearchIndex;
import qcjlibrary.model.ModelUser;
import qcjlibrary.model.base.Model;
import qcjlibrary.util.Anim;
import qcjlibrary.util.ToastUtils;
import qcjlibrary.util.Tools_FontManager;

public class HomeActivity extends BaseActivity {
	// private ZiXunFragment mZiXunFgmt; // 咨询fragment qcj
	private FragmentZhixun mZiXunFgmt; // 咨询fragment qcj
	// private QClassFragment mQClassFgmt; // 轻课堂fragment qcj
	private FragmentQclassIndex mQClassFgmt;// 轻课堂fragment tan
	// private QuestionFragment mQustionFgmt;// 问答fragment qcj
	// private QiKanFragment mQiKanFgmt;// 期刊fragment qcj
	// private WebFragment mWebFgmt;// 微博fragment 这里主要是用的ts3.0来实现的 qcj
	private FragmentCaseIndex mCaseFgmt;
	private FragmentExperience mExpegmt;
	private FragmentRequestAnwerIndex mAnwergmt;
	private FragmentIndex mDefaultFragment; // 新增加的页面
	public static final int index_Default = -1;
	public static final int index_zhixun = 0;
	public static final int index_qclass = 1;
	public static final int index_qustion = 2;
	public static final int index_qikan = 3;
	public static final int index_web = 4;
	private int mCurrentIndex = index_Default; // 当前所处的位置 默认为-1

	private RelativeLayout mZixunLayout, mClassLayout, mQuestionLayout, mQikanLayout, mWebLayout;
	private ImageView index_message, IB_home_bottom_class, IB_home_bottom_question, IB_home_bottom_qikan,
			IB_home_bottom_web;

	private BDInterstitialAd appxInterstitialAdView;
	private String TAG = "HomeActivity";
	private DrawerLayout mDrawer;
	private FragmentMenu mMenu;
	private LinearLayout ll_all_tab;

	private Title mTitle; // 标题
	/** 轻课堂界面排序方法下标 **/
	private int QIndex;
	private PopupWindow mSortMenu;
	/** 轻课堂排序改变监听器 **/
	private onStatusChangedListener mStatusListener;

	@Override
	public void initSet() {
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);// 竖屏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		mApp = (Thinksns) getApplication();
		mApp.setActivity(this);
		mInflater = LayoutInflater.from(getApplicationContext());
		setContentView(R.layout.comom_layout_drawer);
		initParentView();
		// 把内容和title结合
		combineTheLayout();
		initEvents();
		initIntent();
		initView();
		initData();
		initListener();
	}

	private void initEvents() {
		mTitle = getTitleClass();
		if (mTitle != null) {
			mTitle.rl_left_1.setVisibility(View.GONE);
			mTitle.rl_left_2.setVisibility(View.VISIBLE);
		}
		titleSlideMenu(mDrawer);
		mDrawer.setScrimColor(Color.TRANSPARENT); // 去掉滑动的时候阴影
		mDrawer.setDrawerListener(new DrawerListener() {
			@Override
			public void onDrawerStateChanged(int newState) {
			}

			@Override
			public void onDrawerSlide(View drawerView, float slideOffset) {
				View mContent = mDrawer.getChildAt(0);
				View mMenu = drawerView;
				Log.i("slideOffset", "slideOffset=" + slideOffset);
				float scale = 1 - slideOffset;
				Log.i("scale", "scale=" + scale);
				float rightScale = 0.8f + scale * 0.2f;
				Log.i("rightScale", "rightScale=" + rightScale);

				if (drawerView.getTag().equals("LEFT")) {
					float leftScale = 1 - 0.3f * scale;
					ViewHelper.setScaleX(mMenu, leftScale);
					ViewHelper.setScaleY(mMenu, leftScale);
					ViewHelper.setAlpha(mMenu, 0.6f + 0.4f * (1 - scale));
					ViewHelper.setTranslationX(mContent, mMenu.getMeasuredWidth() * (1 - scale));
					ViewHelper.setPivotX(mContent, 0);
					ViewHelper.setPivotY(mContent, mContent.getMeasuredHeight() / 2);
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
		// 从Intent中获取当前选中的Fragment
		try {
			mCurrentIndex = (Integer) getDataFromIntent(getIntent(), null);
		} catch (Exception e) {
			mCurrentIndex = -1;
		}

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

		index_message = (ImageView) findViewById(R.id.index_message);
		IB_home_bottom_class = (ImageView) findViewById(R.id.IB_home_bottom_class);
		IB_home_bottom_question = (ImageView) findViewById(R.id.IB_home_bottom_question);
		IB_home_bottom_qikan = (ImageView) findViewById(R.id.IB_home_bottom_qikan);
		IB_home_bottom_web = (ImageView) findViewById(R.id.IB_home_bottom_web);
		ll_all_tab = (LinearLayout) findViewById(R.id.ll_all_tab);
	}

	@Override
	public void initData() {
		HttpHelper.setContext(getApplicationContext());
		setTabSelection(mCurrentIndex);
		// 曹立该添加，百度广告，点击 Tab 时第二项时弹出广告
		initBDAD();
		Thinksns.homeAct = this;
	}

	/**
	 * 初始化title
	 * 
	 * @param mTitle2
	 */
	private void initIcon(Title mTitle2) {
		if (mTitle2 != null) {
			if (isLogin()) {
				ModelUser user = mApp.getUser();
				String iconUrl = user.getAvatar();
				if (!TextUtils.isEmpty(iconUrl)) {
					//mApp.displayImage(iconUrl, mTitle2.iv_title_left2);
					sendRequest(mApp.getUserImpl().index(), ModelUser.class, REQUEST_GET);
				} else {
					sendRequest(mApp.getUserImpl().index(), ModelUser.class, REQUEST_GET);
				}
			}
		}
	}

	private String status;
	private ImageView iv_home_msg;
	@Override
	public Object onResponceSuccess(String str, Class class1) {
		Object object = super.onResponceSuccess(str, class1);
		if (object instanceof ModelUser) {
			ModelUser obUser = (ModelUser) object;
			mApp.displayImage(obUser.getAvatar(), mTitle.iv_title_left2);
			mApp.saveUser(obUser);
		} else if(object instanceof ModelNotiyState){
				ModelNotiyState state = (ModelNotiyState) object;
				status = state.getStatus();
				if(mCurrentIndex == index_Default){
					if(status != null && status.equals("1")){
						mTitle.iv_home_msg.setVisibility(View.VISIBLE);
					} else{
						mTitle.iv_home_msg.setVisibility(View.GONE);
					}
				} else{
					mTitle.iv_home_msg.setVisibility(View.GONE);
				}
		}else{
			judgeTheMsg(object);
		}
		return object;
	}

	@Override
	public void initListener() {
		mZixunLayout.setOnClickListener(this);
		mClassLayout.setOnClickListener(this);
		mQikanLayout.setOnClickListener(this);
		mQuestionLayout.setOnClickListener(this);
		mWebLayout.setOnClickListener(this);
		ll_all_tab.setOnClickListener(this);  //事件拦截，防止点击空白区域跳到咨询详情或者卿课堂详情，反正是醉了

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
		appxInterstitialAdView = new BDInterstitialAd(this, "T8A7nrKyOEkzFzGqA5zeBABq", "6qI0TX8NSv8Enq74iuNRy0X2");

		// 设置插屏广告行为监听器
		appxInterstitialAdView.setAdListener(new BDInterstitialAd.InterstitialAdListener() {

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
		return true;
	}
	

	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.zixun_layout:
			setTabSelection(index_zhixun);
			index_message.setImageResource(R.drawable.zixun_press);
			break;
		case R.id.class_layout:
			setTabSelection(index_qclass);
			IB_home_bottom_class.setImageResource(R.drawable.qingketang_press);
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
			IB_home_bottom_qikan.setImageResource(R.drawable.jingli_press);
			break;
		case R.id.weibo_layout:
			if (isLogin()) {
				setTabSelection(index_web);
				IB_home_bottom_web.setImageResource(R.drawable.bingli_press);
			} else {
				mApp.startActivity_qcj(this, LoginActivity.class, null);
			}

			// Intent intent = new Intent(this, WeiboAppActivity.class);
			// startActivity(intent);
			// Anim.in(activity);
			break;
		}
	}
	
	public void setTabImg(int index){
		switch (index) {
		case index_qikan:
			IB_home_bottom_qikan.setImageResource(R.drawable.jingli_press);
			break;
		case index_qclass:
			IB_home_bottom_class.setImageResource(R.drawable.qingketang_press);
			break;
		case index_web:
			IB_home_bottom_web.setImageResource(R.drawable.bingli_press);

		default:
			break;
		}
	}

	public void setTabSelection(int index) {

		// 开启一个Fragment事务
		FragmentTransaction transaction = mFManager.beginTransaction();
		// 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
		//hideFragments(transaction);
		setChangeTitle(index);
		resetBottomImage();
		switch (index) {
		case index_Default:
			if (mDefaultFragment == null) {
				mDefaultFragment = new FragmentIndex();
				//transaction.add(R.id.content, mDefaultFragment);
			} else {
				//transaction.show(mDefaultFragment);
			}
			transaction.replace(R.id.content, mDefaultFragment);
			break;
		case index_zhixun:
			if (mZiXunFgmt == null) {
				// 如果MessageFragment为空，则创建一个并添加到界面上
				mZiXunFgmt = new FragmentZhixun();
				//transaction.add(R.id.content, mZiXunFgmt);
			} else {
				mZiXunFgmt = new FragmentZhixun();
				// 如果MessageFragment不为空，则直接将它显示出来
				//transaction.show(mZiXunFgmt);
			}
			mTitle.iv_home_msg.setVisibility(View.GONE);
			transaction.replace(R.id.content, mZiXunFgmt);
			// mZixunLayout.setBackgroundResource(R.drawable.foot_pressed);
			break;
		case index_qclass:
			if (mQClassFgmt == null) {
				mQClassFgmt = new FragmentQclassIndex();
				//transaction.add(R.id.content, mQClassFgmt);
			} else {
				mQClassFgmt = new FragmentQclassIndex();
				//transaction.show(mQClassFgmt);
			}
			mTitle.iv_home_msg.setVisibility(View.GONE);
			transaction.replace(R.id.content, mQClassFgmt);
			/*
			 * if (mQClassFgmt == null) { mQClassFgmt = new QClassFragment();
			 * transaction.add(R.id.content, mQClassFgmt); } else {
			 * transaction.show(mQClassFgmt); }
			 */
			// mClassLayout.setBackgroundResource(R.drawable.foot_pressed);
			break;
		case index_qustion:
			if (mAnwergmt == null) {
				mAnwergmt = new FragmentRequestAnwerIndex();
				//transaction.add(R.id.content, mAnwergmt);
			} else {
				//transaction.show(mAnwergmt);
			}
			mTitle.iv_home_msg.setVisibility(View.GONE);
			transaction.replace(R.id.content, mAnwergmt);
			// if (mQustionFgmt == null) {
			// mQustionFgmt = new QuestionFragment();
			// transaction.add(R.id.content, mQustionFgmt);
			// } else {
			// transaction.show(mQustionFgmt);
			// }
			// mQuestionLayout.setBackgroundResource(R.drawable.foot_pressed);
			break;
		case index_qikan:
			if (mExpegmt == null) {
				mExpegmt = new FragmentExperience();
				//transaction.add(R.id.content, mExpegmt);
			} else {
				//transaction.show(mExpegmt);
			}
			mTitle.iv_home_msg.setVisibility(View.GONE);
			transaction.replace(R.id.content, mExpegmt);
			// if (mQiKanFgmt == null) {
			// mQiKanFgmt = new QiKanFragment();
			// transaction.add(R.id.content, mQiKanFgmt);
			// } else {
			// transaction.show(mQiKanFgmt);
			// }
			// mQikanLayout.setBackgroundResource(R.drawable.foot_pressed);
			break;
		case index_web:
			if (mCaseFgmt == null) {
				mCaseFgmt = new FragmentCaseIndex();
				//transaction.add(R.id.content, mCaseFgmt);
			} else {
				//transaction.show(mCaseFgmt);
			}
			mTitle.iv_home_msg.setVisibility(View.GONE);
			transaction.replace(R.id.content, mCaseFgmt);
			// if (mWebFgmt == null) {
			// mWebFgmt = new WebFragment();
			// transaction.add(R.id.content, mWebFgmt);
			// } else {
			// transaction.show(mWebFgmt);
			// }
			// mWebLayout.setBackgroundResource(R.drawable.foot_pressed);
			break;
		}
		mCurrentIndex = index;
		transaction.commit();
	}

	/**
	 * 根据点击的fragment，设置可变的title，以及title右边需要实现的功能
	 * 
	 * @param index
	 */

	private void setChangeTitle(int index) {
		mTitle.iv_title_right1.setVisibility(View.GONE);
		switch (index) {
		case index_Default:
			titleSetCenterTitle("癌友帮");
			mTitle.rl_textandpic.setVisibility(View.GONE);
			mTitle.iv_title_right1.setVisibility(View.VISIBLE);
			mTitle.iv_title_right1.setImageResource(R.drawable.index);
			mTitle.iv_title_right1.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					if (isLogin()) {
						mApp.startActivity_qcj(HomeActivity.this, MsgNotifyPraiseActivity.class,
								sendDataToBundle(new Model(), null));
					} else {
						mApp.startActivity_qcj(HomeActivity.this, LoginActivity.class, null);
					}
				}
			});
			break;
		case index_zhixun:
			titleSetCenterTitle("资讯");
			mTitle.rl_textandpic.setVisibility(View.GONE);
			mTitle.iv_title_right1.setVisibility(View.VISIBLE);
			mTitle.iv_title_right1.setImageResource(R.drawable.searchwhite);
			mTitle.iv_title_right1.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					ModelSearchIndex mData = new ModelSearchIndex();
					mData.setIndex(2);
					mApp.startActivity_qcj(HomeActivity.this, SearchNewActivity.class,
							sendDataToBundle(mData, "index"));
				}
			});
			break;
		case index_qclass:
			titleSetCenterTitle(" ");
			// mTitle.tv_title.setVisibility(View.GONE);
			mTitle.rl_textandpic.setVisibility(View.VISIBLE);
			mTitle.iv_title_right1.setVisibility(View.VISIBLE);
			mTitle.iv_title_right1.setImageResource(R.drawable.searchwhite);
			mTitle.iv_title_right1.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					ModelSearchIndex mData = new ModelSearchIndex();
					mData.setIndex(3);
					mApp.startActivity_qcj(HomeActivity.this, SearchNewActivity.class,
							sendDataToBundle(mData, "index"));
				}
			});
			/**
			 * 点击弹出下拉PopWindow
			 */
			mTitle.rl_textandpic.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					showMenu(v);
				}
			});
			break;
		case index_qustion:
			titleSetCenterTitle("问答");
			mTitle.rl_textandpic.setVisibility(View.GONE);
			mTitle.iv_title_right1.setVisibility(View.VISIBLE);
			mTitle.iv_title_right1.setImageResource(R.drawable.searchwhite);
			mTitle.iv_title_right1.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					ModelSearchIndex mData = new ModelSearchIndex();
					mData.setIndex(1);
					mApp.startActivity_qcj(HomeActivity.this, SearchNewActivity.class,
							sendDataToBundle(mData, "index"));
				}
			});
			break;
		case index_qikan:
			titleSetCenterTitle("经历");
			mTitle.rl_textandpic.setVisibility(View.GONE);
			break;
		case index_web:
			titleSetCenterTitle("病历");
			mTitle.rl_textandpic.setVisibility(View.GONE);
			mTitle.iv_title_right1.setVisibility(View.VISIBLE);
			mTitle.iv_title_right1.setImageResource(R.drawable.searchwhite);
			mTitle.iv_title_right1.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					ModelSearchIndex mData = new ModelSearchIndex();
					mData.setIndex(0);
					mApp.startActivity_qcj(HomeActivity.this, SearchNewActivity.class,
							sendDataToBundle(mData, "index"));
				}
			});
			break;
		}
	}

	/**
	 * 重置底部image
	 */
	private void resetBottomImage() {
		index_message.setImageResource(R.drawable.zixun);
		IB_home_bottom_class.setImageResource(R.drawable.qingketang);
		IB_home_bottom_qikan.setImageResource(R.drawable.jingli);
		IB_home_bottom_web.setImageResource(R.drawable.bingli);
	}

	private void hideFragments(FragmentTransaction transaction) {
		if (mZiXunFgmt != null) {
			transaction.hide(mZiXunFgmt);
		}
		if (mQClassFgmt != null) {
			transaction.hide(mQClassFgmt);
		}
		if (mAnwergmt != null) {
			transaction.hide(mAnwergmt);
		}
		// if (mQustionFgmt != null) {
		// transaction.hide(mQustionFgmt);
		// }
		if (mExpegmt != null) {
			transaction.hide(mExpegmt);
		}
		// if (mQiKanFgmt != null) {
		// transaction.hide(mQiKanFgmt);
		// }
		if (mCaseFgmt != null)
			transaction.hide(mCaseFgmt);
		// if (mWebFgmt != null)
		// transaction.hide(mWebFgmt);
	}

	@Override
	protected void onResume() {
		super.onResume();
		MobclickAgent.onResume(this);
		initIcon(mTitle);
		if(isLogin()){
			sendRequest(mApp.getUserImpl().index(), ModelUser.class, REQUEST_GET);
			if(mCurrentIndex == index_Default){
				//首页时获取消息提醒
				sendRequest(mApp.getNotifyImpl().isRead(), ModelNotiyState.class, REQUEST_GET);
			}
		}
		if (!isLogin() && mCurrentIndex == index_qikan) {
			setTabSelection(index_Default);
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		MobclickAgent.onPause(this);
	}

	// 展示排序下拉列表
	private void showMenu(View v) {
		TextView textNew;
		TextView textHot;
		TextView textMy = null;
		if (mSortMenu == null) {
			View menuView = LayoutInflater.from(HomeActivity.this).inflate(R.layout.popmenu, null);
			textNew = (TextView) menuView.findViewById(R.id.txt_new);
			textHot = (TextView) menuView.findViewById(R.id.txt_hot);
			textMy = (TextView) menuView.findViewById(R.id.txt_my);
			mSortMenu = new PopupWindow(menuView, ViewGroup.LayoutParams.WRAP_CONTENT,
					ViewGroup.LayoutParams.WRAP_CONTENT);
			textNew.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					QIndex = 0;
					mTitle.txt_status_1.setText("最新");
					if (mStatusListener != null) {
						mStatusListener.onStatusChange(QIndex);
					}
					mSortMenu.dismiss();
				}
			});
			textHot.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					QIndex = 1;
					mTitle.txt_status_1.setText("最热");
					if (mStatusListener != null) {
						mStatusListener.onStatusChange(QIndex);
					}
					mSortMenu.dismiss();
				}
			});
			textMy.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					QIndex = 2;
					mTitle.txt_status_1.setText("我的");
					if (mStatusListener != null) {
						mStatusListener.onStatusChange(QIndex);
					}
					mSortMenu.dismiss();
				}
			});
		}
		if (isLogin() && textMy != null) {
			textMy.setVisibility(View.VISIBLE);
		} else if (!isLogin() && textMy != null) {
			textMy.setVisibility(View.GONE);
		}
		WindowManager.LayoutParams params = this.getWindow().getAttributes();
		params.alpha = 0.7f;
		this.getWindow().setAttributes(params);
		mSortMenu.setAnimationStyle(R.style.popwin_anim_style);
		mSortMenu.setFocusable(true);
		mSortMenu.setOutsideTouchable(true);
		mSortMenu.update();
		mSortMenu.setBackgroundDrawable(new BitmapDrawable());
		// 设置弹出框的位置
		int xPos = (-v.getWidth() / 4);
		mSortMenu.showAsDropDown(v, xPos, 0);
		mTitle.arrow_img_1.setImageResource(R.drawable.moreicon);
		mSortMenu.setOnDismissListener(new PopupWindow.OnDismissListener() {
			@Override
			public void onDismiss() {
				WindowManager.LayoutParams params = HomeActivity.this.getWindow().getAttributes();
				params.alpha = 1.0f;
				HomeActivity.this.getWindow().setAttributes(params);
			}
		});
	}

	public interface onStatusChangedListener {
		void onStatusChange(int status);
	}

	public void setOnStatusChangedListener(onStatusChangedListener mStatusListener) {
		this.mStatusListener = mStatusListener;
	}

	private void setFonts(int index) {
		Tools_FontManager.changeFonts(mTitle.ll_center, this, index);
		mTitle.tv_title.setTextColor(Color.WHITE);
	}
	
	/** 标记点击BACK键的时间**/
	private long preTabTime;
	public static int qcl = 1;
	public static int exp = 2;
	public static int cas = 3;
	public int isExit = 0;
	

	@Override
	public void onBackPressed() {
		// TODO 自动生成的方法存根
		//判断是否首页切换,首页推荐跳转则BACK返回首页
		if(isExit == qcl){
			setTabSelection(index_Default);
			isExit= 0;
		} else if(isExit == exp){
			setTabSelection(index_Default);
			isExit= 0;
		} else if(isExit == cas){
			setTabSelection(index_Default);
			isExit= 0;
		} else{
			//连续点击两次退出
			if (System.currentTimeMillis() - preTabTime > 2000) {
				// 提示再次点击退出
				Toast.makeText(this, "再按一次返回键退出应用", Toast.LENGTH_SHORT).show();
				// 标记这次点击的事件
				preTabTime = System.currentTimeMillis();
			} else {
				// 2s内点击两次，关闭app
				finish();
			}
		}
	}
	
	
}

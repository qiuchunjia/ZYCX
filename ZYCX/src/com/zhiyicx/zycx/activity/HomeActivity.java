package com.zhiyicx.zycx.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RelativeLayout;

import com.baidu.appx.BDInterstitialAd;
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

public class HomeActivity extends FragmentActivity implements OnClickListener
{
	private FragmentManager fragmentManager;
    private ZiXunFragment mZiXunFgmt;  //咨询fragment qcj
    private QClassFragment mQClassFgmt; // 轻课堂fragment qcj
    private QuestionFragment mQustionFgmt;// 问答fragment qcj
    private QiKanFragment mQiKanFgmt;// 期刊fragment  qcj
    private WebFragment mWebFgmt;// 微博fragment  这里主要是用的ts3.0来实现的 qcj

    private RelativeLayout mZixunLayout, mClassLayout, mQuestionLayout, mQikanLayout, mWebLayout;

    private BDInterstitialAd appxInterstitialAdView;
    private String TAG = "HomeActivity";

    protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		fragmentManager = getSupportFragmentManager();
		HttpHelper.setContext(getApplicationContext());
		initView();
        setTabSelection(0);
        // 曹立该添加，百度广告，点击 Tab 时第二项时弹出广告
        initBDAD();
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
        if(item.getItemId() == R.id.action_settings)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            final Activity obj = this;
            builder.setMessage("确定要注销此帐户吗?");
            builder.setTitle("提示");
            builder.setPositiveButton("确认",
                    new android.content.DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Thinksns app = (Thinksns) obj.getApplicationContext();
                            app.getUserSql().clear();
                            //Thinksns.exitApp();
                            Intent intent = new Intent(HomeActivity.this, GuideActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            HomeActivity.this.startActivity(intent);
                            Anim.in(HomeActivity.this);
                            finish();
                        }
                    });
            builder.setNegativeButton("取消",
                    new android.content.DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog,int which) {
                            dialog.dismiss();
                        }
                    });
            builder.create().show();
        }
        return true;
    }

    private void initView()
	{
		mZixunLayout = (RelativeLayout)findViewById(R.id.zixun_layout);
        mClassLayout = (RelativeLayout)findViewById(R.id.class_layout);
        mQikanLayout = (RelativeLayout)findViewById(R.id.qikan_layout);
        mQuestionLayout = (RelativeLayout)findViewById(R.id.question_layout);
        mWebLayout = (RelativeLayout)findViewById(R.id.weibo_layout);
        mZixunLayout.setOnClickListener(this);
        mClassLayout.setOnClickListener(this);
        mQikanLayout.setOnClickListener(this);
        mQuestionLayout.setOnClickListener(this);
        mWebLayout.setOnClickListener(this);
	}

	public void onClick(View v)
	{
		switch (v.getId())
		{
		case R.id.zixun_layout:
            setTabSelection(0);
            break;
		case R.id.class_layout:
            setTabSelection(1);
            // 展示插屏广告前先请先检查下广告是否加载完毕
//            if (appxInterstitialAdView.isLoaded()) {
//                appxInterstitialAdView.showAd();
//            } else {
//                Log.i(TAG, "AppX Interstitial Ad is not ready");
//                appxInterstitialAdView.loadAd();
//            }
//            startActivity(new Intent(HomeActivity.this, BDActivity.class));
			break;
		case R.id.question_layout:
            setTabSelection(2);
            break;
		case R.id.qikan_layout:
            setTabSelection(3);
            break;
		case R.id.weibo_layout:
            setTabSelection(4);
            //Intent intent = new Intent(this, WeiboAppActivity.class);
            //startActivity(intent);
            //Anim.in(activity);
			break;
		}
	}

    private void setTabSelection(int index)
    {

        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
//        mZixunLayout.setBackgroundResource(android.R.color.transparent);
//        mClassLayout.setBackgroundResource(android.R.color.transparent);
//        mQuestionLayout.setBackgroundResource(android.R.color.transparent);
//        mQikanLayout.setBackgroundResource(android.R.color.transparent);
//        mWebLayout.setBackgroundResource(android.R.color.transparent);
        switch (index)
        {
            case 0:
                if (mZiXunFgmt == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    mZiXunFgmt = new ZiXunFragment();
                    transaction.add(R.id.content, mZiXunFgmt);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(mZiXunFgmt);
                }
//                mZixunLayout.setBackgroundResource(R.drawable.foot_pressed);
                break;
            case 1:
                if (mQClassFgmt == null) {
                    mQClassFgmt = new QClassFragment();
                    transaction.add(R.id.content, mQClassFgmt);
                } else {
                    transaction.show(mQClassFgmt);
                }
//                mClassLayout.setBackgroundResource(R.drawable.foot_pressed);
                break;
            case 2:
                if (mQustionFgmt == null) {
                    mQustionFgmt = new QuestionFragment();
                    transaction.add(R.id.content, mQustionFgmt);
                } else {
                    transaction.show(mQustionFgmt);
                }
//                mQuestionLayout.setBackgroundResource(R.drawable.foot_pressed);
                break;
            case 3:
                if (mQiKanFgmt == null) {
                    mQiKanFgmt = new QiKanFragment();
                    transaction.add(R.id.content, mQiKanFgmt);
                } else {
                    transaction.show(mQiKanFgmt);
                }
//                mQikanLayout.setBackgroundResource(R.drawable.foot_pressed);
                break;
            case 4:
                if (mWebFgmt == null) {
                    mWebFgmt = new WebFragment();
                    transaction.add(R.id.content, mWebFgmt);
                } else {
                    transaction.show(mWebFgmt);
                }
//                mWebLayout.setBackgroundResource(R.drawable.foot_pressed);
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

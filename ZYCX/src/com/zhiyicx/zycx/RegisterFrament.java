package com.zhiyicx.zycx;

import java.util.ArrayList;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhiyicx.zycx.adapter.MyFragmentPagerAdapter;

/**
 * 注册类
 *
 * @author Mr . H
 *
 */
public class RegisterFrament extends FragmentActivity
{
    // 顶部手机注册，邮箱注册按钮
    private TextView mTvBtnRegisterPhone, mTvBtnRegisterMail;
    private MyViewPager mPager;
    private ArrayList<Fragment> fragmentList;

    private ImageView iv_register_title_back;
    private RelativeLayout rlPhone;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.register_layout);
        InitImageView();
        // InitImage();
        InitViewPager();
        iv_register_title_back.setOnClickListener(new OnClickListener()
        {

            public void onClick(View v)
            {
                // finish掉当前窗口
                finish();
            }
        });
    }

    /*
     * 初始化标签名
     */
    public void InitImageView()
    {
        mTvBtnRegisterPhone = (TextView) findViewById(R.id.ivbtn_register_phone);
        mTvBtnRegisterMail = (TextView) findViewById(R.id.ivbtn_register_email);
        iv_register_title_back = (ImageView) findViewById(R.id.register_title_back);
        mTvBtnRegisterPhone.setOnClickListener(new ivListener(0));
        mTvBtnRegisterMail.setOnClickListener(new ivListener(1));
    }

    public class ivListener implements View.OnClickListener
    {
        public int index = 0;

        public ivListener(int i)
        {
            index = i;
        }

        public void onClick(View v)
        {
            mPager.setCurrentItem(index);
            if (index == 0)
            {
                mTvBtnRegisterPhone.setBackgroundResource(R.drawable.phone_registered_pressed);
                mTvBtnRegisterMail.setBackgroundResource(android.R.color.transparent);
            } else
            {
                mTvBtnRegisterMail.setBackgroundResource(R.drawable.mail_registered_pressed);
                mTvBtnRegisterPhone.setBackgroundResource(android.R.color.transparent);
            }
        }
    }

    public void InitViewPager()
    {
        Intent intent = getIntent();
        String type_uid = intent.getStringExtra("type_uid");
        String type = intent.getStringExtra("type");
        String token = intent.getStringExtra("access_token");

        mPager = (MyViewPager) this.findViewById(R.id.viewpager);
        fragmentList = new ArrayList<Fragment>();
        Fragment phoneFragment = PhoneFrament.newInstance(type, type_uid, token);
        Fragment mailFragment = MailFrament.newInstance(type, type_uid, token);
        fragmentList.add(phoneFragment);
        fragmentList.add(mailFragment);

        // 给ViewPager设置适配器
        mPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList));
        // 设置当前显示标签页为第一页
        mPager.setCurrentItem(0);
    }
}

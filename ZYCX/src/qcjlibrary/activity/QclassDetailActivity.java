package qcjlibrary.activity;

import com.zhiyicx.zycx.R;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.widget.popupview.PopQclassCmt;

public class QclassDetailActivity extends BaseActivity{

	private ImageView iv_qclass_video;
	private TextView tv_qclass_chapter;
	private TextView tv_qclass_discuss;
	private TextView tv_qclass_detail;
	private ViewPager vp_qclass_detail;
	/** 选择的ViewPager的子项下标**/
	private int index;
	private int mDefId;
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_qclass_chapter:
			index = 0;
			break;
		case R.id.tv_qclass_discuss:
			index = 1;
			break;
		case R.id.tv_qclass_detail:
			index = 2;
			break;
		case R.id.tv_title_right:
			PopQclassCmt mCmdPop = new PopQclassCmt(this, null, this);
			mCmdPop.showPop(tv_qclass_chapter, Gravity.BOTTOM, 0, 0);
			break;
		default:
			break;
		}
		setTab(index);
	}

	@Override
	public String setCenterTitle() {
		// TODO 自动生成的方法存根
		return "课程";
	}

	@Override
	public void initIntent() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_qclass_detail;
	}

	@Override
	public void initView() {
		titleSetRightTitle("评论");
		iv_qclass_video = (ImageView) findViewById(R.id.iv_qclass_video);
		tv_qclass_chapter = (TextView) findViewById(R.id.tv_qclass_chapter);
		tv_qclass_discuss = (TextView) findViewById(R.id.tv_qclass_discuss);
		tv_qclass_detail = (TextView) findViewById(R.id.tv_qclass_detail);
		vp_qclass_detail = (ViewPager) findViewById(R.id.vp_qclass_detail);
	}

	@Override
	public void initData() {
		
	}

	@Override
	public void initListener() {
		iv_qclass_video.setOnClickListener(this);
		tv_qclass_chapter.setOnClickListener(this);
		tv_qclass_discuss.setOnClickListener(this);
		tv_qclass_detail.setOnClickListener(this);
		vp_qclass_detail.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				index = arg0;
				setTab(index);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO 自动生成的方法存根
				
			}
		});
	}

	/**
	 * 根据选中的子项的下标，改变tab栏对于标题颜色
	 * @param int index
	 * 				选择的子项下标
	 * */
	private void setTab(int index) {
		TextView tv = null;
		switch (index) {
		case 0:
			tv = tv_qclass_chapter;
			break;
		case 1:
			tv = tv_qclass_discuss;
			break;
		case 2:
			tv = tv_qclass_detail;
			break;
		default:
			break;
		}
		tv_qclass_chapter.setTextColor(Color.BLACK);
		tv_qclass_discuss.setTextColor(Color.BLACK);
		tv_qclass_detail.setTextColor(Color.BLACK);
		tv.setTextColor(getResources().getColor(R.color.text_green));
	}
	
	@Override
	public Object onPopResult(Object object) {
		// 从PopWindow返回的评论数据
		String content = object.toString();
		
		return super.onPopResult(object);
	}
}

package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.fragment.FragmentInfor;
import qcjlibrary.fragment.FragmentQclass;
import qcjlibrary.fragment.FragmentRequest;
import qcjlibrary.fragment.FragmentSearchFood;
import qcjlibrary.fragment.FragmentWeibo;
import qcjlibrary.util.ToastUtils;
import qcjlibrary.util.UIUtils;
import android.animation.ObjectAnimator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import java.util.ArrayList;
import com.umeng.socialize.utils.Log;
import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午4:07:29 类描述：这个类是实现
 *
 */

public class SearchNewActivity extends BaseActivity {

	private EditText et_search;
	private TextView tv_sure;
	private TextView tv_webo;
	private TextView tv_request;
	private TextView tv_zhixun;
	private TextView tv_qclass;
	private TextView tv_food;
	private TextView tv_line;
	private ViewPager mViewpager;
	private ImageView iv_search;

	private ArrayList<Fragment> mFragList;
	private FragmentWeibo mWeiboFrag;
	private FragmentRequest mRequestFrag;
	private FragmentInfor mInfoFrag;
	private FragmentQclass mQclassFrag;
	private FragmentSearchFood mFoodFrag;
	
	private OnSearchTouchListerer mSearchListener;
	//导航栏宽度
	private int offset;
	/** 导航栏指示位移起始X**/
	private float fromX;
	/** 导航栏指示位移起始Y**/
	private float toX;
	@Override
	public String setCenterTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initIntent() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_search;
	}

	@Override
	public void initView() {
		et_search = (EditText) findViewById(R.id.et_search);
		tv_sure = (TextView) findViewById(R.id.tv_sure);
		tv_webo = (TextView) findViewById(R.id.tv_webo);
		tv_request = (TextView) findViewById(R.id.tv_request);
		tv_zhixun = (TextView) findViewById(R.id.tv_zhixun);
		tv_qclass = (TextView) findViewById(R.id.tv_qclass);
		tv_food = (TextView) findViewById(R.id.tv_food);
		tv_line = (TextView) findViewById(R.id.tv_line);
		mViewpager = (ViewPager) findViewById(R.id.mViewpager);
		iv_search = (ImageView) findViewById(R.id.iv_search);
		offset = UIUtils.getWindowWidth(getApplicationContext()) / 5;
		tv_line.getLayoutParams().width = offset;
	}

	@Override
	public void initData() {
		mApp.searchAct = this;
		mFragList = new ArrayList<Fragment>();
		mWeiboFrag = new FragmentWeibo();
		mRequestFrag = new FragmentRequest();
		mInfoFrag = new FragmentInfor();
		mQclassFrag = new FragmentQclass();
		mFoodFrag = new FragmentSearchFood();
		mFragList.add(mWeiboFrag);
		mFragList.add(mRequestFrag);
		mFragList.add(mInfoFrag);
		mFragList.add(mQclassFrag);
		mFragList.add(mFoodFrag);
		FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
			
			@Override
			public int getCount() {
				return mFragList.size();
			}
			
			@Override
			public Fragment getItem(int position) {
				return mFragList.get(position);
			}
		};
		mViewpager.setAdapter(mAdapter);
	}

	@Override
	public void initListener() {
		tv_sure.setOnClickListener(this);
		tv_webo.setOnClickListener(this);
		tv_request.setOnClickListener(this);
		tv_zhixun.setOnClickListener(this);
		tv_qclass.setOnClickListener(this);
		tv_food.setOnClickListener(this);
		iv_search.setOnClickListener(this);
		// 监听回车按钮,将回车按钮改为搜索按钮
		et_search.setOnEditorActionListener(new OnEditorActionListener() {

			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				Log.d("Cathy", "actionId = "+actionId);
				if (actionId == EditorInfo.IME_ACTION_SEARCH
						|| (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
					Log.d("Cathy", "actionId = "+actionId);
					searchData();
				}
				return true;
			}
		});

		//根据ViewPager改变导航栏指示
		mViewpager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				toX = offset * arg0;
				setLineAnimator(fromX,toX);
				fromX = toX;
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

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_sure:
			
			break;
		case R.id.iv_search:
			// 搜索按钮
			searchData();
			break;
		case R.id.tv_webo:
			mViewpager.setCurrentItem(0);
			toX = 0;
			break;
		case R.id.tv_request:
			mViewpager.setCurrentItem(1);
			toX = offset;
			break;
		case R.id.tv_zhixun:
			mViewpager.setCurrentItem(2);
			toX = offset * 2;
			break;
		case R.id.tv_qclass:
			mViewpager.setCurrentItem(3);
			toX = offset * 3;
			break;
		case R.id.tv_food:
			mViewpager.setCurrentItem(4);
			toX = offset * 4;
			break;
		default:
			break;
		}
		setLineAnimator(fromX,toX);
		fromX = toX;
	}

	private void searchData() {
		String key = et_search.getText().toString();
		if (key != null || !key.equals(" ")) {
			ToastUtils.showToast("搜索中...");
			mSearchListener.onSearchTouch(key,mViewpager.getCurrentItem());
		} else {
			ToastUtils.showLongToast(this, "请输入关键字");
		}
	}

	/**
	 * 点击搜索接口，将关键字传给实现方法的地方
	 * */
	public interface OnSearchTouchListerer{
		void onSearchTouch(String key,int searchType);
	}
	
	public void setOnSearchListener(OnSearchTouchListerer mSearchListener){
		this.mSearchListener = mSearchListener;
	}
	
	/**
	 * 导航栏指示线
	 * @param float fromX
	 * 				起始X位置
	 * @param float toX
	 * 				目标X位置
	 * */
	private void setLineAnimator(float fromX,float toX){
		ObjectAnimator.ofFloat(tv_line, "translationX", fromX, toX).setDuration(500).start();
	}
}

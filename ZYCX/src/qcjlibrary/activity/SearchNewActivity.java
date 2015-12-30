package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.fragment.FragmentInfor;
import qcjlibrary.fragment.FragmentQclass;
import qcjlibrary.fragment.FragmentRequest;
import qcjlibrary.fragment.FragmentSearchFood;
import qcjlibrary.fragment.FragmentWeibo;
<<<<<<< HEAD
=======
import qcjlibrary.util.L;
>>>>>>> 1e6a7cf7b27c2b8f3efadd6d02dc51e1d0fc3714
import qcjlibrary.util.ToastUtils;
import qcjlibrary.util.UIUtils;
import android.animation.ObjectAnimator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
<<<<<<< HEAD
=======
import android.text.Editable;
import android.text.TextWatcher;
>>>>>>> 1e6a7cf7b27c2b8f3efadd6d02dc51e1d0fc3714
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
<<<<<<< HEAD
import java.util.ArrayList;
import com.umeng.socialize.utils.Log;
import com.zhiyicx.zycx.R;
=======
import cn.jpush.android.data.l;

import java.util.ArrayList;
import com.umeng.socialize.utils.Log;
import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.sociax.android.Thinksns;
>>>>>>> 1e6a7cf7b27c2b8f3efadd6d02dc51e1d0fc3714

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
<<<<<<< HEAD
=======
	private ImageView iv_quxiao;
>>>>>>> 1e6a7cf7b27c2b8f3efadd6d02dc51e1d0fc3714

	private ArrayList<Fragment> mFragList;
	private FragmentWeibo mWeiboFrag;
	private FragmentRequest mRequestFrag;
	private FragmentInfor mInfoFrag;
	private FragmentQclass mQclassFrag;
	private FragmentSearchFood mFoodFrag;
<<<<<<< HEAD

	private OnSearchTouchListerer mSearchListener;
	// 导航栏宽度
	private int offset;
	/** 导航栏指示位移起始X **/
	private float fromX;
	/** 导航栏指示位移起始Y **/
	private float toX;

=======
	
	private OnSearchTouchListerer mSearchListener;
	//导航栏宽度
	private int offset;
	/** 导航栏指示位移起始X**/
	private float fromX;
	/** 导航栏指示位移结束X**/
	private float toX;
>>>>>>> 1e6a7cf7b27c2b8f3efadd6d02dc51e1d0fc3714
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
<<<<<<< HEAD
		offset = UIUtils.getWindowWidth(getApplicationContext()) / 5;
		tv_line.getLayoutParams().width = offset;
=======
		iv_quxiao = (ImageView) findViewById(R.id.iv_quxiao);
		offset = UIUtils.getWindowWidth(getApplicationContext()) / 5;
		tv_line.getLayoutParams().width = offset;
		et_search.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
>>>>>>> 1e6a7cf7b27c2b8f3efadd6d02dc51e1d0fc3714
	}

	@Override
	public void initData() {
<<<<<<< HEAD
		mApp.searchAct = this;
=======
		Thinksns.searchAct = this;
>>>>>>> 1e6a7cf7b27c2b8f3efadd6d02dc51e1d0fc3714
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
<<<<<<< HEAD
		FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(
				getSupportFragmentManager()) {

=======
		FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
			
>>>>>>> 1e6a7cf7b27c2b8f3efadd6d02dc51e1d0fc3714
			@Override
			public int getCount() {
				return mFragList.size();
			}
<<<<<<< HEAD

=======
			
>>>>>>> 1e6a7cf7b27c2b8f3efadd6d02dc51e1d0fc3714
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
<<<<<<< HEAD
=======
		iv_quxiao.setOnClickListener(this);
>>>>>>> 1e6a7cf7b27c2b8f3efadd6d02dc51e1d0fc3714
		// 监听回车按钮,将回车按钮改为搜索按钮
		et_search.setOnEditorActionListener(new OnEditorActionListener() {

			@Override
<<<<<<< HEAD
			public boolean onEditorAction(TextView v, int actionId,
					KeyEvent event) {
				Log.d("Cathy", "actionId = " + actionId);
				if (actionId == EditorInfo.IME_ACTION_SEARCH
						|| (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
					Log.d("Cathy", "actionId = " + actionId);
=======
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_SEARCH
						|| (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
>>>>>>> 1e6a7cf7b27c2b8f3efadd6d02dc51e1d0fc3714
					searchData();
				}
				return true;
			}
		});
<<<<<<< HEAD

		// 根据ViewPager改变导航栏指示
=======
		
		//监听输入，如果输入内容不为空，则显示清除按钮
		et_search.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				String key = et_search.getText().toString();
				if(key == null || key.equals("")){
					iv_quxiao.setVisibility(View.GONE);
					tv_sure.setText("取消");
				} else{
					iv_quxiao.setVisibility(View.VISIBLE);
					tv_sure.setText("搜索");
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}
			
			@Override
			public void afterTextChanged(Editable s) {
			}
		});

		//根据ViewPager改变导航栏指示
>>>>>>> 1e6a7cf7b27c2b8f3efadd6d02dc51e1d0fc3714
		mViewpager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				toX = offset * arg0;
<<<<<<< HEAD
				setLineAnimator(fromX, toX);
=======
				setLineAnimator(fromX,toX);
>>>>>>> 1e6a7cf7b27c2b8f3efadd6d02dc51e1d0fc3714
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
<<<<<<< HEAD

=======
			String key = et_search.getText().toString();
			if(key == null || key.equals("")){
				//退出搜索界面
				finish();
			} else{
				//搜素
				searchData();
			}
>>>>>>> 1e6a7cf7b27c2b8f3efadd6d02dc51e1d0fc3714
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
<<<<<<< HEAD
		default:
			break;
		}
		setLineAnimator(fromX, toX);
=======
		case R.id.iv_quxiao:
			et_search.setText("");
			break;
		default:
			break;
		}
		//传入起止位置，开启动画
		setLineAnimator(fromX,toX);
		//将前一个结束位置重置为开始位置
>>>>>>> 1e6a7cf7b27c2b8f3efadd6d02dc51e1d0fc3714
		fromX = toX;
	}

	private void searchData() {
		String key = et_search.getText().toString();
		if (key != null || !key.equals(" ")) {
			ToastUtils.showToast("搜索中...");
<<<<<<< HEAD
			mSearchListener.onSearchTouch(key, mViewpager.getCurrentItem());
=======
			if(mSearchListener != null){
				switch (mViewpager.getCurrentItem()) {
				case 0:
					mSearchListener.onSearchTouch_Weibo(key);
					break;
				case 1:
					mSearchListener.onSearchTouch_Request(key);
					break;
				case 2:
					mSearchListener.onSearchTouch_Info(key);
					break;
				case 3:
					mSearchListener.onSearchTouch_Qclass(key);
					break;
				case 4:
					mSearchListener.onSearchTouch_Food(key);;
					break;

				default:
					break;
				}
			}
>>>>>>> 1e6a7cf7b27c2b8f3efadd6d02dc51e1d0fc3714
		} else {
			ToastUtils.showLongToast(this, "请输入关键字");
		}
	}

	/**
	 * 点击搜索接口，将关键字传给实现方法的地方
	 * */
<<<<<<< HEAD
	public interface OnSearchTouchListerer {
		void onSearchTouch(String key, int searchType);
	}

	public void setOnSearchListener(OnSearchTouchListerer mSearchListener) {
		this.mSearchListener = mSearchListener;
	}

	/**
	 * 导航栏指示线
	 * 
	 * @param float fromX 起始X位置
	 * @param float toX 目标X位置
	 * */
	private void setLineAnimator(float fromX, float toX) {
		ObjectAnimator.ofFloat(tv_line, "translationX", fromX, toX)
				.setDuration(500).start();
=======
	public interface OnSearchTouchListerer{
		//微博搜索
		void onSearchTouch_Weibo(String key);
		//问答搜索
		void onSearchTouch_Request(String key);
		//资讯搜索
		void onSearchTouch_Info(String key);
		//轻课堂搜索
		void onSearchTouch_Qclass(String key);
		//食疗搜索
		void onSearchTouch_Food(String key);
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
>>>>>>> 1e6a7cf7b27c2b8f3efadd6d02dc51e1d0fc3714
	}
}

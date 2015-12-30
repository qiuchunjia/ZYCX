package qcjlibrary.fragment;

import com.zhiyicx.zycx.R;

import android.support.v4.view.ViewPager;
import android.view.View;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.widget.viewpagerindicator.TabPageIndicator;

public class FragmentQclassList extends BaseFragment{

	private TabPageIndicator tabpagerIndicator;
	private ViewPager vPager;
	
	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void initIntentData() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public int getLayoutId() {
		// TODO 自动生成的方法存根
		return R.layout.zixunfragment;
	}

	@Override
	public void initView() {
		tabpagerIndicator = (TabPageIndicator) findViewById(R.id.tabpagerIndicator);
		vPager = (ViewPager) findViewById(R.id.vPager);
		
	}

	@Override
	public void initListener() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void initData() {
		// TODO 自动生成的方法存根
		
	}

}

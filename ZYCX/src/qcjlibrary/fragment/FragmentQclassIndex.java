package qcjlibrary.fragment;

import java.util.ArrayList;
import java.util.List;

import com.viewpagerindicator.TabPageIndicator;
import com.zhiyicx.zycx.R;
import android.support.v4.view.ViewPager;
import android.view.View;
import qcjlibrary.adapter.QclassFragmentAdapter;
import qcjlibrary.api.api;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.model.ModelQclass;
import qcjlibrary.model.ModelQclassCategory;

/**
 * 轻课堂首页
 *
 * @author Tan
 * @since 12.31
 */

public class FragmentQclassIndex extends BaseFragment {
	/** 首页导航栏 **/
	private TabPageIndicator tabpagerIndicator;
	private ViewPager vPager;
	private List<ModelQclassCategory> mCategoryList;

	@Override
	public void initIntentData() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.zixunfragment;
	}

	@Override
	public void initView() {
		tabpagerIndicator = (TabPageIndicator) findViewById(R.id.tabpagerIndicator);
		vPager = (ViewPager) findViewById(R.id.vPager);
	}

	@Override
	public Object onResponceSuccess(String str, Class class1) {
		Object object = super.onResponceSuccess(str, class1);
		if (object instanceof ModelQclass) {
<<<<<<< HEAD
			ModelQclass result = (ModelQclass) object;
=======
			//手动添加分类推荐
			ModelQclass result = (ModelQclass)object;
>>>>>>> 438fd8a9b5bfb6ba6fed63c15dba69cbc621bccb
			ModelQclassCategory recommend = new ModelQclassCategory();
			recommend.setClass_id(0);
			recommend.setImooc_class_name("推荐");
			recommend.setSort(result.getList().size());
			mCategoryList.add(recommend);
			if (result.getCategory() != null) {
				mCategoryList.addAll(result.getCategory());
				QclassFragmentAdapter qAdapter = new QclassFragmentAdapter(
						getChildFragmentManager(), mCategoryList);
				vPager.setAdapter(qAdapter);
				tabpagerIndicator.setViewPager(vPager);
				tabpagerIndicator.setVisibility(View.VISIBLE);
			}
		}
		return object;
	}

	@Override
	public void initListener() {
	}

	@Override
	public void initData() {
		mCategoryList = new ArrayList<ModelQclassCategory>();
<<<<<<< HEAD
=======
		//发送请求
		sendRequest(new api.QclassImpl().index(), ModelQclass.class, 0);
>>>>>>> 438fd8a9b5bfb6ba6fed63c15dba69cbc621bccb
	}

	@Override
	public void onClick(View v) {
	}

}

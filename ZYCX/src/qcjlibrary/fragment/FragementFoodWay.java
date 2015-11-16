package qcjlibrary.fragment;

import qcjlibrary.fragment.base.BaseFragment;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：上午11:30:54 类描述：这个类是实现
 *
 */

public class FragementFoodWay extends BaseFragment {
	private LinearLayout ll_food; // 用于动态添加布局文件
	private RelativeLayout rl_cancer;
	private RelativeLayout rl_cancer_category;

	@Override
	public void initIntentData() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLayoutId() {
		return R.layout.fragment_food_way;
	}

	@Override
	public void initView() {
		ll_food = (LinearLayout) findViewById(R.id.ll_food);
		rl_cancer = (RelativeLayout) findViewById(R.id.rl_cancer);
		rl_cancer_category = (RelativeLayout) findViewById(R.id.rl_cancer_category);

	}

	@Override
	public void initListener() {
		rl_cancer.setOnClickListener(this);
		rl_cancer_category.setOnClickListener(this);
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.rl_cancer:

			break;

		case R.id.rl_cancer_category:

			break;
		}

	}

}

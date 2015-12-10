package qcjlibrary.activity;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.activity.base.Title;
import qcjlibrary.fragment.FragementFood;
import qcjlibrary.fragment.FragementFoodWay;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：上午11:39:34 类描述：这个类是实现
 *
 */

public class FoodWayActivity extends BaseActivity {
	private ImageView iv_find;
	private EditText et_find;
	private RelativeLayout rl_content;
	Title mTitle;

	private FragementFood mFragmentFood;
	private FragementFoodWay mFragmentFoodWay;

	@Override
	public String setCenterTitle() {
		return "食材和食疗方";
	}

	@Override
	public void initIntent() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_food_way;
	}

	@Override
	public void initView() {
		iv_find = (ImageView) findViewById(R.id.iv_find);
		et_find = (EditText) findViewById(R.id.et_find);
		rl_content = (RelativeLayout) findViewById(R.id.rl_content);
		mTitle = getTitleClass();
	}

	@Override
	public void initData() {
		if (mFragmentFood == null) {
			mFragmentFood = new FragementFood();
		}
		replaceFragment(R.id.rl_content, mFragmentFood);
		mTitle.iv_1_choose.setImageResource(R.drawable.segmented_control_02);
		mTitle.tv_title.setVisibility(View.GONE);
		mTitle.iv_1_choose.setVisibility(View.VISIBLE);
	}

	private boolean isSecond = false;

	@Override
	public void initListener() {
		mTitle.rl_1_image.setVisibility(View.VISIBLE);
		mTitle.iv_1_choose.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!isSecond) {
					isSecond = true;
					// Todo 显示第二个fragment；
					if (mFragmentFoodWay == null) {
						mFragmentFoodWay = new FragementFoodWay();
					}
					replaceFragment(R.id.rl_content, mFragmentFoodWay);
					mTitle.iv_1_choose
							.setImageResource(R.drawable.segmented_control);

				} else {
					isSecond = false;
					// Todo 显示第一个fragment；
					if (mFragmentFood == null) {
						mFragmentFood = new FragementFood();
					}
					replaceFragment(R.id.rl_content, mFragmentFood);
					mTitle.iv_1_choose
							.setImageResource(R.drawable.segmented_control_02);
				}
			}
		});

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}

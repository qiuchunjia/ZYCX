package qcjlibrary.fragment;

import java.util.ArrayList;
import java.util.List;

import qcjlibrary.activity.FoodCategoryActivity;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.model.ModelFood;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：上午11:30:54 类描述：这个类是实现
 *
 */

public class FragementFood extends BaseFragment {
	private LinearLayout ll_food; // 用于动态添加布局文件

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
		findViewById(R.id.rl_cancer_category).setVisibility(View.GONE);
		findViewById(R.id.rl_cancer).setVisibility(View.GONE);
	}

	@Override
	public void initListener() {
	}

	@Override
	public void initData() {
		List<ModelFood> foods = new ArrayList<ModelFood>();
		ModelFood food1 = new ModelFood();
		food1.setFoodName("萝卜");
		food1.setFoodNum("14");
		foods.add(food1);
		ModelFood food2 = new ModelFood();
		food2.setFoodName("青菜");
		food2.setFoodNum("15");
		foods.add(food2);
		ModelFood food3 = new ModelFood();
		food3.setFoodName("茶类");
		food3.setFoodNum("13");
		foods.add(food3);
		View view = null;
		for (int i = 0; i < foods.size(); i++) {
			ModelFood food = foods.get(i);
			view = mInflater.inflate(R.layout.item_food_choose, null);
			TextView tv_foot_name = (TextView) view
					.findViewById(R.id.tv_foot_name);
			TextView tv_number = (TextView) view.findViewById(R.id.tv_number);
			tv_number.setText(food.getFoodNum() + "");
			tv_foot_name.setText(food.getFoodName() + "");
			view.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					mApp.startActivity_qcj(getActivity(),
							FoodCategoryActivity.class,
							mActivity.sendDataToBundle(new ModelFood(), null));
				}
			});
			ll_food.addView(view);
		}

	}

	@Override
	public void onClick(View v) {
	}
}

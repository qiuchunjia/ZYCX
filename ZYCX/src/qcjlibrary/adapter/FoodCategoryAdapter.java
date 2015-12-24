package qcjlibrary.adapter;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> 4bf5ea73991a31620f795e33af940c8d90a95782
import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.adapter.base.BAdapter;
import qcjlibrary.adapter.base.ViewHolder;
import qcjlibrary.fragment.base.BaseFragment;
<<<<<<< HEAD
import qcjlibrary.model.ModelFoodSearch;
import qcjlibrary.model.ModelFoodSearch0;
import qcjlibrary.model.ModelFoodSearch1;
import qcjlibrary.model.ModelFoodSearchIndex;
import qcjlibrary.model.base.Model;
import android.util.Log;
=======
import qcjlibrary.model.base.Model;
>>>>>>> 4bf5ea73991a31620f795e33af940c8d90a95782
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午5:06:10
 * 
 * 类描述：这个类是实现专家提问列表
 *
 */

public class FoodCategoryAdapter extends BAdapter {
<<<<<<< HEAD
	private ModelFoodSearch mSearch;

	public FoodCategoryAdapter(BaseActivity activity, ModelFoodSearch search) {
		super(activity, null);
		this.mSearch = search;
	}

	public FoodCategoryAdapter(BaseFragment fragment, ModelFoodSearch search) {
		super(fragment, null);
		this.mSearch = search;
=======

	public FoodCategoryAdapter(BaseActivity activity, List<Model> list) {
		super(activity, list);
	}

	public FoodCategoryAdapter(BaseFragment fragment, List<Model> list) {
		super(fragment, list);
>>>>>>> 4bf5ea73991a31620f795e33af940c8d90a95782
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.item_food_category, null);
			initView(convertView, holder);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		bindDataToView(holder, position);
		return convertView;
	}

	private void bindDataToView(ViewHolder holder, int position) {
		if (holder != null) {
<<<<<<< HEAD
			Model model = mList.get(position);
			if (model instanceof ModelFoodSearch0) {
				ModelFoodSearch0 search0 = (ModelFoodSearch0) model;
				mApp.displayImage(search0.getImgSrc(), holder.iv_food_icon);
				holder.tv_food_name.setText(search0.getFood_name());
				holder.tv_food_function.setText(search0.getFood_effect());
				holder.tv_cancer.setText(search0.getFood_forcancer());
			} else {
				ModelFoodSearch1 search1 = (ModelFoodSearch1) model;
				Log.i("ModelFoodSearch1", search1.toString());
				mApp.displayImage(search1.getImgSrc(), holder.iv_food_icon);
				holder.tv_food_name.setText(search1.getSide_name());
				holder.tv_food_function.setText(search1.getGongxiao());
				holder.tv_cancer.setText(search1.getFangzhi_cancer());
			}
=======
>>>>>>> 4bf5ea73991a31620f795e33af940c8d90a95782
		}
	}

	/**
	 * 初始化布局
	 * 
	 * @param convertView
	 * @param holder
	 */
	private void initView(View convertView, ViewHolder holder) {
		if (convertView != null && holder != null) {
			holder.iv_food_icon = (ImageView) convertView
					.findViewById(R.id.iv_food_icon);
			holder.tv_food_name = (TextView) convertView
					.findViewById(R.id.tv_food_name);
			holder.tv_food_function = (TextView) convertView
					.findViewById(R.id.tv_food_function);
			holder.tv_cancer = (TextView) convertView
					.findViewById(R.id.tv_cancer);
		}
	}

	@Override
	public void refreshNew() {
<<<<<<< HEAD
		sendRequest(mApp.getFoodImpl().food_search(mSearch),
				ModelFoodSearchIndex.class, 0, REFRESH_NEW);
=======
		sendRequest(null, null, 1, 1);
>>>>>>> 4bf5ea73991a31620f795e33af940c8d90a95782
	}

	@Override
	public void refreshHeader(Model item, int count) {
<<<<<<< HEAD
		// sendRequest(mApp.getFoodImpl().food_search(mSearch),
		// ModelFoodSearchIndex.class, 0, REFRESH_NEW);
=======
		sendRequest(null, null, 1, 1);
>>>>>>> 4bf5ea73991a31620f795e33af940c8d90a95782
	}

	@Override
	public void refreshFooter(Model item, int count) {
<<<<<<< HEAD
		// sendRequest(mApp.getFoodImpl().food_search(mSearch),
		// ModelFoodSearchIndex.class, 0, REFRESH_NEW);
=======
		// TODO Auto-generated method stub
>>>>>>> 4bf5ea73991a31620f795e33af940c8d90a95782
	}

	@Override
	public int getTheCacheType() {
<<<<<<< HEAD
		return 0;
	}

	@Override
	public Object getReallyList(Object object, Class type2) {
		if (object instanceof ModelFoodSearchIndex) {
			ModelFoodSearchIndex index = (ModelFoodSearchIndex) object;
			if (mSearch.getState() == 0) {
				return index.getFoodList();
			} else {
				return index.getSideList();
			}
		}
		return null;
	}
=======
		// TODO Auto-generated method stub
		return 0;
	}

>>>>>>> 4bf5ea73991a31620f795e33af940c8d90a95782
}

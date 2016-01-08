package qcjlibrary.adapter;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.adapter.base.BAdapter;
import qcjlibrary.adapter.base.ViewHolder;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.model.ModelFoodSearch0;
import qcjlibrary.model.ModelFoodSearch1;
import qcjlibrary.model.ModelFoodSearchAll;
import qcjlibrary.model.ModelFoodSearchIndex;
import qcjlibrary.model.base.Model;
import qcjlibrary.util.L;
import android.util.Log;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.baidu.location.LLSInterface;
import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午5:06:10
 * 
 * 类描述：这个类是实现专家提问列表
 *
 */

public class FoodSearchAllAdapter extends BAdapter {

	private ModelFoodSearchAll mSearch;
	private String efficacyHeader = "功效：";
	private String cancer = "针对癌肿：";

	public FoodSearchAllAdapter(BaseActivity activity, ModelFoodSearchAll search) {
		super(activity, null);
		this.mSearch = search;
	}

	public FoodSearchAllAdapter(BaseFragment fragment, List<Model> mList) {
		super(fragment, mList);
		L.d("Cathy", "mList:"+mList.size());
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

			Model model = mList.get(position);
			if (model instanceof ModelFoodSearch0) {
				ModelFoodSearch0 search0 = (ModelFoodSearch0) model;
				mApp.displayImage(search0.getImgSrc(), holder.iv_food_icon);
				holder.tv_food_name.setText(search0.getFood_name());
				holder.tv_food_function.setText(efficacyHeader+search0.getFood_effect());
				holder.tv_cancer.setText(cancer+search0.getFood_forcancer());
			} else {
				ModelFoodSearch1 search1 = (ModelFoodSearch1) model;
				Log.i("ModelFoodSearch1", search1.toString());
				mApp.displayImage(search1.getImgSrc(), holder.iv_food_icon);
				holder.tv_food_name.setText(search1.getSide_name());
				holder.tv_food_function.setText(efficacyHeader+search1.getGongxiao());
				holder.tv_cancer.setText(cancer+search1.getFangzhi_cancer());
			}

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

		sendRequest(mApp.getFoodImpl().food_search_all(mSearch),
				ModelFoodSearchIndex.class, 0, REFRESH_NEW);

	}

	@Override
	public void refreshHeader(Model item, int count) {

		// sendRequest(mApp.getFoodImpl().food_search(mSearch),
		// ModelFoodSearchIndex.class, 0, REFRESH_NEW);

	}

	@Override
	public void refreshFooter(Model item, int count) {

		// sendRequest(mApp.getFoodImpl().food_search(mSearch),
		// ModelFoodSearchIndex.class, 0, REFRESH_NEW);

	}

	@Override
	public int getTheCacheType() {

		return 0;
	}

	@Override
	public Object getReallyList(Object object, Class type2) {
		if (object instanceof ModelFoodSearchIndex) {
			ModelFoodSearchIndex index = (ModelFoodSearchIndex) object;
			/*if (mSearch.getState() == 0) {
				return index.getFoodList();
			} else {
				return index.getSideList();
			}*/
		}
		return null;
	}

}

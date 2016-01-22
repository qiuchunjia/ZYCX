package qcjlibrary.activity;

import java.util.List;

import com.zhiyicx.zycx.R;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.adapter.FoodFuctionGvAdapter;
import qcjlibrary.model.ModelFoodIdDetail;
import qcjlibrary.model.ModelFoodSearch1;
import qcjlibrary.model.ModelFoodWayDetail;
import qcjlibrary.model.ModelFoodWayDetailInfo;
import qcjlibrary.widget.MyGridView;

/**
 * author：qiuchunjia time：下午4:17:17 类描述：这个类是实现
 *
 */

public class FoodWaySingleDetail extends BaseActivity {
	private TextView tv_food_name;
	private TextView tv_food_category;
	private ImageView iv_food_icon;
	private RelativeLayout rl_contain;
	private TextView tv_food_main_value;
	private TextView tv_function_value;
	private RelativeLayout rl_funtion;
	private TextView tv_category_value;
	private TextView tv_food_way_value;
	private TextView tv_flag;
	private ImageView iv_relate1;
	private TextView tv_relate1;
	private ImageView iv_relate2;
	private TextView tv_relate2;
	private ImageView iv_relate3;
	private TextView tv_relate3;
	private ImageView iv_relate4;
	private TextView tv_relate4;
	// gridview
	private MyGridView gv_contain;
	private MyGridView gv_function;

	private ModelFoodSearch1 mFoodData;
	private ModelFoodWayDetail mDetail;
	
	/** 网络异常时的缺省图**/
	private View defaultView;
	private boolean isFirst = false;
	private int count;
	private LinearLayout ll_foodway_parent;

	@Override
	public String setCenterTitle() {
		return "姜汤肚";
	}

	@Override
	public void initIntent() {

		mFoodData = (ModelFoodSearch1) getDataFromIntent(getIntent(), null);

	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_food_way_single_detail;
	}

	@Override
	public void initView() {
		tv_food_name = (TextView) findViewById(R.id.tv_food_name);
		tv_food_category = (TextView) findViewById(R.id.tv_food_category);
		iv_food_icon = (ImageView) findViewById(R.id.iv_food_icon);
		tv_food_main_value = (TextView) findViewById(R.id.tv_food_main_value);
		tv_function_value = (TextView) findViewById(R.id.tv_function_value);
		rl_funtion = (RelativeLayout) findViewById(R.id.rl_funtion);
		tv_category_value = (TextView) findViewById(R.id.tv_category_value);
		tv_food_way_value = (TextView) findViewById(R.id.tv_food_way_value);
		tv_flag = (TextView) findViewById(R.id.tv_flag);
		iv_relate1 = (ImageView) findViewById(R.id.iv_relate1);
		tv_relate1 = (TextView) findViewById(R.id.tv_relate1);
		iv_relate2 = (ImageView) findViewById(R.id.iv_relate2);
		tv_relate2 = (TextView) findViewById(R.id.tv_relate2);
		iv_relate3 = (ImageView) findViewById(R.id.iv_relate3);
		tv_relate3 = (TextView) findViewById(R.id.tv_relate3);
		iv_relate4 = (ImageView) findViewById(R.id.iv_relate4);
		tv_relate4 = (TextView) findViewById(R.id.tv_relate4);
		gv_contain = (MyGridView) findViewById(R.id.gv_contain);
		gv_function = (MyGridView) findViewById(R.id.gv_function);
		ll_foodway_parent = (LinearLayout) findViewById(R.id.ll_foodway_parent);

	}

	@Override
	public void initData() {
		count = ll_foodway_parent.getChildCount();
		sendRequest(mApp.getFoodImpl().food_side_detail(mFoodData), ModelFoodWayDetail.class, REQUEST_GET);
	}

	@Override
	public Object onResponceSuccess(String str, Class class1) {
		Object object = super.onResponceSuccess(str, class1);
		if (object instanceof ModelFoodWayDetail) {
			mDetail = (ModelFoodWayDetail) object;
			addInfoToView(mDetail.getInfo());
			addRelateToView(mDetail.getSideList());
		}
		return object;
	}

	/**
	 * 把基本信息添加到上面
	 * 
	 * @param info
	 */
	private void addInfoToView(ModelFoodWayDetailInfo info) {
		if (info != null) {
			titleSetCenterTitle(info.getSide_name());
			tv_food_name.setText(info.getSide_name());
			mApp.displayImage(info.getImgSrc(), iv_food_icon);
			// TODO 添加圆形的控件
			String zucheng = info.getZucheng();
			if (!TextUtils.isEmpty(zucheng)) {
				String[] dataArray = zucheng.split("，");
				Log.i("effect", dataArray.toString());
				FoodFuctionGvAdapter adapter = new FoodFuctionGvAdapter(this, dataArray);
				gv_contain.setAdapter(adapter);
			}
			tv_food_way_value.setText(info.getZuofa());
			tv_category_value.setText(info.getFangzhi_cancer());
			String suitable = info.getShiyi();
			if(!TextUtils.isEmpty(suitable)){
				tv_flag.setText(suitable);
			}
			String foodeffect = info.getGongxiao();
			if (!TextUtils.isEmpty(foodeffect)) {
				String[] dataArray = foodeffect.split("，");
				Log.i("effect", dataArray.toString());
				FoodFuctionGvAdapter adapter = new FoodFuctionGvAdapter(this, dataArray);
				gv_function.setAdapter(adapter);
			}
		}
	}

	/**
	 * 添加相关的图片
	 * 
	 * @param foodRel
	 */
	private void addRelateToView(List<ModelFoodWayDetailInfo> foodRel) {
		if (foodRel != null) {
			for (int i = 0; i < foodRel.size(); i++) {
				ModelFoodWayDetailInfo detailInfo = foodRel.get(i);
				if (i == 0) {
					mApp.displayImage(detailInfo.getImgSrc(), iv_relate1);
					tv_relate1.setText(detailInfo.getSide_name());
				} else if (i == 1) {
					mApp.displayImage(detailInfo.getImgSrc(), iv_relate2);
					tv_relate2.setText(detailInfo.getSide_name());
				} else if (i == 2) {
					mApp.displayImage(detailInfo.getImgSrc(), iv_relate3);
					tv_relate3.setText(detailInfo.getSide_name());
				} else if (i == 3) {
					mApp.displayImage(detailInfo.getImgSrc(), iv_relate4);
					tv_relate4.setText(detailInfo.getSide_name());
				}
			}
		}

	}

	@Override
	public void initListener() {

	}

	@Override
	public void onClick(View v) {

	}

	@Override
	public View onRequestFailed() {
		// TODO 自动生成的方法存根
		defaultView = super.onRequestFailed();
		TextView tv_reload = (TextView) defaultView.findViewById(R.id.tv_reload);
		tv_reload.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sendRequest(mApp.getFoodImpl().food_side_detail(mFoodData), 
						ModelFoodWayDetail.class, REQUEST_GET);
			}
		});
		for (int i = 0; i < count; i++) {
			ll_foodway_parent.getChildAt(i).setVisibility(View.GONE);
		}
		if(!isFirst){
			isFirst = true;
			ll_foodway_parent.addView(defaultView); 
		} else{
			defaultView.setVisibility(View.VISIBLE);
		}
		return defaultView;
		
	}
	
	@Override
	public View onRequestSuccess() {
		for (int i = 0; i < count; i++) {
			ll_foodway_parent.getChildAt(i).setVisibility(View.VISIBLE);
		}
		if(defaultView != null){
			defaultView.setVisibility(View.GONE);
		}
		return defaultView;
	}
}

package qcjlibrary.activity;

import java.util.ArrayList;
import java.util.List;

import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.activity.base.Title;
import qcjlibrary.model.ModelCancerCategory;
import qcjlibrary.model.ModelMsg;
import qcjlibrary.model.ModelRequest;
import qcjlibrary.model.ModelRequestAsk;
import qcjlibrary.model.base.Model;
import qcjlibrary.util.ToastUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午4:31:08 类描述：这个类是实现
 *
 */

public class RequestChooseCancerActivity extends BaseActivity {
	private LinearLayout ll_choose_cancer;
	private List<ModelCancerCategory> mList;
	private ModelRequestAsk mAsk;
	private String mCancerId = ""; // 癌症种类 用逗号隔开
	private Title title;

	@Override
	public String setCenterTitle() {
		return "选择癌种";
	}

	@Override
	public void initIntent() {
		mAsk = (ModelRequestAsk) getDataFromIntent(getIntent(), null);
	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_request_choose_cancer;
	}

	@Override
	public void initView() {
		ll_choose_cancer = (LinearLayout) findViewById(R.id.ll_choose_cancer);
		titleSetRightTitle("下一步");
	}

	@Override
	public void initData() {
		title = getTitleClass();
		ivList = new ArrayList<ImageView>();
		sendRequest(mApp.getRequestImpl().index(null), ModelRequest.class, 0);
	}

	@Override
	public Object onResponceSuccess(String str, Class class1) {
		Object object = super.onResponceSuccess(str, class1);
		if (object instanceof ModelRequest) {
			ModelRequest request = (ModelRequest) object;
			mList = request.getFenlei();
			addDataToView(mList);
		}
		return object;
	}
	
	private List<ImageView> ivList;

	/**
	 * 添加数据到界面
	 * 
	 * @param list
	 */
	private void addDataToView(List<ModelCancerCategory> list) {
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				ModelCancerCategory category = list.get(i);
				View view = mInflater
						.inflate(R.layout.item_choose_cancer, null);
				TextView tv_cancer = (TextView) view
						.findViewById(R.id.tv_cancer);
				RelativeLayout rl_choose_cancer = (RelativeLayout) view
						.findViewById(R.id.rl_choose_cancer);
				final ImageView iv_choose = (ImageView) view
						.findViewById(R.id.iv_choose);
				ivList.add(iv_choose);
				tv_cancer.setText(category.getTitle());
				iv_choose.setTag(category);
				iv_choose.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						if (v.getTag() instanceof ModelCancerCategory) {
							for (int j = 0; j < ivList.size(); j++) {
								ivList.get(j).setImageResource(R.drawable.weixuanzhong02);
							}
							ModelCancerCategory cancerCategory = (ModelCancerCategory) v
									.getTag();
							iv_choose.setImageResource(R.drawable.xuanzhong02);
							mAsk.setCid(cancerCategory.getId());
//							mApp.startActivity_qcj(
//									RequestChooseCancerActivity.this,
//									RequestAddFlagActivity.class,
//									sendDataToBundle(mAsk, null));
						}
					}
				});
				ll_choose_cancer.addView(view);
			}
		}
	}

	// /**
	// * 统计被选中的癌症并显示出来
	// *
	// * @param imageView
	// */
	// private void countTheChooseAndDisplay(ImageView imageView) {
	// if (imageView != null) {
	// int flag = (Integer) imageView.getTag();
	// if (mChooseArray[flag]) {
	// imageView.setImageResource(R.drawable.weixuanzhong02);
	// mChooseArray[flag] = false;
	// } else {
	// int count = 0; // 计算选择的癌症的个数
	// for (int i = 0; i < mChooseArray.length; i++) {
	// if (mChooseArray[i]) {
	// count++;
	// }
	// if (count >= 3) {
	// ToastUtils.showToast("最多只能选三个癌种");
	// return;
	// }
	// }
	// imageView.setImageResource(R.drawable.xuanzhong02);
	// mChooseArray[flag] = true;
	// }
	// }
	// }

	@Override
	public void initListener() {
		title.tv_title_right.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(mAsk.getCid() == null){
					ToastUtils.showToast("请选择癌肿！");
					return;
				}
				mApp.startActivity_qcj(
						RequestChooseCancerActivity.this,
						RequestAddFlagActivity.class,
						sendDataToBundle(mAsk, null));
			}
		});
	}

	@Override
	public void onClick(View v) {

	}

}

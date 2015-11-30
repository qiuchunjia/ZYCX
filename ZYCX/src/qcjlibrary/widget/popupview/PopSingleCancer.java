package qcjlibrary.widget.popupview;

import qcjlibrary.widget.popupview.base.PopView;
import qcjlibrary.widget.popupview.base.PopView.PopResultListener;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午4:24:58 类描述：这个类是实现
 *
 */

public class PopSingleCancer extends PopView {

	private ImageView iv_cancer_icon;
	private TextView tv_cancer_name;
	private TextView tv_cancer_bangzhuvalue;
	private TextView tv_cancer_membervalue;
	private TextView tv_cancer_experiencevalue;
	private TextView tv_cancer_content;
	private ImageView iv_bottom_arrow;

	public PopSingleCancer(Activity activity, Object object,
			PopResultListener resultListener) {
		super(activity, object, resultListener);
	}

	@Override
	public int getLayoutId() {
		return R.layout.pop_single_cancer;
	}

	@Override
	public void initPopView() {
		iv_cancer_icon = (ImageView) findViewbyId(R.id.iv_cancer_icon);
		tv_cancer_name = (TextView) findViewbyId(R.id.tv_cancer_name);
		tv_cancer_bangzhuvalue = (TextView) findViewbyId(R.id.tv_cancer_bangzhuvalue);
		tv_cancer_membervalue = (TextView) findViewbyId(R.id.tv_cancer_membervalue);
		tv_cancer_experiencevalue = (TextView) findViewbyId(R.id.tv_cancer_experiencevalue);
		tv_cancer_content = (TextView) findViewbyId(R.id.tv_cancer_content);
		iv_bottom_arrow = (ImageView) findViewbyId(R.id.iv_bottom_arrow);

	}

	@Override
	public void initPopData(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPopLisenter(PopResultListener listener) {
		iv_bottom_arrow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mPopWindow.dismiss();
			}
		});

	}

}

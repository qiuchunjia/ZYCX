package qcjlibrary.widget.popupview;

import qcjlibrary.util.UIUtils;
import qcjlibrary.widget.popupview.base.PopView;
import android.app.Activity;
import android.view.View;
import android.widget.GridView;
import android.widget.PopupWindow;
import android.widget.LinearLayout.LayoutParams;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：下午5:19:54 类描述：这个类是实现
 *
 */

public class PopCancerCategory extends PopView {
	private GridView gv_category;

	public PopCancerCategory(Activity activity, Object object,
			PopResultListener resultListener) {
		super(activity, object, resultListener);
	}

	@Override
	public int getLayoutId() {
		return R.layout.pop_cancer_category;
	}

	@Override
	public void initPopView() {
		gv_category = (GridView) findViewbyId(R.id.gv_category);

	}

	@Override
	public PopupWindow setPopWidthAndHeight(View dataView) {
		PopupWindow popupWindow = new PopupWindow(dataView,
				UIUtils.getWindowWidth(mActivity) / 5 * 3,
				LayoutParams.MATCH_PARENT);
		return popupWindow;
	}

	@Override
	public void initPopData(Object object) {

	}

	@Override
	public void setPopLisenter(PopResultListener listener) {
		// TODO Auto-generated method stub

	}

}

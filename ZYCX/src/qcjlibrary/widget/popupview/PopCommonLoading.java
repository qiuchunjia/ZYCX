package qcjlibrary.widget.popupview;

import com.zhiyicx.zycx.R;

import android.app.Activity;
import android.view.View;
import android.widget.PopupWindow;
import qcjlibrary.widget.popupview.base.PopView;

public class PopCommonLoading extends PopView {

	public PopCommonLoading(Activity activity, Object object, PopResultListener resultListener) {
		super(activity, object, resultListener);
	}

	@Override
	public int getLayoutId() {
		return R.layout.pop_common_loading;
	}

	@Override
	public void initPopView() {

	}

	@Override
	public void setAnimationStyle(PopupWindow popupWindow) {
		// 覆盖父类的方法，让它直接弹出来
	}

	@Override
	public PopupWindow setPopWidthAndHeight(View dataView) {
		return setPopWidthAndHeight2(dataView);
	}

	@Override
	public void initPopData(Object object) {

	}

	@Override
	public void setPopLisenter(PopResultListener listener) {

	}

}

package qcjlibrary.widget.popupview;

import com.zhiyicx.zycx.R;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import qcjlibrary.util.DisplayUtils;
import qcjlibrary.util.UIUtils;
import qcjlibrary.widget.popupview.base.PopView;

public class PopImportFile extends PopView {
	private TextView tv_dectory;
	private Button btn_sure;

	public PopImportFile(Activity activity, Object object, PopResultListener resultListener) {
		super(activity, object, resultListener);
	}

	@Override
	public int getLayoutId() {
		return R.layout.pop_import_file;
	}

	@Override
	public PopupWindow setPopWidthAndHeight(View dataView) {
		PopupWindow popupWindow = new PopupWindow(dataView,
				UIUtils.getWindowWidth(mActivity) - DisplayUtils.dp2px(mActivity, 40), LayoutParams.WRAP_CONTENT);
		return popupWindow;
	}

	@Override
	public void initPopView() {
		tv_dectory = (TextView) findViewbyId(R.id.tv_dectory);
		btn_sure = (Button) findViewbyId(R.id.btn_sure);
	}

	@Override
	public void initPopData(Object object) {
		tv_dectory.setText("路径:" + object.toString());

	}

	@Override
	public void setPopLisenter(PopResultListener listener) {
		btn_sure.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mPopWindow.dismiss();
			}
		});

	}

}

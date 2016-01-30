package qcjlibrary.util;

import com.zhiyicx.zycx.R;

import android.content.Context;
import qcjlibrary.widget.LoadingDialog;

public class LoadingDialogUtl {
	private static LoadingDialog dialog;

	public static void loadingView(Context context) {
		if (dialog == null) {
			dialog = new LoadingDialog(context, R.layout.pop_common_loading);
		}
		dialog.setCancelable(false);
		dialog.setCanceledOnTouchOutside(true);
		if(!dialog.isShowing()){
			dialog.show();
		}
	}

	public static void hideLoadingView() {
		if (dialog != null) {
			dialog.dismiss();
			dialog = null;
		}
	}
}

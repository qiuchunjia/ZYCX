package qcjlibrary.util;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class EditTextUtils {
	private MyTextWatch mWatcher;
	public MyTextWatch getMyWatcher(int limit, EditText edt, Context context){
		mWatcher = new MyTextWatch(limit, edt, context); 
		return mWatcher;
	}
	public class MyTextWatch implements TextWatcher {

		private int limit;
		private EditText edt;
		private Context context;
		private CharSequence temp;

		public MyTextWatch(int limit, EditText edt, Context context) {
			super();
			this.limit = limit;
			this.edt = edt;
			this.context = context;
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			temp = s;
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {

		}

		@Override
		public void afterTextChanged(Editable s) {
			if (temp.length() > limit) {
				ToastUtils.showLongToast(context, "输入字符不可超过" + limit);
				temp = temp.subSequence(0, limit);
				edt.setText(temp);
			}

		}

	}
}

package qcjlibrary.util;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class EditTextUtils {
	private MyTextWatch mWatcher;

	public MyTextWatch getMyWatcher(int limit, EditText edt, Context context) {
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

	public static boolean isEmojiCharacter(char codePoint) {
        return !((codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA) || 
        		(codePoint == 0xD) || ((codePoint >= 0x20) && codePoint <= 0xD7FF))|| 
        		((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) || 
        		((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
  }
	
	public static boolean isContainEmoji(String content){
		for (int i = 0; i < content.length(); i++) {
			if(isEmojiCharacter(content.charAt(i))){
				return true;
			}
		}
		return false;
	}
}

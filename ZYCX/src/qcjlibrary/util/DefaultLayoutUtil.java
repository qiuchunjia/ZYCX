package qcjlibrary.util;

import android.view.View;
import android.view.ViewGroup;

public class DefaultLayoutUtil {
	
	public static boolean showDefault(ViewGroup parent, View defaultView,boolean isFirst){
		int count = parent.getChildCount();
		for (int i = 0; i < count; i++) {
			parent.getChildAt(i).setVisibility(View.GONE);
		}
		if(isFirst){
			isFirst = false;
			parent.addView(defaultView); 
		} else{
			defaultView.setVisibility(View.VISIBLE);
		}
		return isFirst;
	}
	public static View hideDefault(ViewGroup parent,View defaultView){
		int count = parent.getChildCount();
		for (int i = 0; i < count; i++) {
			parent.getChildAt(i).setVisibility(View.VISIBLE);
		}
		if(defaultView != null){
			defaultView.setVisibility(View.GONE);
		}
		return defaultView;
	}
}

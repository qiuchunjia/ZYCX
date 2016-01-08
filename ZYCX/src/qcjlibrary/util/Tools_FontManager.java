package qcjlibrary.util;

import android.app.Activity;  
import android.graphics.Color;
import android.graphics.Typeface;  
import android.text.TextPaint;
import android.view.View;  
import android.view.ViewGroup;  
import android.widget.Button;  
import android.widget.EditText;  
import android.widget.TextView;  
 
public class Tools_FontManager {  
    
    public static void changeFonts(ViewGroup root, Activity act) {  
    
       Typeface tf = Typeface.createFromAsset(act.getAssets(),  
              "fonts/jingleiti.TTF");  
    
		for (int i = 0; i < root.getChildCount(); i++) {
			View v = root.getChildAt(i);
			if (v instanceof TextView) {
				TextView tv = ((TextView) v);
				tv.setTypeface(tf);
				setFakeBold(tv);
			} else if (v instanceof Button) {
				Button btn = ((Button) v);
				btn.setTypeface(tf);
				setFakeBold(btn);
			} else if (v instanceof EditText) {
				EditText edt = ((EditText) v);
				edt.setTypeface(tf);
				setFakeBold(edt);
			} else if (v instanceof ViewGroup) {
				changeFonts((ViewGroup) v, act);
			}
		}
    
    }

	public static void setFakeBold(TextView tv) {
		TextPaint tpaint = tv.getPaint();
		tpaint.setFakeBoldText(true);
		tv.setTextColor(Color.BLUE);
	}  
}  

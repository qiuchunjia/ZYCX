package qcjlibrary.widget;

import com.umeng.socialize.utils.Log;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class MyScrollView extends ScrollView{

	private float yScrollDistance;
	private boolean isFirstItem;
	private boolean isFirst = true;
	
	public MyScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public MyScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MyScrollView(Context context) {
		super(context);
	}
	
	private float xDistance, yDistance, xLast, yLast;
	
	@Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xDistance = yDistance = 0f;
                xLast = ev.getX();
                yLast = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                final float curX = ev.getX();
                final float curY = ev.getY();

                xDistance += Math.abs(curX - xLast);
                yDistance += Math.abs(curY - yLast);
                xLast = curX;
                yLast = curY;

                if(xDistance > yDistance){
                    return false;
                }  
                
//                if(isFirstItem){
//                	if(yScrollDistance < 3 && yScrollDistance > -3){
//                		return true;
//                	} else{
//                		return false;
//                	}
//                } else{
//                	return false;
//                }
//                if(mTop >= offset){
//                	return false;
//                }
        }

        return super.onInterceptTouchEvent(ev);
    }
	
	public void setVisibleItem(int item){
		if(item == 0){
			isFirstItem = true;
		} else{
			isFirstItem = false;
		}
	}
	
	private int mTop;
	private int offset;
	public void setFirstTop(int top, int offset){
		this.mTop = top;
		this.offset = offset;
	}
	

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		// TODO 自动生成的方法存根
		super.onScrollChanged(l, t, oldl, oldt);
		if(isFirst){
			yScrollDistance = 0;
			isFirst = false;
			return;
		}
		if(t == oldt ){
			//此时未滑动 记录位置
			yScrollDistance = 0;
		} else{
			yScrollDistance = t - oldt;
		}
		
		if(mLinstener != null){
			mLinstener.onScrollChanged(this, l, t, oldl, oldt);
		}
	}
	
	private ScrollViewListener mLinstener;
	public void setScrollViewListener(ScrollViewListener l){
		this.mLinstener = l;
	}
	
}

package qcjlibrary.widget.popupview;

import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.sociax.unit.SociaxUIUtils;

import android.app.Activity;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import qcjlibrary.util.ToastUtils;
import qcjlibrary.widget.popupview.base.PopView;

public class PopQclassCmt extends PopView{

	/**
	 * 轻课堂 评论
	 * @author Tan
	 * @since 1.4
	 * */
	
	private ImageView iv_qclass_cancel;
	private ImageView iv_qclass_send;
	private EditText edt_qclass_cmd;
	private TextView tv_words_count;
	/** 可输入字数**/
	private int wordsCount;
	
	public PopQclassCmt(Activity activity, Object object, 
			PopResultListener resultListener) {
		super(activity, object, resultListener);
	}

	@Override
	public int getLayoutId() {
		// TODO 自动生成的方法存根
		return R.layout.pop_qclass_cmt;
	}

	@Override
	public void initPopView() {
		iv_qclass_cancel = (ImageView) findViewbyId(R.id.iv_qclass_cancel);
		iv_qclass_send = (ImageView) findViewbyId(R.id.iv_qclass_send);
		edt_qclass_cmd = (EditText) findViewbyId(R.id.edt_qclass_cmd);
		tv_words_count = (TextView) findViewbyId(R.id.tv_words_count);
	}

	@Override
	public void initPopData(Object object) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void setPopLisenter(final PopResultListener listener) {
		// 监听输入字数，不能超过400
		edt_qclass_cmd.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO 自动生成的方法存根
				wordsCount = 400 - count;
				if(wordsCount < 0){
					tv_words_count.setTextColor(Color.RED);
				} else{
					tv_words_count.setTextColor(Color.BLACK);
				}
				tv_words_count.setText(wordsCount+"");
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO 自动生成的方法存根
				
			}
		});
		/**
		 * 取消发送
		 * */
		iv_qclass_cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mPopWindow.dismiss();
			}
		});
		/**
		 * 发送评论
		 * */
		iv_qclass_send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String content = edt_qclass_cmd.getText().toString();
				if(content != null && !content.equals("")){
					if(wordsCount < 0){
						ToastUtils.showLongToast(mActivity, "字数超过最大字数");
					} else{
						listener.onPopResult(content);
						SociaxUIUtils.hideSoftKeyboard(mActivity, edt_qclass_cmd);
						mPopWindow.dismiss();
					}
				} else{
					ToastUtils.showLongToast(mActivity, "评论不能为空");
				}
				
			}
		});
	}

}

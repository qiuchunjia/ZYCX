package qcjlibrary.fragment;

import qcjlibrary.fragment.base.BaseFragment;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.zhiyicx.zycx.R;

/**
 * author：qiuchunjia time：上午10:32:51 类描述：这个类是实现
 *
 */

public class FragmentIndex extends BaseFragment {
	private RelativeLayout rl_ads;
	private RelativeLayout index_choose;
	private LinearLayout ll_first;
	private RelativeLayout rl_1;
	private RelativeLayout rl_2;
	private RelativeLayout rl_3;
	private RelativeLayout rl_4;
	private RelativeLayout rl_5;
	private RelativeLayout rl_6;

	@Override
	public void initIntentData() {

	}

	@Override
	public int getLayoutId() {
		return R.layout.fragment_index;
	}

	@Override
	public void initView() {
		rl_ads = (RelativeLayout) findViewById(R.id.rl_ads);
		index_choose = (RelativeLayout) findViewById(R.id.index_choose);
		ll_first = (LinearLayout) findViewById(R.id.ll_first);
		rl_1 = (RelativeLayout) findViewById(R.id.rl_1);
		rl_2 = (RelativeLayout) findViewById(R.id.rl_2);
		rl_3 = (RelativeLayout) findViewById(R.id.rl_3);
		rl_4 = (RelativeLayout) findViewById(R.id.rl_4);
		rl_5 = (RelativeLayout) findViewById(R.id.rl_5);
		rl_6 = (RelativeLayout) findViewById(R.id.rl_6);
	}

	@Override
	public void initListener() {
		rl_1.setOnClickListener(this);
		rl_2.setOnClickListener(this);
		rl_3.setOnClickListener(this);
		rl_4.setOnClickListener(this);
		rl_5.setOnClickListener(this);
		rl_6.setOnClickListener(this);
	}

	@Override
	public void initData() {

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.rl_1:
			// TODO
			break;

		case R.id.rl_2:
			// TODO
			break;
		case R.id.rl_3:
			// TODO
			break;
		case R.id.rl_4:
			// TODO
			break;
		case R.id.rl_5:
			// TODO
			break;
		case R.id.rl_6:
			// TODO
			break;

		}
	}
}

package qcjlibrary.adapter;

import java.util.List;

import com.zhiyicx.zycx.R;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.adapter.base.BAdapter;
import qcjlibrary.adapter.base.ViewHolder;
import qcjlibrary.fragment.base.BaseFragment;
import qcjlibrary.model.ModelRequest;
import qcjlibrary.model.ModelRequestFlag;
import qcjlibrary.model.ModelRequestItem;
import qcjlibrary.model.ModelRequestMyAsk;
import qcjlibrary.model.ModelRequestSearch;
import qcjlibrary.model.base.Model;
import qcjlibrary.util.SpanUtil;

/**
 * author：qiuchunjia time：下午5:06:10
 * 
 * 类描述：这个类是实现专家提问列表
 *
 */

public class RequestAnswerAdapter extends BAdapter {
	private Model mRequestData;
	private int page = 0;
	private int myAskPage = 0;

	public RequestAnswerAdapter(BaseActivity activity, Model data) {
		super(activity, null);
		this.mRequestData = data;
	}

	public RequestAnswerAdapter(BaseActivity activity, List<Model> list, Model data) {
		super(activity, list);
		this.mRequestData = data;
	}

	public RequestAnswerAdapter(BaseFragment fragment, Model data) {
		super(fragment, null);
		this.mRequestData = data;
	}

	public RequestAnswerAdapter(BaseFragment fragment, List<Model> list, Model data) {
		super(fragment, list);
		this.mRequestData = data;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.item_request_answer, null);
			initView(convertView, holder);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		bindDataToView(holder, position);
		return convertView;
	}

	private void bindDataToView(ViewHolder holder, int position) {
		if (holder != null) {
			ModelRequestItem modelRequestItem = (ModelRequestItem) mList.get(position);
			if (modelRequestItem != null) {
				holder.tv_title.setText("");
				Drawable drawable = mBaseActivity.getResources().getDrawable(R.drawable.q);
				holder.tv_title.setText(SpanUtil.setImageSpan("xx "+" "+modelRequestItem.getQuestion_content(), 0, 2, drawable));
//				holder.tv_title.append("  " + modelRequestItem.getQuestion_content());
				holder.tv_answer.setVisibility(View.GONE);
				holder.tv_advice.setVisibility(View.GONE);
				holder.tv_expert_answer.setVisibility(View.GONE);
				if (modelRequestItem.getAnswercontent() != null && !modelRequestItem.getAnswercontent().equals("")) {
					holder.tv_answer.setVisibility(View.VISIBLE);
					Drawable anwerDrable = mBaseActivity.getResources().getDrawable(R.drawable.a);
					holder.tv_answer.setText("");
					holder.tv_answer.setText(SpanUtil.setImageSpan("xx "+" "+modelRequestItem.getAnswername() + ":" + modelRequestItem.getAnswercontent(), 0, 2, anwerDrable));
//					holder.tv_answer.append(
//							"  " + modelRequestItem.getAnswername() + ":" + modelRequestItem.getAnswercontent());
				}
				if (modelRequestItem.getIs_recommend() != null) {
					if (modelRequestItem.getIs_recommend().equals("1")) {
						holder.tv_advice.setVisibility(View.VISIBLE);
					}
				}
				if (modelRequestItem.getIs_expert() != null) {
					if (modelRequestItem.getIs_expert().equals("1")) {
						if(modelRequestItem.getAnswercontent() != null &&
								!modelRequestItem.getAnswercontent().equals(" ") &&
								!modelRequestItem.getAnswercontent().equals("")){
							holder.tv_answer.setVisibility(View.GONE);
							holder.tv_expert_answer.setVisibility(View.VISIBLE);
							holder.tv_expert_answer.setText("");
							holder.tv_expert_answer.setText(SpanUtil.setForegroundColorSpan("专家建议："+modelRequestItem.getAnswercontent(), 0, 5,
									mBaseActivity.getResources().getColor(R.color.text_yellow)));
//							holder.tv_expert_answer.append(modelRequestItem.getAnswercontent());
						}
					}
				}
				holder.tv_date.setText(modelRequestItem.getTime());
				holder.tv_num.setText(modelRequestItem.getAnswer_count());
			}
		}
	}

	/**
	 * 初始化布局
	 * 
	 * @param convertView
	 * @param holder
	 */
	private void initView(View convertView, ViewHolder holder) {
		if (convertView != null && holder != null) {
			holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
			holder.tv_advice = (TextView) convertView.findViewById(R.id.tv_advice);
			holder.tv_answer = (TextView) convertView.findViewById(R.id.tv_answer);
			holder.tv_expert_answer = (TextView) convertView.findViewById(R.id.tv_expert_answer);
			holder.tv_date = (TextView) convertView.findViewById(R.id.tv_date);
			holder.tv_num = (TextView) convertView.findViewById(R.id.tv_num);

		}
	}

	@Override
	public void refreshNew() {
		if (mRequestData instanceof ModelRequestSearch) {
			ModelRequestSearch search = (ModelRequestSearch) mRequestData;
			search.setLastid(null);
			// 这个用于搜索
			sendRequest(mApp.getRequestImpl().search(search), ModelRequest.class, 0, REFRESH_NEW);
		} else if (mRequestData instanceof ModelRequestItem) {
			ModelRequestItem item = (ModelRequestItem) mRequestData;
			page = 0;
			item.setPage(page);
			// 这个接口用于首页
			Log.i("anwer", item.toString() + "");
			sendRequest(mApp.getRequestImpl().index(item), ModelRequest.class, 0, REFRESH_NEW);
		} else if (mRequestData instanceof ModelRequestFlag) {
			// 这个接口用于标签
			ModelRequestFlag flag = (ModelRequestFlag) mRequestData;
			flag.setLastid(null);
			sendRequest(mApp.getRequestImpl().topicQuestion(flag), ModelRequest.class, 0, REFRESH_NEW);
		} else if (mRequestData instanceof ModelRequestMyAsk) {
			myAskPage = 0;
			sendRequest(mApp.getRequestImpl().myAsk(null), ModelRequest.class, 0, REFRESH_NEW);
		}
	}

	@Override
	public void refreshHeader(Model item, int count) {
		refreshNew();
		// if (mRequestData instanceof ModelRequestSearch) {
		// ModelRequestSearch search = (ModelRequestSearch) mRequestData;
		// // 这个用于搜索
		// sendRequest(mApp.getRequestImpl().search(search), ModelRequest.class,
		// 0, REFRESH_HEADER);
		// } else if (mRequestData instanceof ModelRequestItem) {
		// ModelRequestItem data = (ModelRequestItem) mRequestData;
		// // 这个接口用于首页
		// sendRequest(mApp.getRequestImpl().index(data), ModelRequest.class, 0,
		// REFRESH_HEADER);
		// } else if (mRequestData instanceof ModelRequestFlag) {
		// // 这个接口用于标签
		// ModelRequestFlag flag = (ModelRequestFlag) mRequestData;
		// sendRequest(mApp.getRequestImpl().topicQuestion(flag),
		// ModelRequest.class, 0, REFRESH_HEADER);
		// } else if (mRequestData instanceof ModelRequestMyAsk) {
		// dismissTheProgress();
		// }
	}

	@Override
	public void refreshFooter(Model item, int count) {
		ModelRequestItem requestItem = (ModelRequestItem) item;
		if (mRequestData instanceof ModelRequestSearch) {
			ModelRequestSearch search = (ModelRequestSearch) mRequestData;
			search.setLastid(requestItem.getQuestion_id());
			// 这个用于搜索
			sendRequest(mApp.getRequestImpl().search(search), ModelRequest.class, 0, REFRESH_FOOTER);
		} else if (mRequestData instanceof ModelRequestItem) {
			ModelRequestItem data = (ModelRequestItem) mRequestData;
			// 这个接口用于首页
			//data.setLastid(requestItem.getQuestion_id());
			page++;
			data.setPage(page);
			sendRequest(mApp.getRequestImpl().index(data), ModelRequest.class, 0, REFRESH_FOOTER);
		} else if (mRequestData instanceof ModelRequestFlag) {
			// 这个接口用于标签
			ModelRequestFlag flag = (ModelRequestFlag) mRequestData;
			flag.setLastid(requestItem.getQuestion_id());
			sendRequest(mApp.getRequestImpl().topicQuestion(flag), ModelRequest.class, 0, REFRESH_FOOTER);
		} else if (mRequestData instanceof ModelRequestMyAsk) {
			ModelRequestMyAsk myAsk = (ModelRequestMyAsk) mRequestData;
//			myAsk.setLastid(requestItem.getQuestion_id());
			++myAskPage;
			myAsk.setPage(myAskPage+"");
			sendRequest(mApp.getRequestImpl().myAsk(myAsk), ModelRequest.class, 0, REFRESH_FOOTER);
			//dismissTheProgress();
		}
	}

	@Override
	public int getTheCacheType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getReallyList(Object object, Class type2) {
		if (object instanceof ModelRequest) {
			ModelRequest request = (ModelRequest) object;
			if(isLoading()){
				setLoading(false);
			}
			return request.getList();
		}
		return null;
	}
	

}

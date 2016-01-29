package qcjlibrary.adapter;

import java.util.List;

import com.zhiyicx.zycx.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import qcjlibrary.activity.base.BaseActivity;
import qcjlibrary.listview.base.pinnedheaderlistview.SectionedBaseAdapter;
import qcjlibrary.model.base.Model;
import qcjlibrary.util.ToastUtils;

public class TestSectionedAdapter extends SectionedBaseAdapter {

	public TestSectionedAdapter(BaseActivity activity, List<Model> list) {
		super(activity, list);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getItem(int section, int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int section, int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSectionCount() {
		return 1;
	}

	@Override
	public int getCountForSection(int section) {
		ToastUtils.showToast("mList.size()="+mList.size());
		return mList.size();
	}

	@Override
	public View getItemView(int section, int position, View convertView, ViewGroup parent) {
		LinearLayout layout = null;
		if (convertView == null) {
			LayoutInflater inflator = (LayoutInflater) parent.getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			layout = (LinearLayout) inflator.inflate(R.layout.item_request_answer, null);
		} else {
			layout = (LinearLayout) convertView;
		}
		return layout;
	}

	@Override
	public View getSectionHeaderView(int section, View convertView, ViewGroup parent) {
		LinearLayout layout = null;
		if (convertView == null) {
			LayoutInflater inflator = (LayoutInflater) parent.getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			layout = (LinearLayout) inflator.inflate(R.layout.header_item, null);
		} else {
			layout = (LinearLayout) convertView;
		}
		((TextView) layout.findViewById(R.id.textItem)).setText("Header for section " + section);
		return layout;
	}

	@Override
	public void refreshNew() {
		sendRequest(null, null, 0, 0);
	}

	@Override
	public void refreshHeader(Model item, int count) {
		sendRequest(null, null, 0, 0);
		ToastUtils.showToast("刷新了头部");
	}

	@Override
	public void refreshFooter(Model item, int count) {
		sendRequest(null, null, 0,REFRESH_FOOTER);
	}

	@Override
	public int getTheCacheType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getReallyList(Object object, Class type2) {
		// TODO Auto-generated method stub
		return null;
	}

}

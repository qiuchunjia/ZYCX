package qcjlibrary.adapter;

import java.util.List;
import qcjlibrary.fragment.FragmentQclassIndex;
import qcjlibrary.fragment.FragmentQclassList;
import qcjlibrary.model.ModelQclassCategory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class QclassFragmentAdapter extends FragmentPagerAdapter {
	
	private List<ModelQclassCategory> mList;
	
	public QclassFragmentAdapter(FragmentManager fm,List<ModelQclassCategory> mList) {
		super(fm);
		this.mList = mList;
	}

	@Override
	public Fragment getItem(int position) {
		if (mList != null) {
			FragmentQclassList f = new FragmentQclassList();
			Bundle bundle = new Bundle();
			bundle.putInt("type", mList.get(position).getClass_id());
			f.setArguments(bundle);
			return f;
		}
		return null;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		if (mList != null) {
			return mList.get(position).getImooc_class_name().trim();
		}
		return null;
	}

	@Override
	public int getCount() {
		return mList.size();
	}
}
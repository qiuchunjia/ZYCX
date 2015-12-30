package qcjlibrary.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import qcjlibrary.activity.SearchNewActivity.OnSearchTouchListerer;
import qcjlibrary.config.Config;

import com.umeng.socialize.utils.Log;
import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.adapter.ZiXunListAdapter;
import com.zhiyicx.zycx.fragment.BaseListFragment;
import com.zhiyicx.zycx.activity.ZiXUnContentActivity;
import com.zhiyicx.zycx.sociax.android.Thinksns;
import com.zhiyicx.zycx.sociax.listener.OnTouchListListener;
import com.zhiyicx.zycx.sociax.unit.Anim;
import com.zhiyicx.zycx.util.Utils;
import com.zhiyicx.zycx.widget.LoadListView;
import org.json.JSONObject;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015/1/17.
 */
public class FragmentInfor extends BaseListFragment {

    private ZiXunListAdapter mAdapter;
    private LoadListView mListView;
    private String key = null;
    private boolean isLoad = false;
    private Thinksns mApp = new Thinksns();

    @Override
    public OnTouchListListener getListView() {
        return mListView;
    }

    @Override
    public void doRefreshHeader() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mCustView = inflater.inflate(R.layout.zixun_list, container, false);
        mListView = (LoadListView)mCustView.findViewById(R.id.zixun_list);
        mListView.setOnItemListener(new LoadListView.OnItemListener() {
            @Override
            public void onClick(View view, int position, long id) {
                JSONObject jsonObject = mAdapter.getItem(position-1);
                try {
                    int _id = jsonObject.getInt("id");
                    int uid = jsonObject.getInt("uid");
                    Intent intent = new Intent(mContext, ZiXUnContentActivity.class);
                    intent.putExtra("id", _id);
                    intent.putExtra("uid", uid);
                    //intent.putExtra("cid", mType);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);
                    Anim.in(mContext);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
        ArrayList<JSONObject> data = new ArrayList<JSONObject>();
        mAdapter = new ZiXunListAdapter(this, data, -2);
        mListView.setAdapter(mAdapter, System.currentTimeMillis(), mContext);
        mListView.setVisibility(View.INVISIBLE);
        return mCustView;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Cathy", "info:onResume");
        if(!isLoad){
        	loadData(false);
        }
    }

    public void doSearch(String key)
    {
        if(TextUtils.isEmpty(key))
            return;
        this.key = Utils.getUTF8String(key);
        if(mContext != null) {
            loadData(false);
        }
    }

    @Override
    public void loadData(boolean isLoadNew) {
    	if(mApp.searchAct == null){
			return;
		}
    	mApp.searchAct.setOnSearchListener(new OnSearchTouchListerer() {
			
			@Override
			public void onSearchTouch(String key, int searchType) {
				// TODO 自动生成的方法存根
				Log.d("Cathy", "info:"+key+" searchType:"+ searchType);
				if(searchType == Config.TYPE_INFO){
					Log.d("Cathy", "info:"+key);
					mAdapter.loadSearchData(key);
			        mListView.setSelectionFromTop(0, 20);
			        isLoad = true;
				}
			}
		});
        
    }
}

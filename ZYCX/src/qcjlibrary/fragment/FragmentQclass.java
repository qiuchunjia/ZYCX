package qcjlibrary.fragment;

import java.util.ArrayList;

import org.json.JSONObject;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import qcjlibrary.activity.SearchNewActivity.OnSearchTouchListerer;
import qcjlibrary.config.Config;

import com.umeng.socialize.utils.Log;
import com.zhiyicx.zycx.R;
import com.zhiyicx.zycx.adapter.QClassListAdapter;
import com.zhiyicx.zycx.fragment.BaseListFragment;
import com.zhiyicx.zycx.sociax.android.Thinksns;
import com.zhiyicx.zycx.sociax.listener.OnTouchListListener;
import com.zhiyicx.zycx.util.Utils;
import com.zhiyicx.zycx.widget.LoadListView;

/**
 * Created by Administrator on 2015/1/17.
 */
public class FragmentQclass extends BaseListFragment implements LoadListView.OnItemListener
{

    private QClassListAdapter mAdapter;
    private LoadListView mList;
    private String key = null;
    private boolean isLoad = false;
    private Thinksns mApp = new Thinksns();

    @Override
    public OnTouchListListener getListView() {
        return mList;
    }

    @Override
    public void doRefreshHeader() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        mCustView = inflater.inflate(R.layout.qclass_list_layout, container, false);
        mList = (LoadListView) mCustView.findViewById(android.R.id.list);
        ArrayList<JSONObject> data = new ArrayList<JSONObject>();
        mAdapter = new QClassListAdapter(this, data, -2);
        mList.setAdapter(mAdapter, System.currentTimeMillis(), mContext);
        mList.setOnItemListener(this);
        mList.setVisibility(View.INVISIBLE);
        return mCustView;
    }

    @Override
    public void onClick(View view, int position, long id) {
        JSONObject jsonObject = mAdapter.getItem(position-1);
        try {
//            int _id = jsonObject.getInt("course_id");
//            String img_url = jsonObject.getString("cover");
//            Intent intent = new Intent(mContext, QClassDetailsActivity.class);
//            intent.putExtra("id", _id);
//            intent.putExtra("cover", img_url);
//            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//            mContext.startActivity(intent);
//            Anim.in(mContext);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(!isLoad){
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
				Log.d("Cathy", "Qclass:"+key+" searchType:"+ searchType);
				if(searchType == Config.TYPE_QCLASS){
					Log.d("Cathy", "Qclass:"+key);
					mAdapter.loadSearchData(key);
					mList.setSelectionFromTop(0, 20);
					isLoad = true;
				}
			}
		});
        
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
}

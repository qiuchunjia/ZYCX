package qcjlibrary.api;

import com.loopj.android.http.RequestParams;

import qcjlibrary.model.ModelPeriodical;
import qcjlibrary.model.ModelPeriodicalIndex;

public interface PeriodicalIm {
	
	public static final String PERIODICAL = "Periodical";
	public static final String INDEX = "index";
	public static final String GET_DETAIL = "getDetail";
	public static final String PID = "pid";
	public static final String SHOW = "show";
	
	
	/**
	 * 期刊首页
	 * app 3g
	 * mod Periodical
	 * act index
	 * */
	public RequestParams index(ModelPeriodical mData);
	
	/**
	 * 期刊详情
	 * act getDetail
	 * */
	public RequestParams detail();
}

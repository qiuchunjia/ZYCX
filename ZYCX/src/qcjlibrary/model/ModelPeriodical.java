package qcjlibrary.model;

import org.json.JSONObject;

import qcjlibrary.model.base.Model;

public class ModelPeriodical extends Model {
	/**
	 * 期刊首页数据
	 * 
	 * @author Tan
	 * @since 1.6
	 */
	private static final long serialVersionUID = 6380840699162529788L;
	private String cover;// 首页图片
	private String periodical_num;
	private String ctime;
	private String pid;
	private String periodical_name;
	private String sort;
	private String lastsort;

	public ModelPeriodical() {
		super();
	}

	public ModelPeriodical(JSONObject data) {
		try {
			if (data.has("cover")) {
				setCover(data.getString("cover"));
			}
			if (data.has("periodical_num")) {
				setPeriodical_num(data.getString("periodical_num"));
			}
			if (data.has("ctime")) {
				setCtime(data.getString("ctime"));
			}
			if (data.has("pid")) {
				setPid(data.getString("pid"));
			}
			if (data.has("periodical_name")) {
				setPeriodical_name(data.getString("periodical_name"));
			}
			if (data.has("sort")) {
				setSort(data.getString("sort"));
			}
		} catch (Exception e) {
		}
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getPeriodical_num() {
		return periodical_num;
	}

	public void setPeriodical_num(String periodical_num) {
		this.periodical_num = periodical_num;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getPeriodical_name() {
		return periodical_name;
	}

	public void setPeriodical_name(String periodical_name) {
		this.periodical_name = periodical_name;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getLastsort() {
		return lastsort;
	}

	public void setLastsort(String lastsort) {
		this.lastsort = lastsort;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

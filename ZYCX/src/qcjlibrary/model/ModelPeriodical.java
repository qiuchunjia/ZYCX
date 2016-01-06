package qcjlibrary.model;

import qcjlibrary.model.base.Model;

public class ModelPeriodical extends Model {
	/**
	 * 期刊详情数据
	 */
	private static final long serialVersionUID = 6380840699162529788L;
	private String cover;// 首页图片
	private String periodical_num;
	private String ctime;
	private String pid;
	private String periodical_name;
	private String sort;

	
	
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
	
}

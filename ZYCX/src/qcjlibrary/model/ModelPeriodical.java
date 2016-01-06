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
	private int pid;
	private String periodical_name;
	private int sort;

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

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPeriodical_name() {
		return periodical_name;
	}

	public void setPeriodical_name(String periodical_name) {
		this.periodical_name = periodical_name;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
}

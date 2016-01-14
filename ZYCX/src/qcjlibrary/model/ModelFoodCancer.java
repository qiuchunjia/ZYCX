package qcjlibrary.model;

import qcjlibrary.model.base.Model;

/**
 * author：qiuchunjia time：上午10:20:39 类描述：这个类是实现
 *
 */

public class ModelFoodCancer extends Model {

	/**
	 * "id":"1",
"cancer_name":"肺癌",
"sort":"0"

	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String cancer_name;
	private String sort;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCancer_name() {
		return cancer_name;
	}
	public void setCancer_name(String cancer_name) {
		this.cancer_name = cancer_name;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}

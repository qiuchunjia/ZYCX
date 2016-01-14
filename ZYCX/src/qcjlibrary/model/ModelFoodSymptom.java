package qcjlibrary.model;

import qcjlibrary.model.base.Model;

/**
 * author：qiuchunjia time：上午10:20:39 类描述：这个类是实现
 *
 */

public class ModelFoodSymptom extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * "id":"1",
"symptom_name":"癌症见胸腹水",
"sort":"0"
},
	 */
	private String id;
	private String symptom_name;
	private String sort;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSymptom_name() {
		return symptom_name;
	}
	public void setSymptom_name(String symptom_name) {
		this.symptom_name = symptom_name;
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

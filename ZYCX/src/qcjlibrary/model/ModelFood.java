package qcjlibrary.model;

import qcjlibrary.model.base.Model;

/**
 * author：qiuchunjia time：上午10:20:39 类描述：这个类是实现
 *
 */

public class ModelFood extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
	private String id;
	private String type_name;
	private String sort;
	private String count;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
=======
	private String foodName;
	private String foodNum;

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodNum() {
		return foodNum;
	}

	public void setFoodNum(String foodNum) {
		this.foodNum = foodNum;
>>>>>>> 4bf5ea73991a31620f795e33af940c8d90a95782
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

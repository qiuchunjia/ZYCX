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
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

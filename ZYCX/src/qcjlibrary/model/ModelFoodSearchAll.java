package qcjlibrary.model;

import java.util.List;

import qcjlibrary.model.base.Model;

public class ModelFoodSearchAll extends Model{

	/**
	 * http://demo-qingko.zhiyicx.com/index.php?app=api&mod=Shiliao&act=all_search&key=%E6%9E%A3
	 * String key 搜索关键字 必填
	 */
	private static final long serialVersionUID = -8717391845439447075L;
	
	private List<ModelFoodSearch0> foodList;
	private List<ModelFoodSearch1> sideList;

	private String key;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public List<ModelFoodSearch0> getFoodList() {
		return foodList;
	}
	public void setFoodList(List<ModelFoodSearch0> foodList) {
		this.foodList = foodList;
	}
	public List<ModelFoodSearch1> getSideList() {
		return sideList;
	}
	public void setSideList(List<ModelFoodSearch1> sideList) {
		this.sideList = sideList;
	}
	
	
	
	
}

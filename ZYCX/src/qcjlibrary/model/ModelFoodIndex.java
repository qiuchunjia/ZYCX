package qcjlibrary.model;

import java.util.ArrayList;
import java.util.List;

import qcjlibrary.model.base.Model;

/**
 * author：qiuchunjia time：上午10:29:56 类描述：这个类是实现
 *
 */

public class ModelFoodIndex extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ModelFood> food; // 食疗
	private List<ModelFoodCategory> foodSide; // 食疗方
	private ArrayList<ModelFoodSymptom> foodSide_symptom; // 对症食疗方
	private ArrayList<ModelFoodCancer> foodSide_cancer; // 对癌食疗方

	public ModelFoodIndex() {
	}

	public List<ModelFood> getFood() {
		return food;
	}

	public void setFood(List<ModelFood> food) {
		this.food = food;
	}

	public List<ModelFoodCategory> getFoodSide() {
		return foodSide;
	}

	public void setFoodSide(List<ModelFoodCategory> foodSide) {
		this.foodSide = foodSide;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ArrayList<ModelFoodSymptom> getFoodSide_symptom() {
		return foodSide_symptom;
	}

	public ArrayList<ModelFoodCancer> getFoodSide_cancer() {
		return foodSide_cancer;
	}

	public void setFoodSide_cancer(ArrayList<ModelFoodCancer> foodSide_cancer) {
		this.foodSide_cancer = foodSide_cancer;
	}

	public void setFoodSide_symptom(ArrayList<ModelFoodSymptom> foodSide_symptom) {
		this.foodSide_symptom = foodSide_symptom;
	}

	
}

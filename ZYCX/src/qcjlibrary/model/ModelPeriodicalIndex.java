package qcjlibrary.model;

import java.util.List;

import qcjlibrary.model.base.Model;

public class ModelPeriodicalIndex extends Model{

	/**
	 * 期刊首页数据
	 * @author Tan
	 * @since 1.6
	 */
	private static final long serialVersionUID = 7767962929104215117L;
	
	private List<ModelPeriodical> data;
	
	public List<ModelPeriodical> getData() {
		return data;
	}
	public void setData(List<ModelPeriodical> data) {
		this.data = data;
	}
}

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
	
	private ModelPeriodical data;
	private List<ModelPeriodical> list;
	public ModelPeriodical getData() {
		return data;
	}
	public void setData(ModelPeriodical data) {
		this.data = data;
	}
	public List<ModelPeriodical> getList() {
		return list;
	}
	public void setList(List<ModelPeriodical> list) {
		this.list = list;
	}
	
}

package qcjlibrary.model;

import java.util.List;

import qcjlibrary.model.base.Model;

/**
 * author：qiuchunjia time：下午6:03:18 类描述：这个类是实现
 *
 */

public class ModelAddNowCase extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// diagnosis_stime 诊断起始时间
	// diagnosis_etime 诊断截止时间
	// diagnosis_hospital 检查医院
	// diagnosis_way 诊断方式
	// lab_exam_program 实验室检查项目
	// lab_exam_time 实验室检查时间
	// lab_exam_hospital 实验室检查医院
	// image_exam_program 影像学检查项目
	// image_exam_time 影像学检查时间
	// image_exam_hospital 影像学检查医院
	// 图片文件上传
	// diagnosis 诊断图片
	// lab_exam 实验室检查图片
	// image_exam 影像学检查图片
	
	private String ctime; //创建时间
	private String utime; //处理时间
	private ModelDiagnosis diagnosis;
	private ModelLab lab_exam;
	private ModelImage image_exam;
	private List<String> diagnosisList;
	private List<String> lab_examList;
	private List<String> image_examList;

	private List<ModelCaseResult> result;

	public List<String> getDiagnosisList() {
		return diagnosisList;
	}

	public void setDiagnosisList(List<String> diagnosisList) {
		this.diagnosisList = diagnosisList;
	}

	public List<String> getLab_examList() {
		return lab_examList;
	}

	public void setLab_examList(List<String> lab_examList) {
		this.lab_examList = lab_examList;
	}

	public List<String> getImage_examList() {
		return image_examList;
	}

	public void setImage_examList(List<String> image_examList) {
		this.image_examList = image_examList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<ModelCaseResult> getResult() {
		return result;
	}

	public void setResult(List<ModelCaseResult> result) {
		this.result = result;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getUtime() {
		return utime;
	}

	public void setUtime(String utime) {
		this.utime = utime;
	}

	public ModelDiagnosis getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(ModelDiagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}

	public ModelLab getLab_exam() {
		return lab_exam;
	}

	public void setLab_exam(ModelLab lab_exam) {
		this.lab_exam = lab_exam;
	}

	public ModelImage getImage_exam() {
		return image_exam;
	}

	public void setImage_exam(ModelImage image_exam) {
		this.image_exam = image_exam;
	}

	/**
	 * 每一种检查返回的结果 
	 * "list_name":"肿瘤标志物", 
	 * "field_name":"我擦嘞",
	 * "field_value":"松岛枫松岛枫松岛枫"
	 */
	public class Result {
		private String list_name;
		private String field_name;
		private String field_value;

		public String getList_name() {
			return list_name;
		}

		public void setList_name(String list_name) {
			this.list_name = list_name;
		}

		public String getField_name() {
			return field_name;
		}

		public void setField_name(String field_name) {
			this.field_name = field_name;
		}

		public String getField_value() {
			return field_value;
		}

		public void setField_value(String field_value) {
			this.field_value = field_value;
		}

	}
}

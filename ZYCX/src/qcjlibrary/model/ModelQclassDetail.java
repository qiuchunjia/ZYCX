package qcjlibrary.model;

import qcjlibrary.model.base.Model;

public class ModelQclassDetail extends Model {

	/**
	 * 轻课堂首页数据
	 * 
	 * @author Tan
	 * @since 12.31
	 */
	private static final long serialVersionUID = -2622039793984806354L;

	private String course_name;
	private int watch_num;
	private int video_num;
	private int course_id;
	private String cover;
	private String content;
	private int class_id;
	private int status;

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public int getWatch_num() {
		return watch_num;
	}

	public void setWatch_num(int watch_num) {
		this.watch_num = watch_num;
	}

	public int getVideo_num() {
		return video_num;
	}

	public void setVideo_num(int video_num) {
		this.video_num = video_num;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ModelQclass [course_name=" + course_name + ", watch_num=" + watch_num 
				+ watch_num + ", video_num=" + video_num + ", course_id=" + course_id 
				+ ", cover=" + cover + ", content=" + content + "]";
	}

}

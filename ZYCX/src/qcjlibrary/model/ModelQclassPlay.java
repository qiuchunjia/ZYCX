package qcjlibrary.model;

import qcjlibrary.model.base.Model;

public class ModelQclassPlay extends Model{

	/**
	 * 轻课堂 播放界面实体类
	 * @author Tan
	 * @since 1.4
	 */
	private static final long serialVersionUID = 4527036157566643710L;

	private int course_id;
	private String course_name;
	private String course_info;
	private String tinfo;
	private String uname;
	private int uid;
	private String avatar_small;
	private String default_comment;
	private int default_vid;
	private String default_vurl;
	private int default_id;
	/** 发送的评论**/
	private String sendContent;
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCourse_info() {
		return course_info;
	}
	public void setCourse_info(String course_info) {
		this.course_info = course_info;
	}
	public String getTinfo() {
		return tinfo;
	}
	public void setTinfo(String tinfo) {
		this.tinfo = tinfo;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getAvatar_small() {
		return avatar_small;
	}
	public void setAvatar_small(String avatar_small) {
		this.avatar_small = avatar_small;
	}
	public String getDefault_comment() {
		return default_comment;
	}
	public void setDefault_comment(String default_comment) {
		this.default_comment = default_comment;
	}
	public int getDefault_vid() {
		return default_vid;
	}
	public void setDefault_vid(int default_vid) {
		this.default_vid = default_vid;
	}
	public String getDefault_vurl() {
		return default_vurl;
	}
	public void setDefault_vurl(String default_vurl) {
		this.default_vurl = default_vurl;
	}
	public int getDefault_id() {
		return default_id;
	}
	public void setDefault_id(int default_id) {
		this.default_id = default_id;
	}
	public String getSendContent() {
		return sendContent;
	}
	public void setSendContent(String sendContent) {
		this.sendContent = sendContent;
	}
	
	
}

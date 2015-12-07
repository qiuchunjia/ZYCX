package qcjlibrary.model;

import qcjlibrary.model.base.Model;

/**
 * author：qiuchunjia time：下午3:45:29 类描述：这个类是实现
 *
 */

public class ModelRequestAnswerComom extends Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/***
	 * "answer_id":"29417", "answer_content":"你好，请问你", "time":"12-04",
	 * "uid":"8489", "user_name":"胡怀勇", "user_face":
	 * "http://qingko-img.b0.upaiyun.com/avatar/41/cc/c9/original.jpg!small.avatar.jpg?v1417435390"
	 * , "against_count":"0", "agree_count":"0", "comment_count":"0",
	 * "is_best":"0"
	 * 
	 * */
	private String answer_id;
	private String answer_content;
	private String time;
	private String uid;
	private String user_name;
	private String user_face;
	private String against_count;
	private String agree_count;
	private String comment_count;
	private String is_best;

	private String qid;
	private String Content;
	private String Auid;

	public ModelRequestAnswerComom() {
	}

	public String getQid() {
		return qid;
	}

	public void setQid(String qid) {
		this.qid = qid;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getAuid() {
		return Auid;
	}

	public void setAuid(String auid) {
		Auid = auid;
	}

	public String getAnswer_id() {
		return answer_id;
	}

	public void setAnswer_id(String answer_id) {
		this.answer_id = answer_id;
	}

	public String getAnswer_content() {
		return answer_content;
	}

	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_face() {
		return user_face;
	}

	public void setUser_face(String user_face) {
		this.user_face = user_face;
	}

	public String getAgainst_count() {
		return against_count;
	}

	public void setAgainst_count(String against_count) {
		this.against_count = against_count;
	}

	public String getAgree_count() {
		return agree_count;
	}

	public void setAgree_count(String agree_count) {
		this.agree_count = agree_count;
	}

	public String getComment_count() {
		return comment_count;
	}

	public void setComment_count(String comment_count) {
		this.comment_count = comment_count;
	}

	public String getIs_best() {
		return is_best;
	}

	public void setIs_best(String is_best) {
		this.is_best = is_best;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

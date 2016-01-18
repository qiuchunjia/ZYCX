package qcjlibrary.widget.ads;

/**
 * @author 曹立该
 */
public class MyADViewModel {

	private String imgUrl;
	private int ResouceId;
	private String bannerurl;  //点击view后需要传的值

	public String getBannerurl() {
		return bannerurl;
	}

	public void setBannerurl(String bannerurl) {
		this.bannerurl = bannerurl;
	}

	public MyADViewModel() {

	}

	public MyADViewModel(String imgUrl) {

		this.imgUrl = imgUrl;

	}

	public MyADViewModel(int resouceID) {

		this.ResouceId = resouceID;

	}

	/**
	 * @return the imgUrl
	 */
	public String getImgUrl() {
		return imgUrl;
	}

	/**
	 * @param imgUrl
	 *            the imgUrl to set
	 */
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public int getResouceId() {
		return ResouceId;
	}

	public void setResouceId(int resouceId) {
		ResouceId = resouceId;
	}

}

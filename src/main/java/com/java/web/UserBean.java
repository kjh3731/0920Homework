package com.java.web;

public class UserBean {
	private String uno;
	private String id;
	private String nickname;
	private String profile_image;
	private String thumbnail_image;
	
	public String getUno() {
		return uno;
	}
	public void setUno(String uno) {
		this.uno = uno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getProfile_image() {
		return profile_image;
	}
	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}
	public String getThumbnail_image() {
		return thumbnail_image;
	}
	public void setThumbnail_image(String thumbnail_image) {
		this.thumbnail_image = thumbnail_image;
	}
	
	@Override
	public String toString() {
		return "UserBean [uno=" + uno + ", id=" + id + ", nickname=" + nickname + ", profile_image=" + profile_image
				+ ", thumbnail_image=" + thumbnail_image + "]";
	}
}

package com.orange.peoplemanage;

import android.graphics.Bitmap;

public class ContactInfo {
	private Bitmap c_photo = null;
	private String c_name = null;
	private String c_phone = null;
	private String c_email=null;
	private String c_birthday=null;
	private String c_qq=null;
	private String c_address=null;

	public Bitmap getC_photo() {
		return c_photo;
	}

	public void setC_photo(Bitmap c_photo) {
		this.c_photo = c_photo;
	}

	public String getC_email() {
		return c_email;
	}

	public void setC_email(String c_email) {
		this.c_email = c_email;
	}

	public String getC_birthday() {
		return c_birthday;
	}

	public void setC_birthday(String c_birthday) {
		this.c_birthday = c_birthday;
	}

	public String getC_qq() {
		return c_qq;
	}

	public void setC_qq(String c_qq) {
		this.c_qq = c_qq;
	}

	public String getC_address() {
		return c_address;
	}

	public void setC_address(String c_address) {
		this.c_address = c_address;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_phone() {
		return c_phone;
	}

	public void setC_phone(String c_phone) {
		this.c_phone = c_phone;
	}

}

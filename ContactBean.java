package com.uttara.PhoneBook;

import java.util.Objects;

public class ContactBean extends Exception {

	private String name;
	private String PhoneNum;

	public ContactBean() {
		super();
	}

	public ContactBean(String name, String phoneNum) {
		super();
		setName(name);
		setPhoneNum(phoneNum);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return PhoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		PhoneNum = phoneNum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(PhoneNum, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactBean other = (ContactBean) obj;
		return Objects.equals(PhoneNum, other.PhoneNum) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "ContactBean [name=" + name + ", PhoneNum=" + PhoneNum + "]";

	}

}

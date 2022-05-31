package com.uttara.PhoneBook;

import java.util.regex.Pattern;

public class PhoneBookUtil {
	public static String validateName(String n) {
		if (n == null || n.trim().equals(""))
			throw new IllegalArgumentException("name cannot be null");
		String[] sa = n.split(" ");
		if (sa.length > 1)
			return "Enter a single string word as input!";

		for (int i = 0; i < n.length(); i++) {
			char c = n.charAt(i);
			if (!(Character.isDigit(c) || Character.isLetter(c)))
				return "Name should not contain special chars!";
		}
		return Constants.SUCCESS;
	}

	public static boolean validName(String str) {
		if (Pattern.matches("[a-zA-Z]+", str)) {
			return true;
		}
		return false;
	}

	public static boolean validPhoneNumber(String phone) {
		if (Pattern.matches("[6789]{1}[0-9]{9}", phone)) {
			return true;
		}
		return false;
	}
}

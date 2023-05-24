package com.example.test.Model;

import lombok.*;

@Data
@NoArgsConstructor
public class User {
	private String login;
	private String eMail;

	public User(String login, String eMail) {
		if (login.contains(" ")) {
			throw new IllegalArgumentException();
		} else {
			this.login = login.trim().isEmpty() ? null : login.toLowerCase();
		}
		if (eMail.contains(" ")) {
			throw new IllegalArgumentException();
		} else if (checkEmailForAnnotationPosition(eMail) && checkEmailForPointPosition(eMail)) {
			this.eMail = eMail;
		} else {
			throw new IllegalArgumentException();
		}
	}

	private boolean checkEmailForAnnotationPosition(String eMail) {
		return eMail.contains("@") && eMail.indexOf("@") == eMail.lastIndexOf("@") && eMail.indexOf("@") != 0 && eMail.indexOf("@") != eMail.length() - 1;
	}

	private boolean checkEmailForPointPosition(String eMail) {
		String str = eMail.substring(eMail.lastIndexOf("@"));
		return str.contains(".") && str.indexOf(".") == str.lastIndexOf(".") && str.indexOf(".") != 1 && str.indexOf(".") != str.length() - 1;
	}
}

package com.example.test.Model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

	private static final String CORRECT_LOGIN = "user";
	private static final String EMPTY_LOGIN = "";
	private static final String NULL_LOGIN = null;
	private static final String SPACE_LOGIN = "   ";
	private static final String LOGIN_WITH_SPACE = "us er";
	private static final String CORRECT_EMAIL = "user@yandex.ru";
	private static final String NULL_EMAIL = null;
	private static final String[] incorrectEMail = {
			"usergmail.com",
			" user gmail.com",
			"us@erg@mail.com",
			"user@g.ma.il.com",
			"useryandexru",
			"us er@gmail.com",
			"@gmail.com",
			"@.com",
			"user@.com",
			"user@gmail.",
			"   ",
			""};
	//	private static final String INCORRECT_EMAIL = "usergmail.com";
//	private static final String INCORRECT_EMAIL_1 = " user gmail.com";
//	private static final String INCORRECT_EMAIL_2 = "us@erg@mail.com";
//	private static final String INCORRECT_EMAIL_3 = "user@g.ma.il.com";
//	private static final String INCORRECT_EMAIL_4 = "useryandexru";
//	private static final String INCORRECT_EMAIL_5 = "us er@gmail.com";
//	private static final String INCORRECT_EMAIL_6 = "@gmail.com";
//	private static final String INCORRECT_EMAIL_7 = "@.com";
//	private static final String INCORRECT_EMAIL_8 = "user@.com";
//	private static final String INCORRECT_EMAIL_9 = "user@gmail.";

	@Test
	public void shouldReturnLoginWithCorrectParam() {
		User user = new User(CORRECT_LOGIN, CORRECT_EMAIL);
		Assertions.assertEquals(CORRECT_LOGIN, user.getLogin());
		Assertions.assertEquals(CORRECT_EMAIL, user.getEMail());
	}

	@Test
	public void shouldReturnLoginWithNullParam() {
		User user = new User();
		Assertions.assertEquals(NULL_LOGIN, user.getLogin());
		Assertions.assertEquals(NULL_EMAIL, user.getEMail());
	}

	@Test
	public void shouldReturnIllegalArgumentExceptionWhenEMailIncorrect() {
		for (String incorrectEMail : incorrectEMail) {
			Assertions.assertThrows(IllegalArgumentException.class, () -> new User(CORRECT_LOGIN, incorrectEMail));
		}
	}

	@Test
	public void shouldReturnCorrectEMail() {
		Assertions.assertDoesNotThrow(() -> new User(CORRECT_LOGIN, CORRECT_EMAIL));
	}

	@Test
	public void shouldReturnDifferenceBetweenLoginAndEMail() {
		User user = new User(CORRECT_LOGIN, CORRECT_EMAIL);
		Assertions.assertNotEquals(user.getLogin(), user.getEMail());
	}
}
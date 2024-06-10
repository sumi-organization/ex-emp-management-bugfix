package com.example.form;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 管理者情報登録時に使用するフォーム.
 * 
 * @author igamasayuki
 * 
 */
public class InsertAdministratorForm {
	/** 名前 */
	@NotBlank
	private String name;
	/** メールアドレス */
	@NotBlank
	@Email
	private String mailAddress;
	/** パスワード */
	@Size(min = 8,max = 22)
	private String password;
	/** 確認用パスワード */
	private String confirmPassword;

	@AssertTrue(message = "パスワードが一致していません")
	public boolean isPasswordValid() {
//    if (password == null || password.isEmpty()) {
//      return true;
//    }

		return password.equals(confirmPassword);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String password) {
		this.confirmPassword = password;
	}

	@Override
	public String toString() {
		return "InsertAdministratorForm{" +
				"name='" + name + '\'' +
				", mailAddress='" + mailAddress + '\'' +
				", password='" + password + '\'' +
				", confirmPassword='" + confirmPassword + '\'' +
				'}';
	}
}

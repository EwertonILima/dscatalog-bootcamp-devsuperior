package com.ewertonilima.dscatalog.dto;

import com.ewertonilima.dscatalog.services.validation.UserInsertValid;

@UserInsertValid
public class UserPostDTO extends UserDTO {
	private static final long serialVersionUID = 1L;

	private String password;

	public UserPostDTO() {
		super();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

package com.springboot.springbootthymeleaf.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	private String account;
	private String name;
	private String password;
	private String accountType;
	private String tel;
}

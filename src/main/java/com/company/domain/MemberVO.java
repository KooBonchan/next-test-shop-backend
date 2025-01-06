package com.company.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class MemberVO {
	long idx;
	String username;
	String password;
	String email;
	Date regDate;
}

package com.company.domain;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ReplyVO {
	long idx;
	long memberIdx;
	long itemIdx;
	String content;
	byte star;
	Timestamp regTime;
}

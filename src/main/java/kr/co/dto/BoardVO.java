package kr.co.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int bno;
	private String writer;
	private String title;
	private String content;	
	private Date regdate;	
	private Date updateDate;	
}

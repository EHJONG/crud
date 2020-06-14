package kr.co.dto;

import java.util.Date;

import lombok.Data;

@Data
public class TestDto {
	private String name;
	private String pw;
	private Date time;
	// 디비에는 name값이 저장 되지만,
	// 디비에 있는 name을 변경 하고 싶을 경우를 대비해 changingName변수도 DTO에 선언 해줬다.
	private String changingName;
}

package kr.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dao.TestServiceImpl;
import kr.co.dto.TestDto;

@Service
public class TestService {
	@Autowired
	private TestServiceImpl impl;

	public void insertId(TestDto dto) {
		// impl 객체의 insertId 메서드를 호출하여 디비에 저장한다.
		impl.insertId(dto);
	}

	public boolean selectName(String name) {
		// impl객체의 데이터를 조회하는 기능을 하는 searchName 메서드를 호출하여 리턴한다.
		// 만약 원하는 값이 DB에 저장되어 있다면 true를 반환한다.
		return impl.searchName(name);
	}
	
	public List<TestDto> list(){
		// impl객체의  list메서드를 반환하여 받는다.
		// DB에 저장되어 있는 모든 TestDto 데이터를 받아오기 위해 List 클래스를 사용했다. 
		List<TestDto> list = impl.list();
		// DB에서 받아온 모든 TestDto 정보들을 반환한다.
		return list;
	}
	public void delete(TestDto dto) {
		// DB에 저장되어 있는 dto 객체의 정보를 지운다.
		impl.delete(dto);
	}
	
	public void update(TestDto dto) {
		// DB에 저장되어 있는 dto객체의 정보를 수정한다.
		impl.update(dto);		
	}
}

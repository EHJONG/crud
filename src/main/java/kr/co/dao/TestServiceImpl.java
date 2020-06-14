package kr.co.dao;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dto.TestDto;
import kr.co.mapper.TestMapper;

// DAO 역할을 하는 클래스에는 Repository 어노테이션을 붙인다.
@Repository
public class TestServiceImpl {
	@Autowired
	private TestMapper testMapper;
	private BCrypt bCryPt;	// 비밀번호 암호화 할 때 사용 하는 클래스이다.

	public void insertId(TestDto dto) {
		if(dto.getPw()!=null) {
			// 이렇게 하면 pw2에는 암호화 되어서 값이 대입 된다. 해쉬값은 60글자로 저장이 된다.
			String pw2 = bCryPt.hashpw(dto.getPw(), BCrypt.gensalt());		
			dto.setPw(pw2);
			System.out.println("pw2 : "+pw2);
			testMapper.insertId(dto);
		}
	}

	public boolean searchName(String name) {
		// 현재 DB에 name의 값이 저장 되어 있다면 true를 반환 한다.
		boolean flag = testMapper.selectName(name);
		if (!flag) 	return flag;
		else return flag;		
	}
	
	public List<TestDto> list(){
		// DB에 저장된 TestDto 값들을 모두 반환 한다.
		return testMapper.list();
	}
	
	public void delete(TestDto dto) {	
		// DB를 삭제 하는 역할을 한다. 
		testMapper.delete(dto);
	}
	
	public void update(TestDto dto) {
		// DB를 수정 하는 역할을 한다.
		testMapper.update(dto);
	}
}

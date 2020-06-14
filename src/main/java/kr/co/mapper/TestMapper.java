package kr.co.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import kr.co.dto.BoardVO;
import kr.co.dto.TestDto;

public interface TestMapper {
	
	@Insert("INSERT INTO test_tbl(name, pw) "
			+ "VALUES (#{name}, #{pw})")
	public void insertId(TestDto dto);
	
	@Select("SELECT count(*) FROM test_tbl "
			+ "WHERE name = #{name}")
	public boolean selectName(String name);
	
	@Select("SELECT name , time FROM test_tbl LIMIT 20, 40")
	public ArrayList<TestDto> list();
	
	@Delete("DELETE FROM test_tbl where name = #{name}")
	public void delete(TestDto dto);
					 //이자리에 있는  name은 DB명이랑 똑같이  
									//	#{dto에 선언한 변수명} '{}' 중괄호 안 에 있는 변수명은 dto에 선언 한 변수명과 똑같이
									//	이 자리엔 바꿀 데이터값 			  이 자리엔 현재 DB에 있는 데이터값
	@Update("Update test_tbl set name = #{changingName} where name = #{name}")
	public void update(TestDto dto);
	
	
	@Select("SELECT * FROM tbl_board WHERE bno > 0")
	public List<BoardVO> getList(int start , RowBounds rb);
	
	@Select("SELECT * FROM tbl_board WHERE bno=#{bno}")
	public BoardVO get();
	
	
	@Select("SELECT * FROM tbl_board LIMIT startList=#{startList} , listSize=#{listSize}")
	public BoardVO getBoardList(BoardVO board);
	
	@Select("SELECT COUNT(*) FROM tbl_board")
	public int selectCount();
}

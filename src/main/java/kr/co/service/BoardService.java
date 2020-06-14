package kr.co.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import kr.co.dto.BoardVO;
import kr.co.paging.PageNavigator;

@Service
public interface BoardService {
	public List<BoardVO> getList(int start, PageNavigator navi);
	
	public BoardVO get();
	
	public int selectCount() throws Exception;
	
	public List<BoardVO> getBoardList(PageNavigator pagination, BoardVO board) throws Exception;

//	public int getBoardListCnt() throws Exception;
}

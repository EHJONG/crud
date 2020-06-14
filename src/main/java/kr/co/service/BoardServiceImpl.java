package kr.co.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dto.BoardVO;
import kr.co.mapper.TestMapper;
import kr.co.paging.PageNavigator;

@Repository
public class BoardServiceImpl implements BoardService {

	@Autowired
	private TestMapper mapper;

	@Override
	public int selectCount() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardVO get() {
		return mapper.get();
	}

	@Override
	public List<BoardVO> getList(int start , PageNavigator navi) {
		RowBounds rb = new RowBounds(navi.getStartRecord(), navi.getCountPerPage());

		return mapper.getList(start , rb);
	}

//	@Override
//	public int getBoardListCnt() throws Exception {
//		return mapper.selectCount();
//	}

	@Override
	public List<BoardVO> getBoardList(PageNavigator pagination, BoardVO board) throws Exception {
		return (List<BoardVO>) mapper.getBoardList(board);
	}
}

package kr.spring.board.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.board.dao.BoardMapper;
import kr.spring.board.domain.BoardCommand;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Resource
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardCommand> list(Map<String, Object> map) {
		return boardMapper.list(map);
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		return boardMapper.getRowCount(map);
	}

	@Override
	public void insert(BoardCommand board) {
		boardMapper.insert(board);
		
	}

	@Override
	public BoardCommand selectBoard(Integer num) {
		return boardMapper.selectBoard(num);
	}

	@Override
	public void updateHit(Integer num) {
		boardMapper.updateHit(num);
	}

	@Override
	public void update(BoardCommand board) {
		
	}

	@Override
	public void delete(Integer num) {
		
	}
	
}

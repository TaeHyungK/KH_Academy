package kr.spring.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.board.domain.BoardCommand;
import kr.spring.board.domain.BoardReplyCommand;

public interface BoardService {
	//�θ��
	@Transactional(readOnly=true)
	public List<BoardCommand> list(Map<String,Object> map);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String,Object> map);
	public void insert(BoardCommand board);
	@Transactional(readOnly=true)
	public BoardCommand selectBoard(Integer num);
	public void updateHit(Integer num);
	public void update(BoardCommand board);
	public void delete(Integer num);

	//���
	@Transactional(readOnly=true)
	public List<BoardReplyCommand> listReply(Map<String, Object> map);
	@Transactional(readOnly=true)
	public int getRowCountReply(Map<String, Object> map);
	public void insertReply(BoardReplyCommand boardReply);
	public void updateReply(BoardReplyCommand boardReply);
	public void deleteReply(Integer re_num);
}

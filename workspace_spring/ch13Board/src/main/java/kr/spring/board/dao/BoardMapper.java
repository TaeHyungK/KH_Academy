package kr.spring.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.board.domain.BoardCommand;
import kr.spring.board.domain.BoardReplyCommand;

public interface BoardMapper {
	//부모글
	public List<BoardCommand> list(Map<String,Object> map);
	public int getRowCount(Map<String,Object> map);
	@Insert("INSERT INTO spboard (num,title,content,reg_date,uploadfile,filename,ip,id) VALUES (board_seq.nextval,#{title},#{content},sysdate,#{uploadfile},#{filename},#{ip},#{id})")
	public void insert(BoardCommand board);
	@Select("SELECT * FROM spboard WHERE num=#{num}")
	public BoardCommand selectBoard(Integer num);
	@Update("UPDATE spboard SET hit=hit+1 WHERE num=#{num}")
	public void updateHit(Integer num);
	@Update("UPDATE spboard SET title=#{title},content=#{content},uploadfile=#{uploadfile,jdbcType=BLOB},filename=#{filename,jdbcType=VARCHAR},ip=#{ip} WHERE num=#{num}")
	public void update(BoardCommand board);
	@Delete("DELETE FROM spboard WHERE num=#{num}")
	public void delete(Integer num);
	
	//댓글
	public List<BoardReplyCommand> listReply(Map<String, Object> map);
	@Select("SELECT COUNT(*) FROM spboard_reply WHERE num=#{num}")
	public int getRowCountReply(Map<String, Object> map);
	@Insert("INSERT INTO spboard_reply (re_num, re_content, re_date, re_ip, num, id) VALUES (reply_seq.nextval, #{re_content}, SYSDATE, #{re_ip}, #{num}, #{id})")
	public void insertReply(BoardReplyCommand boardReply);
	@Update("UPDATE spboard_reply SET re_content=#{re_content}, re_ip=#{re_ip} WHERE re_num=#{re_num}")
	public void updateReply(BoardReplyCommand boardReply);
	@Delete("DELETE FROM spboard_reply WHERE re_num=#{re_num}")
	public void deleteReply(Integer re_num);
	
	//부모글 삭제시 댓글이 존재하면 부모글 삭제 전 댓글 삭제
	@Delete("DELETE FROM spboard_reply WHERE num=#{num}")
	public void deleteReplyByNum(Integer num);
}

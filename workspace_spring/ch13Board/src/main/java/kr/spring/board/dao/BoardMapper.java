package kr.spring.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.board.domain.BoardCommand;

public interface BoardMapper {
	//ºÎ¸ð±Û
	public List<BoardCommand> list(Map<String,Object> map);
	public int getRowCount(Map<String,Object> map);
	@Insert("INSERT INTO spboard (num,title,content,reg_date,uploadfile,filename,ip,id) VALUES (board_seq.nextval,#{title},#{content},sysdate,#{uploadfile},#{filename},#{ip},#{id})")
	public void insert(BoardCommand board);
	@Select("SELECT * FROM spboard WHERE num=#{num}")
	public BoardCommand selectBoard(Integer num);
	@Update("UPDATE spboard SET hit=hit+1 WHERE num=#{num}")
	public void updateHit(Integer num);
	public void update(BoardCommand board);
	public void delete(Integer num);
}

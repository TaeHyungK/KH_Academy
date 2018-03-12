package kr.spring.finalp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.finalp.domain.InforCommand;
import kr.spring.finalp.domain.InforReplyCommand;

public interface InforMapper {
	//부모글
	public List<InforCommand> list(Map<String,Object> map);
	public int getRowCount(Map<String,Object> map);
	@Insert("INSERT INTO INFO_BOARD(ib_num,ib_title,ib_content,ib_hit,ib_date,m_num) VALUES(ib_seq.nextval,#{ib_title},#{ib_content},#{ib_hit},sysdate,#{m_num})")
	public void insert(InforCommand infor);
	
	@Select("SELECT * FROM member WHERE m_id=#{m_id}")
	public InforCommand selectId(String m_id);
	@Select("SELECT * FROM INFO_BOARD INNER JOIN member USING(m_num) WHERE ib_num=#{ib_num}")
	public InforCommand selectNum(Integer ib_num);
	
	@Update("UPDATE INFO_BOARD SET ib_hit=ib_hit+1 WHERE ib_num=#{ib_num}")
	public void updateHit(Integer ib_num);
	@Update("UPDATE INFO_BOARD SET ib_title=#{ib_title},ib_content=#{ib_content} WHERE ib_num=#{ib_num}")
	public void update(InforCommand infor);
	@Delete("DELETE FROM INFO_BOARD WHERE ib_num=#{ib_num}")
	public void delete(Integer ib_num);
	
	//댓글
	public List<InforReplyCommand> listReply(Map<String,Object> map);
	@Select("SELECT count(*) FROM INFO_COMMENT INNER JOIN member USING(m_num) WHERE ib_num=#{ib_num}")
	public int getRowCountReply(Map<String,Object> map);
	@Insert("INSERT INTO INFO_COMMENT(if_num,ib_num,ic_content,ic_regdate,m_num) VALUES(ic_seq.nextval,#{ib_num},#{ic_content},sysdate,#{m_num})")
	public void writeReply(InforReplyCommand inforReply);
	@Update("UPDATE INFO_COMMENT set ic_content=#{ic_content} WHERE if_num=#{if_num}")
	public void updateReply(InforReplyCommand inforReply);
	@Delete("DELETE FROM INFO_COMMENT WHERE if_num=#{if_num}")
	public void deleteReply(Integer if_num);
	
	@Select("SELECT m_id FROM member WHERE m_num=#{m_num}")
	public List<String> listReplyWriter(Integer m_num);
	
	//부모글 삭제시 댓글이 존재하면 부모글 삭제 전 댓글 삭제
	@Delete("DELETE FROM INFO_COMMENT WHERE ib_num=#{ib_num}")
	public void deleteReplyByNum(Integer ib_num);
}
	
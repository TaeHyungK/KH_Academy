package kr.spring.finalp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.finalp.domain.StudyCommand;
import kr.spring.finalp.domain.StudyReplyCommand;

public interface StudyMapper {
   //부모글
   public List<StudyCommand> list(Map<String, Object> map);
   public int getRowCount(Map<String, Object> map);
   @Insert("INSERT INTO STUDY_BOARD(sb_num,sb_title,sb_content,sb_hit,sb_count,sb_date,m_num) VALUES(sb_seq.nextval,#{sb_title},#{sb_content},#{sb_hit},#{sb_count},sysdate,#{m_num})")
   public void insert(StudyCommand study);
   
   @Select("SELECT * FROM member WHERE m_id=#{m_id}")
   public StudyCommand selectId(String m_id);
   @Select("SELECT * FROM STUDY_BOARD INNER JOIN member USING(m_num) WHERE sb_num=#{sb_num}")
   public StudyCommand selectNum(Integer sb_num);
   
   @Update("UPDATE STUDY_BOARD SET sb_hit=sb_hit+1 WHERE sb_num=#{sb_num}")
   public void updateHit(Integer sb_num);
   @Update("UPDATE STUDY_BOARD SET sb_title=#{sb_title},sb_content=#{sb_content},sb_count=#{sb_count} WHERE sb_num=#{sb_num}")
   public void update(StudyCommand study);
   @Delete("DELETE FROM STUDY_BOARD WHERE sb_num=#{sb_num}")
   public void delete(Integer sb_num);
   
   //댓글
   public List<StudyReplyCommand> listReply(Map<String, Object> map);
   @Select("SELECT count(*) FROM STUDY_COMMENT INNER JOIN member USING(m_num) WHERE sb_num=#{sb_num}")
   public int getRowCountReply(Map<String, Object> map);
   @Insert("INSERT INTO STUDY_COMMENT(sc_num,sb_num,sc_content,sc_regdate,m_num) VALUES(sc_seq.nextval,#{sb_num},#{sc_content},sysdate,#{m_num})")
   public void writeReply(StudyReplyCommand studyReply);
   @Update("UPDATE STUDY_COMMENT SET sc_content=#{sc_content} WHERE sc_num=#{sc_num}")
   public void updateReply(StudyReplyCommand studyReply);
   @Delete("DELETE FROM STUDY_COMMENT WHERE sc_num=#{sc_num}")
   public void deleteReply(Integer sc_num);
   
   @Select("SELECT m_id FROM member WHERE m_num=#{m_num}")
   public List<String> listReplyWriter(Integer m_num);
   
   //부모글 삭제시 댓글이 존재하면 부모글 삭제 전 댓글 삭제
   @Delete("DELETE FROM STUDY_COMMENT WHERE sb_num=#{sb_num}")
   public void deleteReplyByNum(Integer sb_num);
}
package kr.spring.finalp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.finalp.domain.AcademyCommand;

public interface AcademyMapper {

	public List<AcademyCommand> listAcademy(Map<String,Object> map);
	public int getRowCount(Map<String,Object> map);

	@Insert("INSERT INTO academy(a_num,m_num,a_name,a_location,a_phone,a_content,a_good,a_regdate,cp_num) VALUES (a_seq.nextval, #{m_num}, #{a_name}, #{a_location}, #{a_phone}, #{a_content}, 0, sysdate, #{cp_num})")
	public void insertAcademy(AcademyCommand academy);

	@Select("SELECT * FROM academy join member using(m_num) WHERE m_id=#{m_id}")
	public AcademyCommand selectAcademy(String m_id);

	@Update("UPDATE academy SET a_name=#{a_name}, a_location=#{a_location}, a_phone=#{a_phone}, a_content=#{a_content}, cp_num=#{cp_num} where a_num=#{a_num}")
	public void updateAcademy(AcademyCommand academy);


	@Select("SELECT * FROM member where m_id=#{m_id}")
	public AcademyCommand selectAM(String id);

	@Select("SELECT * FROM academy WHERE a_num=#{a_num}")
	public AcademyCommand selectAcademyDetail(Integer a_num);

	@Update("UPDATE academy SET a_good=a_good+1 WHERE a_num=#{a_num}")
	public void updateLike(Integer a_num);

	@Select("SELECT * FROM (SELECT * FROM academy ORDER BY a_good DESC) WHERE rownum <= 5")
	public List<AcademyCommand> topListAcademy(Map<String,Object> map);
}

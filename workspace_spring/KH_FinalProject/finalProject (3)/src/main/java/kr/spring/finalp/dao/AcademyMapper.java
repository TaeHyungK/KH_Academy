package kr.spring.finalp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.finalp.domain.AcademyCommand;
import kr.spring.finalp.domain.LikedAcademyCommand;

public interface AcademyMapper {

	public List<AcademyCommand> listAcademy(Map<String,Object> map);
	public List<AcademyCommand> myLikedAcademy(Map<String, Object> map);
	public int getRowCount(Map<String,Object> map);

	@Insert("INSERT INTO academy(a_num,m_num,a_name,a_location,a_phone,a_content,a_good,a_regdate,cp_num,uploadfile,a_logo) VALUES (a_seq.nextval, #{m_num}, #{a_name}, #{a_location}, #{a_phone}, #{a_content}, 0, sysdate, #{cp_num} ,#{uploadfile},#{a_logo})")
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
	public void updateLike(@Param("a_num") Integer a_num, @Param("m_num") Integer m_num);
	
	@Update("UPDATE academy SET a_good=a_good-1 WHERE a_num=#{a_num}")
	public void updateLikeMinus(@Param("a_num") Integer a_num, @Param("m_num") Integer m_num);
	
	@Insert("INSERT INTO liked(m_num, a_num) VALUES (#{m_num}, #{a_num})")
	public void addLike(@Param("m_num") Integer m_num, @Param("a_num") Integer a_num);
	
	@Delete("DELETE FROM liked WHERE m_num = #{m_num} AND a_num = #{a_num}")
	public void removeLike(@Param("m_num") Integer m_num, @Param("a_num") Integer a_num);
	
	@Select("SELECT * FROM (SELECT * FROM academy ORDER BY a_good DESC) WHERE rownum <= 5")
	public List<AcademyCommand> topListAcademy(Map<String,Object> map);
	
	@Select("SELECT * FROM (SELECT * FROM academy ORDER BY a_good DESC) WHERE rownum <= 6")
	public List<AcademyCommand> mainTopListAcademy(Map<String,Object> map);
	
	@Select("SELECT * FROM academy join member using(m_num) WHERE a_num=#{a_num}")
	public AcademyCommand getAcademy(int a_num);
	
	@Select("SELECT * FROM liked WHERE a_num = #{a_num} AND m_num=#{m_num}")
	public LikedAcademyCommand getLikedAcademy(@Param("a_num") Integer a_num, @Param("m_num") Integer m_num);
	
	@Select("SELECT * FROM liked")
	public List<AcademyCommand> selectLiked();
}

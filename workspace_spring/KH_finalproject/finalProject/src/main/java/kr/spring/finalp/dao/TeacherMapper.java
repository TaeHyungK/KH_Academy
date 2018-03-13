package kr.spring.finalp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.finalp.domain.LikedTeacherCommand;
import kr.spring.finalp.domain.TeacherCommand;

public interface TeacherMapper {
	
	
	public List<TeacherCommand> listTeacher(Map<String,Object> map);
	
	public int getRowCount(Map<String,Object> map);
	
	//강사 등록
	@Insert("INSERT INTO teacher(t_num, a_num, t_name, t_content, t_record,t_preview,t_good,uploadfile,t_image) VALUES (t_seq.nextval,#{a_num},#{t_name},#{t_content},#{t_record},#{t_preview},#{t_good}, #{uploadfile}, #{t_image})")
	public void insertTeacher(TeacherCommand teacher);
	
	//강사 전체 정보
    @Select("SELECT t.t_num t_num, t.a_num a_num, t.t_name t_name, t.t_content t_content, t.t_record t_record, t.t_preview t_preview, t.t_good t_good, t.uploadfile uploadfile,t.t_image t_image, a.a_name a_name FROM teacher t, academy a WHERE t.a_num = a.a_num AND t.a_num = #{a_num}")
    public List<TeacherCommand> selectAllTeacher(int a_num);
	
	//학원 별 강사
	@Select("SELECT a_num FROM teacher GROUP BY a_num ")
	public List<Integer> selectA_teacher();
	
	//로그인된 학원의 강사 정보
	@Select("select * from teacher where a_num = (select a_num from academy join member using(m_num) where m_id=#{m_id})")
	public TeacherCommand selectTeacher(String m_id);
	
	//강사 상세정보
	@Select("select * from teacher join academy using(a_num) where t_num = #{t_num}")
	public TeacherCommand selectTea(Integer t_num);
	
	//강사 수정
	@Update("UPDATE teacher SET t_name=#{t_name}, t_content=#{t_content}, t_record=#{t_record},t_preview=#{t_preview},t_image=#{t_image} WHERE a_num=#{a_num} AND t_num=#{t_num}")
	public void updateTeacher(TeacherCommand teacher);
	
	//강사 삭제
	@Delete("DELETE FROM teacher WHERE a_num=#{a_num} AND t_num=#{t_num}")
	public void deleteTeacher(Map<Object,Object> map);
	
	@Select("SELECT * FROM academy JOIN member USING (m_num) WHERE m_id=#{m_id}")
	public TeacherCommand selectTM(String m_id);
	
	@Select("SELECT * FROM (SELECT * FROM teacher ORDER BY t_good DESC) WHERE rownum <= 5")
	public List<TeacherCommand> topListTeacher(Map<String,Object> map);
	
	@Select("SELECT * FROM (SELECT * FROM teacher ORDER BY t_good DESC)  join academy using(a_num) WHERE rownum <= 6")
	public List<TeacherCommand> mainTopListTeacher(Map<String,Object> map);
	
	public TeacherCommand getTeacher(Map<Object,Object> map);
	
	@Update("UPDATE teacher SET t_good=t_good+1 WHERE t_num=#{t_num}")
	public void updateLike(@Param("t_num") Integer t_num,@Param("m_num") Integer m_num);
	
	@Update("UPDATE teacher SET t_good=t_good-1 WHERE t_num=#{t_num}")
	public void updateLikeMinus(@Param("t_num") Integer t_num,@Param("m_num") Integer m_num);
	
	@Select("SELECT * FROM t_liked WHERE t_num = #{t_num} AND m_num=#{m_num}")
	public LikedTeacherCommand getLikedTeacher(@Param("m_num") Integer m_num, @Param("t_num") Integer t_num);
	
	@Select("SELECT * FROM t_liked")
	public List<TeacherCommand> selectLiked();
	
	@Insert("INSERT INTO t_liked(t_num, m_num) VALUES (#{t_num}, #{m_num})")
	public void addLike(@Param("t_num") Integer t_num, @Param("m_num") Integer m_num);
	
	@Delete("DELETE FROM t_liked WHERE t_num = #{t_num} AND m_num = #{m_num}")
	public void removeLike(@Param("t_num") Integer t_num, @Param("m_num") Integer m_num);
	
	
}

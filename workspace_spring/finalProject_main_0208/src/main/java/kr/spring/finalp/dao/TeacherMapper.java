package kr.spring.finalp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.spring.finalp.domain.TeacherCommand;

public interface TeacherMapper {
	
	
	public List<TeacherCommand> listTeacher(Map<String,Object> map);
	
	public int getRowCount(Map<String,Object> map);
	
	@Insert("INSERT INTO teacher VALUES (t_seq.nextval,#{a_num},#{t_name},#{t_content},#{t_record},#{t_preview},#{t_good})")
	public void insertTeacher(TeacherCommand teacher);
	
	@Select("select * from teacher where a_num = (select a_num from academy join member using(m_num) where m_id=#{m_id})")
	public TeacherCommand selectTeacher(String m_id);
	
	public void updateLike(Integer a_num);
	
	
	public void updateTeacher(TeacherCommand teacher);
	
	@Select("SELECT * FROM academy JOIN member USING (m_num) WHERE m_id=#{m_id}")
	public TeacherCommand selectTM(String m_id);
	
	
}

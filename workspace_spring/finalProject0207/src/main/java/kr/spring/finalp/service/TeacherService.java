package kr.spring.finalp.service;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import kr.spring.finalp.domain.AcademyCommand;
import kr.spring.finalp.domain.TeacherCommand;

@Transactional
public interface TeacherService {
	@Transactional(readOnly=true)
	public List<TeacherCommand> listTeacher(Map<String,Object> map);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String,Object> map);
	
	public void insertTeacher(TeacherCommand teacher);
	
	public TeacherCommand selectTeacher(String m_id);
	
	public void updateLike(Integer a_num);
	
	
	public void updateTeacher(TeacherCommand teacher);
	
	public TeacherCommand selectTM(String m_id);
	
}

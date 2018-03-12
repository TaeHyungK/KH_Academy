package kr.spring.finalp.service;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import kr.spring.finalp.domain.LikedTeacherCommand;
import kr.spring.finalp.domain.TeacherCommand;

@Transactional
public interface TeacherService {
	@Transactional(readOnly=true)
	public List<TeacherCommand> listTeacher(Map<String,Object> map);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String,Object> map);
	
	public void insertTeacher(TeacherCommand teacher);
	
	public TeacherCommand selectTeacher(String m_id);
	
	public TeacherCommand selectTea(Integer t_num);
	
	public void updateTeacher(TeacherCommand teacher);
	
	public void deleteTeacher(Map<Object,Object>map);
	
	public TeacherCommand selectTM(String m_id);
	
	@Transactional(readOnly=true)
	public TeacherCommand getTeacher(Map<Object,Object> map);
	
	public List<TeacherCommand> selectAllTeacher(int a_num);
	
	public List<Integer> selectA_teacher();
	
	public void updateLike(@Param("t_num") Integer t_num,@Param("m_num") Integer m_num);
	
	public void updateLikeMinus(@Param("t_num") Integer t_num,@Param("m_num") Integer m_num);
	
	public LikedTeacherCommand getLikedTeacher(@Param("m_num") Integer m_num, @Param("t_num") Integer t_num);
	 
	public List<TeacherCommand> selectLiked();
	
	public void addLike(@Param("t_num") Integer t_num, @Param("m_num") Integer m_num);
	
	public void removeLike(@Param("t_num") Integer t_num, @Param("m_num") Integer m_num);
	
}

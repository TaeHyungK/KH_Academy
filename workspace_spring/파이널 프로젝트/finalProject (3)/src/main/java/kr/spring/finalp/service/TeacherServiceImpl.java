package kr.spring.finalp.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.finalp.dao.TeacherMapper;
import kr.spring.finalp.domain.LikedTeacherCommand;
import kr.spring.finalp.domain.TeacherCommand;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService{


		@Resource
		private TeacherMapper teacherMapper;

		@Override
		public List<TeacherCommand> listTeacher(Map<String, Object> map) {
			return teacherMapper.listTeacher(map);
		}

		@Override
		public int getRowCount(Map<String, Object> map) {
			
			return teacherMapper.getRowCount(map);
			
		}

		@Override
		public void insertTeacher(TeacherCommand teacher) {
			teacherMapper.insertTeacher(teacher);
		}

		@Override
		public TeacherCommand selectTeacher(String m_id) {
			return teacherMapper.selectTeacher(m_id);
		}

		@Override
		public void updateTeacher(TeacherCommand teacher) {
			teacherMapper.updateTeacher(teacher);
		}

		@Override
		public TeacherCommand selectTM(String m_id) {
			return teacherMapper.selectTM(m_id);
		}

		@Override
		public TeacherCommand getTeacher(Map<Object,Object> map) {
			
			return teacherMapper.getTeacher(map);
		}
		
		@Override
		public void deleteTeacher(Map<Object, Object> map) {
			teacherMapper.deleteTeacher(map); 
		}
		
		@Override
		public TeacherCommand selectTea(Integer t_num) {
			return teacherMapper.selectTea(t_num);
		}
		
		@Override
		public List<Integer> selectA_teacher() {
			return teacherMapper.selectA_teacher();
		}

		@Override
		public List<TeacherCommand> selectAllTeacher(int a_num) {
			return teacherMapper.selectAllTeacher(a_num);
		}
		
		@Override
		public void updateLikeMinus(Integer t_num, Integer m_num) {
			teacherMapper.updateLikeMinus(t_num,m_num);
			teacherMapper.removeLike(t_num, m_num);
		}

		@Override
		public LikedTeacherCommand getLikedTeacher(Integer m_num, Integer t_num) {
			return teacherMapper.getLikedTeacher(m_num, t_num);
		}

		@Override
		public List<TeacherCommand> selectLiked() {
			return teacherMapper.selectLiked();
		}

		@Override
		public void addLike(Integer t_num, Integer m_num) {
			teacherMapper.addLike(t_num, m_num);
		}

		@Override
		public void removeLike(Integer t_num, Integer m_num) {
			teacherMapper.removeLike(t_num, m_num);
		}

		@Override
		public void updateLike(Integer t_num,Integer m_num) {
			teacherMapper.updateLike(t_num, m_num);
			teacherMapper.addLike(t_num, m_num);
		}

	
	
	

}

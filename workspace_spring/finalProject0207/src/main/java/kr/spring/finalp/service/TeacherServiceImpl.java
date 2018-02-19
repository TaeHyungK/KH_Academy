package kr.spring.finalp.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.finalp.dao.TeacherMapper;
import kr.spring.finalp.domain.AcademyCommand;
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
		public void updateLike(Integer a_num) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateTeacher(TeacherCommand teacher) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public TeacherCommand selectTM(String m_id) {
			return teacherMapper.selectTM(m_id);
		}
	
	
	

}

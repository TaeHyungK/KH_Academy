package kr.spring.finalp.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.finalp.dao.AcademyMapper;
import kr.spring.finalp.dao.TeacherMapper;
import kr.spring.finalp.domain.AcademyCommand;
import kr.spring.finalp.domain.TeacherCommand;

@Service("homeService")
public class HomeServiceImpl implements HomeService {

	@Resource
	private AcademyMapper academyMapper;
	@Resource
	private TeacherMapper teacherMapper;
	
	@Override
	public List<AcademyCommand> academyRank(Map<String, Object> map) {
		return academyMapper.mainTopListAcademy(map);
	}

	@Override
	public List<TeacherCommand> teacherRank(Map<String, Object> map) {
		return teacherMapper.mainTopListTeacher(map);
	}

}

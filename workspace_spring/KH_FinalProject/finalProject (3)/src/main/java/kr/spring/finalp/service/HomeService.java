package kr.spring.finalp.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.finalp.domain.AcademyCommand;
import kr.spring.finalp.domain.TeacherCommand;

public interface HomeService {
	//ÇÐ¿ø·©Å© Á¶È¸
	@Transactional(readOnly=true)
	public List<AcademyCommand> academyRank(Map<String, Object> map);
	
	//°­»ç·©Å© Á¶È¸
	@Transactional(readOnly=true)
	public List<TeacherCommand> teacherRank(Map<String, Object> map);
}

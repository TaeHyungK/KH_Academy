package kr.spring.finalp.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.finalp.domain.StudyCommand;
import kr.spring.finalp.domain.StudyReplyCommand;

public interface StudyService {
	//ºÎ¸ð±Û
	@Transactional(readOnly=true)
	public List<StudyCommand> list(Map<String, Object> map);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String, Object> map);
	public void insert(StudyCommand study);
	
	@Transactional(readOnly=true)
	public StudyCommand selectId(String m_id);
	public StudyCommand selectNum(Integer sb_num);
	
	public void updateHit(Integer sb_num);
	public void update(StudyCommand study);
	public void delete(Integer sb_num);
	
	//´ñ±Û
	@Transactional(readOnly=true)
	public List<StudyReplyCommand> listReply(Map<String,Object> map);
	@Transactional(readOnly=true)
	public int getRowCountReply(Map<String,Object> map);
	public void insertReply(StudyReplyCommand studyReply);
	public void updateReply(StudyReplyCommand studyReply);
	public void deleteReply(Integer sc_num);
	
}

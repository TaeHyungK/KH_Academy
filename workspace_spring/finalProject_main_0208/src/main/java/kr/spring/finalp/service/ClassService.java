package kr.spring.finalp.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.finalp.domain.ClassCommand;

@Transactional
public interface ClassService {
	@Transactional(readOnly=true)
	public List<ClassCommand> listClass(Map<String,Object> map);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String,Object> map);
	
	public void insertClass(ClassCommand Class);
	
	public ClassCommand selectClass(Integer a_num);
	
	public void updateLike(Integer a_num);
	
	
	public void updateClass(ClassCommand Class);
	
	public ClassCommand selectCM(String m_id);
	

}

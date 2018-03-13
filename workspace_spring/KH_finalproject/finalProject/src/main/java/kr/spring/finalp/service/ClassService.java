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
	
	public List<ClassCommand> selectClass(Map<String,Object> map);
	
	public int getListRowCount(Map<String,Object> map);
	
	public void updateLike(Integer a_num);
	
	
	public void updateClass(ClassCommand Class);
	
	public ClassCommand selectCM(String m_id);
	
	public List<ClassCommand> listTnum(String m_id);
	
	public int compareClass(Map<Object,Object> map);
	
	public void getClass(ClassCommand Class);
	
	public List<ClassCommand> selectGet(String m_id);
	
	public void deleteMyClass(Integer my_num);
	
	public void classComplete(Map<Object,Object> map);
	
	public List<ClassCommand> selectComplete(Integer m_num);
	
	public void updateC_count(Integer c_num);
	
	public ClassCommand updateCompare(Map<Object,Object> map);
	
	public void deleteClass(Map<Object,Object> map);
	
	public int compareComplete(Integer c_num);
}

package kr.spring.finalp.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.finalp.dao.ClassMapper;
import kr.spring.finalp.domain.ClassCommand;
import kr.spring.finalp.domain.TeacherCommand;

@Service("classService")
public class ClassServiceImpl implements ClassService {
	
	@Resource
	private ClassMapper classMapper;

	@Override
	public List<ClassCommand> listClass(Map<String, Object> map) {
		return classMapper.listClass(map);
	}

	@Override
	public int getRowCount(Map<String, Object> map) {
		return classMapper.getRowCount(map);
	}

	@Override
	public void insertClass(ClassCommand Class) {
		classMapper.insertClass(Class);
	}



	@Override
	public void updateLike(Integer a_num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateClass(ClassCommand Class) {
		classMapper.updateClass(Class);		
	}

	@Override
	public ClassCommand selectCM(String m_id) {
		return classMapper.selectCM(m_id);
	}

	@Override
	public List<ClassCommand> listTnum(String m_id) {
		return classMapper.listTnum(m_id);
	}

	@Override
	public List<ClassCommand> selectClass(Map<String, Object> map) {
		return classMapper.selectClass(map);
	}

	@Override
	public int getListRowCount(Map<String, Object> map) {
		return classMapper.getListRowCount(map);
	}

	@Override
	public void getClass(ClassCommand Class) {
			classMapper.getClass(Class);
	}

	@Override
	public List<ClassCommand> selectGet(String m_id) {
		return classMapper.selectGet(m_id);
	}

	@Override
	public void deleteMyClass(Integer my_num) {
		classMapper.deleteMyClass(my_num);
	}

	@Override
	public void classComplete(Map<Object,Object> map) {
		classMapper.classComplete(map);
	}

	@Override
	public int compareClass(Map<Object, Object> map) {
		return classMapper.compareClass(map);
	}
	@Override
	public List<ClassCommand> selectComplete(Integer m_num) {
		return classMapper.selectComplete(m_num);
	}
	
	@Override
	public void updateC_count(Integer c_num) {
		classMapper.updateC_count(c_num);
	}

	@Override
	public ClassCommand updateCompare(Map<Object, Object> map) {
		return classMapper.updateCompare(map);
	}

	@Override
	public void deleteClass(Map<Object, Object> map) {
		classMapper.deleteClass(map);
	}

	@Override
	public int compareComplete(Integer c_num) {
		return classMapper.compareComplete(c_num);
	}

}

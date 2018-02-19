package kr.spring.finalp.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.finalp.dao.ClassMapper;
import kr.spring.finalp.domain.ClassCommand;

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
	public ClassCommand selectClass(Integer a_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateLike(Integer a_num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateClass(ClassCommand Class) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClassCommand selectCM(String m_id) {
		return classMapper.selectCM(m_id);
	}

}

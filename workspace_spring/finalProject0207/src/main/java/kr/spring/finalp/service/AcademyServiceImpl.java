package kr.spring.finalp.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.finalp.dao.AcademyMapper;
import kr.spring.finalp.domain.AcademyCommand;

@Service("academyService")
public class AcademyServiceImpl implements AcademyService{

	@Resource
	private AcademyMapper academyMapper;

	@Override
	public List<AcademyCommand> listAcademy(Map<String, Object> map) {
	
		return academyMapper.listAcademy(map);
	}
	
	@Override
	public int getRowCount(Map<String, Object> map) {
		
		return academyMapper.getRowCount(map);
	}

	@Override
	public void insertAcademy(AcademyCommand academy) {
		academyMapper.insertAcademy(academy);
	}

	@Override
	public AcademyCommand selectAcademy(String m_id) {
		
		return academyMapper.selectAcademy(m_id);
	}

	@Override
	public void updateLike(Integer a_num) {
		academyMapper.updateLike(a_num);
		
	}

	@Override
	public void updateAcademy(AcademyCommand academy) {
		academyMapper.updateAcademy(academy);
		
	}
 
	@Override
	public AcademyCommand selectAM(String id) {
		 
		return academyMapper.selectAM(id);
	}

	@Override
	public AcademyCommand selectAcademyDetail(Integer a_num) {
		return academyMapper.selectAcademyDetail(a_num);
	}

	@Override
	public List<AcademyCommand> topListAcademy(Map<String, Object> map) {
		return academyMapper.topListAcademy(map);
	} 

}

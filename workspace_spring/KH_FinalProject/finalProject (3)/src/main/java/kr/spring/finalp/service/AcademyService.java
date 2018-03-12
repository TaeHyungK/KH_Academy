package kr.spring.finalp.service;


import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.finalp.domain.AcademyCommand;
import kr.spring.finalp.domain.LikedAcademyCommand;

public interface AcademyService {
	@Transactional(readOnly=true)
	public List<AcademyCommand> listAcademy(Map<String,Object> map);
	@Transactional(readOnly=true)
	public List<AcademyCommand> myLikedAcademy(Map<String, Object> map);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String,Object> map);
	public void insertAcademy(AcademyCommand academy);
	@Transactional(readOnly=true)
	public AcademyCommand selectAcademy(String m_id);
	
	public void updateLike(Integer a_num, Integer m_num);
	public void updateLikeMinus(Integer a_num, Integer m_num);
	
	public void addLike(Integer m_num, Integer a_num);
	public void removeLike(Integer m_num, Integer a_num);

	public LikedAcademyCommand getLikedAcademy(Integer m_num, Integer a_num);
	
	public void updateAcademy(AcademyCommand academy);

	public AcademyCommand selectAM(String id);

	@Transactional(readOnly=true)
	public AcademyCommand selectAcademyDetail(Integer a_num);

	@Transactional(readOnly=true)
	public List<AcademyCommand> topListAcademy(Map<String,Object> map);
	
	@Transactional(readOnly=true)
	public AcademyCommand getAcademy(int a_num);
	
	public List<AcademyCommand> selectLiked();

}

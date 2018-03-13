package kr.spring.finalp.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.finalp.domain.InforCommand;
import kr.spring.finalp.domain.InforReplyCommand;

public interface InforService {
	//ºÎ¸ð±Û
	@Transactional(readOnly=true)
	public List<InforCommand> list(Map<String,Object> map);
	@Transactional(readOnly=true)
	public int getRowCount(Map<String,Object> map);
	public void insert(InforCommand infor);
	@Transactional(readOnly=true)
	
	public InforCommand selectId(String m_id);
	public InforCommand selectNum(Integer ib_num);
	
	public void updateHit(Integer ib_num);
	public void update(InforCommand infor);
	public void delete(Integer ib_num);
	
	//´ñ±Û
	@Transactional(readOnly=true)
	public List<InforReplyCommand> listReply(Map<String,Object> Map);
	@Transactional(readOnly=true)
	public int getRowCountReply(Map<String,Object> map);
	public void insertReply(InforReplyCommand inforReply);
	public void updateReply(InforReplyCommand inforReply);
	public void deleteReply(Integer if_num);
}

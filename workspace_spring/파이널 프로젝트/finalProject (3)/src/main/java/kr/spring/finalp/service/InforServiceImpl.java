package kr.spring.finalp.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.finalp.dao.InforMapper;
import kr.spring.finalp.domain.InforCommand;
import kr.spring.finalp.domain.InforReplyCommand;

@Service("InforService")
public  class InforServiceImpl implements InforService{
	
	@Resource
	private InforMapper inforMapper;
	
	@Override
	public List<InforCommand> list(Map<String,Object> map){
		
		return inforMapper.list(map);
	}
	
	@Override
	public int getRowCount(Map<String, Object> map) {
		
		return inforMapper.getRowCount(map);
	}
	
	@Override
	public void insert(InforCommand infor) {
		inforMapper.insert(infor);
	}
	
	@Override
	public void updateHit(Integer ib_num) {
		inforMapper.updateHit(ib_num);
	}
	
	@Override
	public void update(InforCommand infor) {
		inforMapper.update(infor);
	}
	
	@Override
	public void delete(Integer ib_num) {
		inforMapper.deleteReplyByNum(ib_num);
		inforMapper.delete(ib_num);
	}
	
	@Override
	public List<InforReplyCommand> listReply(Map<String,Object> map){
		return inforMapper.listReply(map);
	}
	
	@Override
	public int getRowCountReply(Map<String,Object> map) {
		int count=inforMapper.getRowCountReply(map);
		return count;
	}
	
	@Override
	public void insertReply(InforReplyCommand inforReply) {
		inforMapper.writeReply(inforReply);
	}
	
	@Override
	public void updateReply(InforReplyCommand inforReply) {
		inforMapper.updateReply(inforReply);
	}
	
	@Override
	public void deleteReply(Integer if_num) {
		inforMapper.deleteReply(if_num);
	}

	@Override
	public InforCommand selectId(String m_id) {
		return inforMapper.selectId(m_id);
	}
	
	@Override
	public InforCommand selectNum(Integer ib_num) {
		return inforMapper.selectNum(ib_num);
	}
}


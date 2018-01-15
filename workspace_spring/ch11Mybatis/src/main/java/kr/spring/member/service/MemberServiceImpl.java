package kr.spring.member.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;


import kr.spring.member.dao.MemberMapper;
import kr.spring.member.domain.MemberCommand;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Resource
	private MemberMapper memberMapper;
	
	@Override
	public void insertMember(MemberCommand member) {
		memberMapper.insertMember(member);
	}

	@Override
	public int getMemberCount() {
		return memberMapper.getMemberCount();
	}

	@Override
	public List<MemberCommand> getMemberList(Map<String,Object> map) {
		return memberMapper.getMemberList(map);
	}

	@Override
	public MemberCommand getMember(String id) {
		return memberMapper.getMember(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateMember(MemberCommand member) {		
		memberMapper.updateMember(member);
				
	}

	@Override
	public void deleteMember(String id) {
		memberMapper.deleteMember(id);
	}

}





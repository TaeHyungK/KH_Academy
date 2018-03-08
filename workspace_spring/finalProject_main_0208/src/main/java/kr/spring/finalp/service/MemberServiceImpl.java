package kr.spring.finalp.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.finalp.dao.MemberMapper;
import kr.spring.finalp.domain.MemberCommand;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Resource
	private MemberMapper memberMapper;
	
	
	@Override
	public void insert(MemberCommand member) {
		memberMapper.insert(member);
		memberMapper.insertDetail(member);	
	}

	@Override
	public MemberCommand selectMember(String id) {
		return memberMapper.selectMember(id);
	}

	@Override
	public void update(MemberCommand member) {
		memberMapper.update(member);
		
	}

	@Override 
	public void delete(int num) {
		memberMapper.delete(num);
		memberMapper.deleteDetail(num);
		System.out.println("ff");
	}
}
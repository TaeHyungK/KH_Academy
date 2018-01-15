package kr.spring.member.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.member.dao.MemberMapper;
import kr.spring.member.domain.MemberCommand;

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
		return null;
	}

	@Override
	public void update(MemberCommand member) {
		
	}

	@Override
	public void delete(String id) {
		
	}

}

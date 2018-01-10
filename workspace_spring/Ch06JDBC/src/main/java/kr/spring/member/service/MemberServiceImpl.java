package kr.spring.member.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.member.dao.MemberDao;
import kr.spring.member.domain.MemberCommand;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Resource
	private MemberDao memberDao;
	
	
	@Override
	public void insertrMember(MemberCommand member) {
		memberDao.insertrMember(member);
		
	}

	@Override
	public int getMemberCount() {

		return memberDao.getMemberCount();
	}

	@Override
	public List<MemberCommand> getMemberList(int startRow, int endRow) {
		
		return memberDao.getMemberList(startRow, endRow);
	}

	@Override
	public MemberCommand getMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMember(MemberCommand member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(String id) {
		// TODO Auto-generated method stub
		
	}

}

package kr.spring.member.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import kr.spring.member.dao.MemberDao;
import kr.spring.member.domain.MemberCommand;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Resource
	private MemberDao memberDao;
	
	@Override
	public void insertMember(MemberCommand member) {
		memberDao.insertMember(member);
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
		return memberDao.getMember(id);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateMember(MemberCommand member) {
		
		memberDao.updateMember(member);
		//트랜잭션 테스트 용으로 insertMember 호출
		memberDao.insertMember(member);
				
	}

	@Override
	public void deleteMember(String id) {
		memberDao.deleteMember(id);
	}

}





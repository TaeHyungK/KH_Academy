package kr.spring.member.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.atomikos.icatch.event.transaction.TransactionAbortedEvent;

import kr.spring.member.dao.MemberDao;
import kr.spring.member.domain.MemberCommand;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Resource
	private MemberDao memberDao;
	
	@Autowired
	private TransactionTemplate transactionTemplate;
	
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
	public void updateMember(final MemberCommand member) {
		transactionTemplate.execute(new TransactionCallback<Object>() {
			//트랜잭션 처리
			@Override
			public Object doInTransaction(TransactionStatus status) {
				memberDao.updateMember(member);
				memberDao.insertMember(member);
				
				return new Object();
			}
			
		});
	}

	@Override
	public void deleteMember(String id) {
		memberDao.deleteMember(id);
	}

}





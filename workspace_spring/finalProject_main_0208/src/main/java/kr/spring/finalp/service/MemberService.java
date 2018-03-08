package kr.spring.finalp.service;

import org.springframework.transaction.annotation.Transactional;

import kr.spring.finalp.domain.AcademyCommand;
import kr.spring.finalp.domain.MemberCommand;

public interface MemberService {
	public void insert(MemberCommand member);
	@Transactional(readOnly=true)
	public MemberCommand selectMember(String id);
	public void update(MemberCommand member);
	public void delete(int num); 
}
 
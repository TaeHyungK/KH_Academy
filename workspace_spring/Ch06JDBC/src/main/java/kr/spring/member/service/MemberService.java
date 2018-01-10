package kr.spring.member.service;

import java.util.List;

import kr.spring.member.domain.MemberCommand;

public interface MemberService {
	public void insertrMember(MemberCommand member);
	public int getMemberCount();
	public List<MemberCommand>getMemberList(int startRow, int endRow);
	public MemberCommand getMember(String id);
	public void updateMember(MemberCommand member);
	public void deleteMember(String id);
}
 
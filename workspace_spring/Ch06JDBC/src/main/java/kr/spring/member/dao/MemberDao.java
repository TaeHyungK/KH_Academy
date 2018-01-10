package kr.spring.member.dao;

import java.util.List;

import kr.spring.member.domain.MemberCommand;

public interface MemberDao {
	public void insertrMember(MemberCommand member);
	public int getMemberCount();
	public List<MemberCommand>getMemberList(int startRow, int endRow);
	public MemberCommand getMember(String id);
	public void updateMember(MemberCommand member);
	public void deleteMember(String id);
}

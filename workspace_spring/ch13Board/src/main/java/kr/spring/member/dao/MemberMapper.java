package kr.spring.member.dao;

import org.apache.ibatis.annotations.Insert;

import kr.spring.member.domain.MemberCommand;

public interface MemberMapper {
	@Insert("INSERT INTO spmember (id) VALUES (#{id})")
	public void insert(MemberCommand member);
	@Insert("INSERT INTO spmember_detail (id,name,passwd,phone,email,zipcode,address1,address2,reg_date) "
			+ "VALUES(#{id},#{name},#{passwd},#{phone},#{email},#{zipcode},#{address1},#{address2},sysdate)")
	public void insertDetail(MemberCommand member);
	public MemberCommand selectMember(String id);
	public void update(MemberCommand member);
	public void delete(String id);
	public void deleteDetail(String id);
		
}

package kr.spring.finalp.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.finalp.domain.MemberCommand;

public interface MemberMapper {
	@Insert("insert into member values(m_seq.nextval,#{m_id},#{m_group})")
	public void insert(MemberCommand member);
	
	@Insert("insert into member_detail(m_num,m_pw,m_name,m_phone,m_email,m_address,m_regdate) values(m_seq.currval,#{m_pw},#{m_name},#{m_phone},#{m_email},#{m_address},sysdate)")
	public void insertDetail(MemberCommand member);
	
	@Select("select * from member join member_detail using(m_num) where m_id=#{m_id}")
	public MemberCommand selectMember(String id);
	
	@Update("update member_detail set m_name=#{m_name},m_pw=#{m_pw},m_phone=#{m_phone},m_email=#{m_email},m_address=#{m_address} where m_num=#{m_num}")
	public void update(MemberCommand member);
	
	@Update("update member set m_group=0 where m_num=#{m_num}")
	public void delete(int num);
	@Delete("delete from member_detail where m_num=#{m_num}")
	public void deleteDetail(int num);
}
 
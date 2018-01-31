package kr.spring.member.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.member.domain.MemberCommand;

public interface MemberMapper {
	@Insert("insert into spmember (id) values(#{id})")
	public void insert(MemberCommand member);
	@Insert("insert into spmember_detail(id,name,passwd,phone,email,zipcode,address1,address2,reg_date) values(#{id},#{name},#{passwd},#{phone},#{email},#{zipcode},#{address1},#{address2},sysdate)")
	public void insertDetail(MemberCommand member);
	@Select("select * from spmember m left outer join spmember_detail d on m.id=d.id where m.id=#{id}")
	public MemberCommand selectMember(String id);
	@Update("update spmember_detail set name=#{name},passwd=#{passwd},phone=#{phone},email=#{email},zipcode=#{zipcode},address1=#{address1},address2=#{address2} where id=#{id}")
	public void update(MemberCommand member);
	@Update("update spmember set auth=0 where id=#{id}")
	public void delete(String id);
	@Delete("delete from spmember_detail where id=#{id}")
	public void deleteDetail(String id);
}

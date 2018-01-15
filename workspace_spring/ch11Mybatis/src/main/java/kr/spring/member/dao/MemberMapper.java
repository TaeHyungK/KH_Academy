package kr.spring.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.member.domain.MemberCommand;

public interface MemberMapper {
	public List<MemberCommand> getMemberList(Map<String,Object> map);
	@Select("SELECT count(*) FROM zmember")
	public int getMemberCount();
	@Insert("INSERT INTO zmember (id,passwd,name,reg_date) VALUES(#{id},#{passwd},#{name},sysdate)")
	public void insertMember(MemberCommand memberCommand);
	@Select("SELECT * FROM zmember WHERE id = #{id}")
	public MemberCommand getMember(String id);
	@Update("UPDATE zmember SET passwd=#{passwd},name=#{name} WHERE id=#{id}")
	public void updateMember(MemberCommand mebmer);
	@Delete("DELETE FROM zmember WHERE id = #{id}")
	public void deleteMember(String id);
}
